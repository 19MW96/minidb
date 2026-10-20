package de.marc;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;

import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
public class MiniDBController {

    private MiniDB db = new MiniDB();

    public MiniDBController() throws IOException {
        if (Files.exists(Path.of("kontakte.json"))) {
            db.laden("kontakte.json");
        }
    }

    @GetMapping("/kontakte")
    public HashMap<String, String> alle() {
        return db.getAlle();
    }

    @GetMapping("/kontakte/{key}")
    public String get(@PathVariable String key) {
        return db.get(key);
    }

    @PutMapping("/kontakte/{key}")
    public void put(@PathVariable String key, @RequestBody String value) throws IOException {
        db.put(key, value);
        db.speichern("kontakte.json");
    }

    @DeleteMapping("/kontakte/{key}")
    public String delete(@PathVariable String key) throws IOException {
        String geloescht = db.delete(key);
        db.speichern("kontakte.json");
        return geloescht;
    }
}
