package org.aco.museumapi.controller;

import org.aco.museumapi.model.Exhibit;
import org.aco.museumapi.service.ExhibitService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exhibits")
public class ExhibitController {

    private final ExhibitService exhibitService;

    public ExhibitController(ExhibitService exhibitService) {
        this.exhibitService = exhibitService;
    }

    // Get all exhibits
    @GetMapping
    public List<Exhibit> getAllExhibits() {
        return exhibitService.getAllExhibits();
    }

    // Get exhibit by ID
    @GetMapping("/{id}")
    public ResponseEntity<Exhibit> getExhibitById(@PathVariable String id) {
        return exhibitService.getExhibitById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Create new exhibit
    @PostMapping
    public Exhibit createExhibit(@RequestBody Exhibit exhibit) {
        return exhibitService.createExhibit(exhibit);
    }

    // Update exhibit by ID
    @PutMapping("/{id}")
    public ResponseEntity<Exhibit> updateExhibit(@PathVariable String id, @RequestBody Exhibit exhibit) {
        Exhibit updated = exhibitService.updateExhibit(id, exhibit);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    // Delete exhibit
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExhibit(@PathVariable String id) {
        exhibitService.deleteExhibit(id);
        return ResponseEntity.noContent().build();
    }
}
