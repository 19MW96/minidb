package de.marc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

class MiniDBTest {

    @Test
    void putUndGetLiefernGespeichertenWert() {
        MiniDB db = new MiniDB();

        db.put("name", "Marc");

        assertEquals("Marc", db.get("name"));
    }

    @Test
    void deleteEntferntWertUndGibtIhnZurueck() {
        MiniDB db = new MiniDB();
        db.put("name", "Marc");

        String geloescht = db.delete("name");

        assertEquals("Marc", geloescht);
        assertNull(db.get("name"));
    }

    @Test
    void putUeberschreibtVorhandenenWert() {
        MiniDB db = new MiniDB();
        db.put("name", "Marc");

        db.put("name", "Kevin");

        assertEquals("Kevin", db.get("name"));
    }

    @Test
    void sizeZaehltGespeicherteEintraege() {
        MiniDB db = new MiniDB();
        db.put("Mama", "0176");
        db.put("Papa", "0151");

        assertEquals(2, db.size());
    }

    @Test
    void existsErkenntObKontaktDa() {
        MiniDB db = new MiniDB();
        db.put("Mama", "0176");

        assertTrue(db.exists("Mama"));
        assertFalse(db.exists("Papa"));
    }

    @Test
    void clearLoeschtAllesUndGibtTextZurueck() {
        MiniDB db = new MiniDB();
        db.put("Mama", "0176");
        db.put("Papa", "0151");

        String antwort = db.clear();

        assertEquals("Alles gelöscht", antwort);
        assertEquals(0, db.size());
    }
}
