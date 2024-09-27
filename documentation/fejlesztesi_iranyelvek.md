# The Barn projekt - Szoftverfejlesztés mérnököknek projekt

1. **Biztonság**

    - A projektben nem fogunk érzékeny, VALÓS adatokkal dolgozni, DE arra kérek mindenkit, hogy a lehető legnagyobb szakmai igényességgel írja meg a kódjait, hogy az esetleges felmerülő biztonsági kérdéseknek, kihívásoknak megfeleljenek. Példák erre:
        - Ha az alkalmazásunk a belépéshez felhasználónév-jelszó párost kér, akkor se a felhasználónevet, se a jelszavat ne tároljuk el plain textként, gondoskodjunk a megfelelő titkosításról.

2. **Nyelvek**

    - A commitok nyelve lehet bármilyen: angol, német, magyar, finn, üzbég, koreai, mandarin akár héber is.
    - A kódokban a kommentek, változók nyelve **angol**.
    - A dokumentáció nyelve **magyar**.

3. **Átláthatóság és újrafelhasználás**

    - "When a programmer first creates his code, only he and God know how it works, a few months down the line and only God knows."
    - "Even if you don't know how the code does what it does, you need to know what it does before you touch it."
    - Ezeket maximálisan tiszteletben kell tartani és olyat alkotni, amit nem csak ti, hanem mindenki más is ért.
    - A változónevek, osztályok, függvények elnevezése "szólaljon meg"!
    - **Ne lássunk "a", "y", "x" változókat**, melyek nem csak szigorúan local szinten vannak használva.
    - Kiemelten fontos a **kommentek írása a kódban**. Ezzel nem csak mások, hanem a te jövőbeli munkádat is megkönnyíted a refaktorálás vagy karbantartás esetén.

4. **Kommunikációs csatornák**

    - 2 kommunikációs csatornát fogunk használni:
        - Rövid üzenetekhez, azonnali vagy rövides időn belüli beavatkozást igénylő esemény esetén Facebook Messenger
        - Meetingek során Discord
    - A projekt előremenetelével kapcsolatos feladatok menedzselése:
        - Trello. Link: https://trello.com/b/mK7KYIsJ/the-barn-sfm2024
            - Munkatér részei:
                - TODO: Ide kerülnek a feladatok kiírása az adott hétre vonatkozóan. Ezt kizárólag a projektvezető (Hunor) szerkesztheti.
                - In Progress: Ide húzhatjátok azokat a feladatokat, melyeket már **valós** időben elkezdtetek. Ide bárki bármit húzhat.
                - Test Ready: Ide húzhatjátok azokat feladatokat, melyek már tesztkészek. Ide is bárki bármit húzhat.
                - DONE: Ide kerülnek azok a feladatok, melyek készek. Ide csak a tesztelőpárotok, illetve a projektvezető húzhat.

5. **Csapatok és a munka velük**

    - A fejlesztés során csapatokban fogunk dolgozni
    - A fejlesztési csapatok belsős feladata egymás segítése, ellenőrzése, tehermentesítése
    - Lesznek olyan feladatok, amiket a csapat közösen kap és lesznek olyanok, amiket csak 1-1 ember
        - Ha egy ember kap egy feladatot és készen van, akkor az egyik csapattársa teszteli
        - Ha egy egész csapat kap egy feladatot és készen van, akkor egy másik csapat teszteli
    - A csapatoknak készült csatorna a Discordon, ott tudtok kommunikálni egymással
    - Ha egy másik csapat tesztjét kéritek, keressétek őket a közös csatornán!
    - **Legyünk korrektek a tesztelőkkel és ne utolsó pillanatban dobjuk oda nekik, mindenkinek van dolga!** Számoljátok bele, hogy akár vissza is kerülhet hiba esetén hozzátok újra!
    - **A kiadott feladatok határidejeit lehetőleg tartsuk be.**

6. **Projekttal kapcsolatos követelmények a sikeres gyakorlat teljesítéséhez**

    - Nem triviális üzleti logikával rendelkezzen. Magyarul: adatokat összekombináljunk, származtassunk a projektünkben
    - Perzisztencia. Magyarul: az adatok perzisztenciája. Még magyarabbul: adatokat folyamatosan mentsük (lehet ez fájl, vagy adatbázis - adatbázis ajánlott) 
    - Grafikus felület (GUI) alkalmazása
    - Tesztek, egységtesztek (JUnit) használata