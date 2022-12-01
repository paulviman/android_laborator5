# android_laborator5
Dezvoltaţi o aplicaţie (un mini joc) care generează în mod aleator un număr în interiorul unui interval. 
Utilizatorul trebuie să ghicească numărul generat aleator de aplicaţie. Pentru aceasta introduce valori într-un câmp
plainText (formatat pentru numere) şi apasă pe un buton „Verifică”. Dacă utilizatorul a ghicit numărul – jocul s-a 
terminat şi repornirea lui este posibilă prin apăsarea unui buton „Jon Nou”. 
În paralel, în timp ce utilizatorul încearcă să ghicească numărul generat aleator de aplicaţie, este lansat în 
execuţie un Thread secundar (Worker thread în background) care şi el încearcă să ghicească numărul. Pentru acest 
lucru, firul de execuţie secundar generează şi el în mod aleator, din două în două secunde, câte un număr în acelaşi 
interval iar apoi, trimite numărul spre mainThread spre verificare. Dacă firul de execuţie secundar ghiceşte numărul 
înaintea utilizatorului, jocul s-a încheiat.
