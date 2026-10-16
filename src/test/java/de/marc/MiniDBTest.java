package de.marc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

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

}