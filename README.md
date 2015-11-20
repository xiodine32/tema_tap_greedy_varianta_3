# Tehnici Avansate de Programare

Tema 4 - Varianta 3

# Cerinte

1. Considerăm următorul joc pentru două persoane. Tabla de joc este o secvenţă de n numere
întregi pozitive, iar cei doi jucători mută alternativ. Când un jucător mută, el selectează un număr ori
de la stânga ori de la dreapta secvenţei. Numărul selectat este şters de pe tablă. Jocul se termină când
toate numerele au fost selectate. Primul jucător câştigă dacă suma numerelor pe care le-a selectat este
cel puţin egală cu suma selectată de al doilea jucător. Al doilea jucător joacă cât de bine poate.
Primul jucător începe jocul. Ştim că tablă se află la început un număr par de elemente n. Să se scrie
un program astfel încât, indiferent cum va juca al doilea jucător, primul jucător câştigă. Scrieţi
programul astfel încât primul jucător să mute cu ajutorul programului, iar calculatorul să mute
aleator de la stânga sau de la dreapta. La ieşire se va scrie suma obţinută de primul jucător, suma
obţinută de cea de al doilea şi secvenţele de mutări sub forma unor şiruri cu caracterele S pentru
stânga şi D pentru dreapta. Exemplu: pentru tabla cu numerele 2 1 4 3 o soluţie câştigătoare este
următoarea:
Pasul 1 - primul jucător alege S (valoarea 2); rămân pe tablă 1 4 3
Pasul 2 - calculatorul are două posibilităţi: S (valoarea 1) sau D (valoarea 3).
Pasul 3 – dacă la pasul 2 calculatorul a ales S, atunci primul jucător alege S (valoarea 4);
dacă la pasul 2 calculatorul a ales D, atunci primul jucător alege D (valoarea 4);
Pasul 4 – pe tablă a mai rămas doar o valoare (3 respectiv 1, în funcţie de alegerea de la pasul 2),
pe care o alege calculatorul
Astfel, primul jucător a adunat suma 2+4, iar calculatorul suma 1+3 (respective 3+1), deci primul
jucător a câştigat - O(n) (1,5p)


2. Dat un arbore cu n vârfuri, să se determine o mulţime de vârfuri neadiacente de cardinal maxim (o
submulţime independentă maximă a mulţimii vârfurilor). Justificaţi corectitudinea algoritmului propus.
Pentru un graf oarecare mai este valabilă metoda? Justificaţi. – O(n) (3p)


3. Problema partiţionării intervalelor – Se consideră n intervale închise (interpretare: n cursuri,
pentru care se cunosc ora de început şi ora de sfârşit). Se cere să se împartă (partiţioneze) această
mulţime de intervale într-un număr minim de submulţimi cu proprietatea că oricare două intervale
dintr-o submulţime nu se intersectează şi să se afişeze aceste submulţimi (interpretare: să se determine
numărul minim de săli necesare pentru a putea programa aceste cursuri în aceeaşi zi şi afişaţi o astfel
de programare). Care dintre următorii algoritmi Greedy sunt corecţi pentru a rezolva această
problemă? Pentru fiecare algoritm (subpunct) justificaţi corectitudinea sau daţi un contraexemplu:
a) Se sortează intervalele crescător după extremitatea iniţială Pentru fiecare interval I în această
ordine execută: se adaugă I la o submulţime deja construită, dacă se poate (nu se intersectează cu
niciun interval din ea), altfel se creează o nouă submulţime cu intervalul I.
b) Se sortează intervalele crescător după extremitatea finală. Pentru fiecare interval I în această ordine
execută: se adaugă I la o submulţime deja construită, dacă se poate, altfel se creează o nouă
submulţime cu intervalul I.
c) Se sortează intervalele crescător după extremitatea finală Pentru fiecare interval I în această ordine
execută: la o mulţime deja construită, dacă se poate, altfel se creează o nouă mulţime cu intervalul
I. Dacă există mai multe mulţimi la care se poate adăuga I, se alege acea submulţime care conţine
intervalul cu extremitatea finală cea mai mare (care se termină cât mai aproape de începutul
intervalului I)
d) Cât timp mai sunt intervale nedistribuite în submulţimi repetă: construieşte o submulţime de
cardinal maxim de intervale disjuncte din mulţimea de intervale (folosind algoritmul de la
problema spectacolelor discutată la curs) şi se elimină aceste intervale din mulţimea de intervale
(altfel spus, se construieşte prima submulţime folosind un număr maxim de intervale, apoi a doua
submulţime folosind un număr maxim de intervale din cele rămase etc).
e) Implementaţi un algoritm O(n log n) pentru rezolvarea acestei probleme.
Exemplu: pentru n=4 cursuri, care trebuie să se desfăşoare în intervalele: [10, 14], [10, 12], [15,
16], respectiv [13, 18], sunt necesare 2 săli, o programare optimă fiind:
o Sala 1: [10, 14] – activitatea 1, [15, 16] – activitatea 3
o Sala 2: [10, 12] – activitatea 2, [13, 18] – activitatea 4 (4,5p)
