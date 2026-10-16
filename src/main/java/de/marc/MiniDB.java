package de.marc;

import java.util.HashMap;

public class MiniDB {
    private HashMap<String, String> daten = new HashMap<>();

    public void put(String key, String value) {
        daten.put(key, value);
    }

    public String get(String key) {
        return daten.get(key);
    }

    public String delete(String key) {
        return daten.remove(key);
    }
}
