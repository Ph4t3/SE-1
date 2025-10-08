### Was ist der Vorteil einer separaten Test-Klasse?
Weniger Aufwand um viele Testcases abarbeiten zu können unter Nutzung von vorgefertigten
Funktionen wie beforeEach, statt alles selbst händisch in einer Main schreiben zu müssen.

### Was ist bei einem Blackbox-Test der Sinn von Äquivalenzklassen?
Das Reduzieren aller möglichen Testfälle auf einige wenige repräsentative Werte,
die ganze Klassen von möglichen Testwerten vertreten. Statt alle negativen Zahlen durchtesten
zu lassen, testet man jediglich eine beispielsweise. Zudem sind Grenzwerte immmer interessante
Testcases für eigene Äquivalenzklassen.

### Warum ist ein Blackbox-Test mit JUnit auf der Klasse Client nicht unmittelbar durchführbar?
Da die display Methode vom Typ void ist, hat sie keinen Rückgabewert und gibt jediglich etwas auf der Konsole aus.
Dies wäre auch denkbar zu testen, allerdings umständlicher als einfach die Methode die display() benutzt
um Werte zu bekommen direkt zu testen, in diesem Fall also die translateNumber Methode in GermanTranslator.
Generell ergibt es mehr Sinn, Tests dort durchzuführen wo die Logik implementiert ist, nicht wo Ergebnisse nur angezeigt
werden wie in unserer Client Klasse.
