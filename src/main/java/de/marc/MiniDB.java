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

    public int size() {
        return daten.size();
    }

    public boolean exists(String key) {
        return daten.containsKey(key);
    }

    public String clear() {
        daten.clear();
        return "Alles gelöscht";
    }
}
