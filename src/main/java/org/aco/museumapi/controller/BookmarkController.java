package org.aco.museumapi.controller;

import org.aco.museumapi.model.Bookmark;
import org.aco.museumapi.service.BookmarkService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookmarks")
public class BookmarkController {

    private final BookmarkService bookmarkService;

    public BookmarkController(BookmarkService bookmarkService) {
        this.bookmarkService = bookmarkService;
    }

    // Get all bookmarks
    @GetMapping
    public List<Bookmark> getAllBookmarks() {
        return bookmarkService.getAllBookmarks();
    }

    // Get bookmark by ID
    @GetMapping("/{id}")
    public ResponseEntity<Bookmark> getBookmarkById(@PathVariable String id) {
        return bookmarkService.getBookmarkById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Create a new bookmark
    @PostMapping
    public Bookmark createBookmark(@RequestBody Bookmark bookmark) {
        return bookmarkService.saveBookmark(bookmark);
    }


    // Delete a bookmark
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookmark(@PathVariable String id) {
        bookmarkService.deleteBookmark(id);
        return ResponseEntity.noContent().build();
    }
}
