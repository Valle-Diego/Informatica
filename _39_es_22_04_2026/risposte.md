# Risposte — Laboratorio Java: I Treni e la Programmazione a Oggetti

---

## Esercizio 1 — Domande di comprensione sulla classe Treno

**a) Quanti attributi ha la classe Treno? Elencali:**

La classe `Treno` ha **5 attributi**:
1. `codice` (String) — il codice identificativo del treno, es. "FR9600"
2. `destinazione` (String) — la città di destinazione, es. "Roma"
3. `postiTotali` (int) — il numero totale di posti disponibili
4. `postiOccupati` (int) — quanti posti sono già stati prenotati
5. `inRitardo` (boolean) — true se il treno è in ritardo, false altrimenti

---

**b) Cosa fa il metodo `prenota()`? Quando ritorna `false`?**

Il metodo `prenota()` verifica se ci sono ancora posti disponibili sul treno. Se `postiOccupati < postiTotali`, incrementa di 1 il contatore `postiOccupati` e restituisce `true` (prenotazione riuscita). Ritorna `false` quando il treno è **pieno**, cioè quando `postiOccupati` è già uguale a `postiTotali`: in quel caso non modifica nulla.

---

**c) Se creo `Treno t = new Treno("R101", "Brescia", 200)`, quanti posti liberi ha inizialmente?**

**200 posti liberi.** Il costruttore inizializza `postiOccupati = 0`, quindi `getPostiLiberi()` restituisce `postiTotali - postiOccupati = 200 - 0 = 200`.

---

## Esercizio 3 — Domanda di ragionamento su `isSaturo()`

Dopo 3 prenotazioni su un treno da 400 posti:

- `postiOccupati = 3`
- Soglia di saturazione: `400 * 0.80 = 320`
- Condizione: `3 >= 320` → **falsa**

`isSaturo()` ritorna **`false`**: il treno ha ancora moltissimi posti disponibili.

---

## Esercizio 6 — Domanda di riflessione sull'ereditarietà

**Perché `milano.aggiungiTreno(av)` funziona anche se `av` è un `TrenoAltaVelocita` e il metodo si aspetta un `Treno`?**

Perché `TrenoAltaVelocita` **estende** `Treno` (tramite `extends`). In Java vige il principio di **sostituzione di Liskov**: ovunque sia atteso un oggetto di tipo `Treno`, si può usare qualsiasi oggetto di una sua sottoclasse. `TrenoAltaVelocita` *è* un `Treno` a tutti gli effetti — ha tutti i suoi metodi e attributi, più i propri. Il compilatore accetta quindi il passaggio di `av` senza alcun cast esplicito.

---

## Domande Finali di Verifica (D1–D5)

**D1. Qual è la differenza tra una classe e un oggetto?**

Una **classe** è il "progetto" o lo stampo: descrive la struttura (attributi) e il comportamento (metodi) di una categoria di oggetti, ma non esiste in memoria come entità concreta. Un **oggetto** è un'istanza concreta creata da quella classe, con i propri valori per ogni attributo.

*Esempio con i treni:* `Treno` è la classe — dice che ogni treno ha un codice, una destinazione, dei posti. `fr9600` (creato con `new Treno("FR9600", "Roma", 400)`) è l'oggetto concreto: il Frecciarossa delle 06:00 per Roma, con 400 posti reali.

---

**D2. Cosa succede se chiami `prenota()` su un treno con 0 posti liberi?**

Risposta corretta: **b) Ritorna `false` senza modificare nulla.**

La condizione `postiOccupati < postiTotali` è falsa (sono uguali), quindi il blocco `if` non viene eseguito e il metodo restituisce direttamente `false`. Il valore di `postiOccupati` rimane invariato; non viene lanciata nessuna eccezione.

---

**D3. Cosa significa `private` davanti a un attributo? Perché è importante usarlo?**

`private` significa che quell'attributo è accessibile **solo dall'interno della stessa classe**: nessun'altra classe può leggerlo o modificarlo direttamente. È importante perché garantisce **incapsulamento**: lo stato interno dell'oggetto è protetto da modifiche accidentali o non autorizzate. Chi vuole interagire con l'attributo deve usare i metodi pubblici (getter/setter) che possono applicare controlli e logica, mantenendo l'oggetto sempre in uno stato coerente.

---

**D4. Un `TrenoAltaVelocita` può essere aggiunto a un `ArrayList<Treno>`?**

Risposta corretta: **b) Sì, perché `TrenoAltaVelocita` estende `Treno`.**

Grazie all'ereditarietà, un oggetto di una sottoclasse è compatibile con il tipo della superclasse. Non è necessario alcun cast esplicito.

---

**D5. Nel `for-each` `for (Treno t : treniPresenti)`, cosa rappresenta `t` ad ogni iterazione?**

Risposta corretta: **b) Un riferimento a ciascun `Treno` nella lista, uno alla volta.**

Ad ogni ciclo, la variabile `t` punta a un diverso elemento dell'`ArrayList`. Non è un indice numerico né una copia del nome: è un riferimento all'oggetto stesso, sul quale si possono chiamare tutti i suoi metodi (es. `t.getCodice()`, `t.isInRitardo()`).
