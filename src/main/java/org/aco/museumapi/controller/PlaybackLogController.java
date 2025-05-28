package org.aco.museumapi.controller;

import org.aco.museumapi.model.PlaybackLog;
import org.aco.museumapi.service.PlaybackLogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/logs")
public class PlaybackLogController {

    private final PlaybackLogService playbackLogService;

    public PlaybackLogController(PlaybackLogService playbackLogService) {
        this.playbackLogService = playbackLogService;
    }

    // Get all playback logs
    @GetMapping
    public List<PlaybackLog> getAllLogs() {
        return playbackLogService.getAllLogs();
    }

    // Get a specific playback log
    @GetMapping("/{id}")
    public ResponseEntity<PlaybackLog> getLogById(@PathVariable String id) {
        return playbackLogService.getLogById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Create a new playback log
    @PostMapping
    public PlaybackLog createLog(@RequestBody PlaybackLog log) {
        return playbackLogService.saveLog(log);
    }

    // Delete a playback log
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLog(@PathVariable String id) {
        playbackLogService.deleteLog(id);
        return ResponseEntity.noContent().build();
    }
}
