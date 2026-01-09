package org.example.solution.controller;

import org.springframework.web.bind.annotation.*;
import org.example.solution.Solution;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@RestController
@RequestMapping("/api/v1/solution")
public class SolutionController {

    private final List<Map<String, Object>> submissions = new ArrayList<>();

    @PostMapping
    public Map<String, Object> submit(@RequestBody Map<String, Object> body) {
        List<String> strs = (List<String>) body.get("strs");

        long startTime = System.currentTimeMillis();
        List<List<String>> result = Solution.groupAnagrams(strs.toArray(new String[0]));
        long elapsed = System.currentTimeMillis() - startTime;

        Map<String, Object> entry = new HashMap<>();
        entry.put("time submission", LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")));
        entry.put("input", strs);
        entry.put("time elapsed", elapsed);
        entry.put("result", result);

        submissions.add(entry);
        return entry;
    }

    @GetMapping
    public List<Map<String, Object>> getAll() {
        return submissions;
    }
}
