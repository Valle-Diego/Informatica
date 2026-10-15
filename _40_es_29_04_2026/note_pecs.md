# Note — GenericBox\<T\> e il pattern PECS

> Riferimento: Joshua Bloch — *Effective Java*, 3rd ed., Item 31.

---

## Cos'è PECS

**Producer Extends, Consumer Super** è la regola che governa l'uso dei wildcard nei generics Java.

| Ruolo | Wildcard | Motivazione |
|-------|----------|-------------|
| La struttura **produce** elementi (li leggiamo) | `<? extends T>` | Garantisce che ogni elemento sia almeno un `T` |
| La struttura **consuma** elementi (ci scriviamo) | `<? super T>` | Garantisce che `T` sia accettato come argomento |

Se una struttura fa entrambe le cose non si usa wildcard: si usa il tipo esatto `T`.

---

## Analisi dei metodi

### Requisito 2 — `loadFrom(List<? extends T> source)`

`source` è un **produttore**: la box legge da essa e non ci scrive mai. Si usa `extends`.

```java
public void loadFrom(List<? extends T> source) {
    items.addAll(source);
    // addAll(Collection<? extends T>) — compatibile per design
}
```

Effetto: una `GenericBox<Measurement>` può ricevere una `List<Temperature>`,
una `List<Pressure>` o qualsiasi altra lista di sottotipi di `Measurement`.

---

### Requisito 3 — `dumpTo(List<? super T> dest)`

`dest` è un **consumatore**: la box ci scrive, non legge da essa. Si usa `super`.

```java
public void dumpTo(List<? super T> dest) {
    dest.addAll(items);
    items.clear();
}
```

Effetto: una `GenericBox<Temperature>` può scrivere in una `List<Measurement>`,
in una `List<Object>`, o in qualsiasi lista di supertipi di `Temperature`.

---

### Requisito 4 — `merge(List<? extends GenericBox<? extends T>> boxes)`

Qui si applicano **due livelli** di `extends`:

- **Outer** `List<? extends GenericBox<...>>`: la lista produce box, non le consuma.
- **Inner** `GenericBox<? extends T>`: ogni box produce elementi di (sotto)tipo `T`.

```java
public static <T> GenericBox<T> merge(
        List<? extends GenericBox<? extends T>> boxes) {
    GenericBox<T> result = new GenericBox<>();
    for (GenericBox<? extends T> box : boxes) {
        result.loadFrom(box.items);   // box.items è List<? extends T>
    }
    return result;
}
```

Grazie ai due livelli di `extends`, non serve alcun cast esplicito: il compilatore
riconosce che `box.items` soddisfa il bound `List<? extends T>` richiesto da `loadFrom`.

---

### Requisito 5 — `count(Predicate<? super T> pred)`

`pred` **consuma** `T` (lo riceve in `test(T)`): si usa `super`.

```java
public int count(Predicate<? super T> pred) {
    int n = 0;
    for (T item : items) {
        if (pred.test(item)) n++;
    }
    return n;
}
```

Effetto: su una `GenericBox<Temperature>` si può passare un `Predicate<Measurement>`
o persino un `Predicate<Object>`, aumentando la riusabilità.

---

## Checklist pre-consegna

- [x] Il file si chiama `GenericBox.java` e contiene anche `Measurement`, `Temperature`, `Pressure`, `Humidity`
- [x] `loadFrom` accetta `List<Temperature>` quando `T = Measurement`
- [x] `dumpTo` scrive correttamente in `List<Measurement>` e in `List<Object>`
- [x] `merge` unisce box di `Temperature` e `Pressure` in una `GenericBox<Measurement>`
- [x] `count` funziona con `Predicate<Object>` su una `GenericBox<Measurement>`
- [x] Il `main` compila, gira senza eccezioni e stampa il numero corretto di elementi
- [x] Nessun cast esplicito, nessun raw type → nessun warning con `-Xlint:unchecked`

---

## Output atteso del main

```
tempBox dopo loadFrom: 3 elementi
pressBox dopo loadFrom: 2 elementi
merged dopo merge: 5 elementi
count(sempre true): 5
count(instanceof Temperature): 3
destination dopo dumpTo: 5 elementi
merged dopo dumpTo (svuotata): 0 elementi
mBox dopo loadFrom<Temperature>: 3 elementi

Tutti i test superati. Nessun cast esplicito, nessun raw type.
```
