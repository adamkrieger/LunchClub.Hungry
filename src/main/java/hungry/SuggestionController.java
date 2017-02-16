package main.java.hungry;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class SuggestionController {
    private static final String template = "Why not try eating at %s?";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/suggestion")
    public Suggestion suggestion(@RequestParam(value="name", defaultValue="Sherbrook Deli") String name) {
        return new Suggestion(counter.incrementAndGet(),
                String.format(template, name));
    }
}