package de.marc;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
public class MiniDBController {

    private MiniDB db = new MiniDB();

    @GetMapping("/kontakte/{key}")
    public String get(@PathVariable String key) {
        return db.get(key);
    }

    @PutMapping("/kontakte/{key}")
    public void put(@PathVariable String key, @RequestBody String value) {
        db.put(key, value);
    }

    @DeleteMapping("/kontakte/{key}")
    public String delete(@PathVariable String key) {
        return db.delete(key);
    }
}