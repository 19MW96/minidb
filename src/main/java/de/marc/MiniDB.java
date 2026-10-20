package de.marc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;

import com.google.gson.Gson;

public class MiniDB {
    private HashMap<String, String> daten = new HashMap<>();

    private Protokoll protokoll = new Protokoll();

    public void put(String key, String value) {
        if (exists(key)) {
            protokoll.add(key + " geändert");
        } else {
            protokoll.add(key + " eingefügt");
        }
        daten.put(key, value);
    }

    public String get(String key) {
        return daten.get(key);
    }

    public String delete(String key) {
        String geloescht = daten.remove(key);
        protokoll.add(key + " gelöscht");
        return geloescht;
    }

    public int size() {
        return daten.size();
    }

    public boolean exists(String key) {
        return daten.containsKey(key);
    }

    public String clear() {
        daten.clear();
        protokoll.add("Alles gelöscht");
        return "Alles gelöscht";
    }

    public List<String> getProtokoll() {
        return protokoll.getEintraege();
    }

    public void speichern(String dateiname) throws IOException {
        Gson gson = new Gson();
        String json = gson.toJson(daten);
        Files.writeString(Path.of(dateiname), json);
    }

    public void laden(String dateiname) throws IOException {
        Gson gson = new Gson();
        String json = Files.readString(Path.of(dateiname));
        daten = gson.fromJson(json, HashMap.class);
    }
}