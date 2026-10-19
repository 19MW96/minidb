package de.marc;

import java.util.ArrayList;
import java.util.List;

public class Protokoll {
    private List<String> eintraege = new ArrayList<>();

    public void add(String text) {
        eintraege.add(text);
    }

    public List<String> getEintraege() {
        return eintraege;
    }
}
