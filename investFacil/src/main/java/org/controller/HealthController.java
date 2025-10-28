package org.controller;

import org.springframework.web.bind.annotation.*;
import java.time.OffsetDateTime;
import java.util.Map;

@RestController
@RequestMapping("/api/health")
public class HealthController {

    @GetMapping
    public Map<String, Object> health() {
        return Map.of(
                "status", "OK",
                "service", "investfacil-api",
                "timestamp", OffsetDateTime.now().toString()
        );
    }
}

