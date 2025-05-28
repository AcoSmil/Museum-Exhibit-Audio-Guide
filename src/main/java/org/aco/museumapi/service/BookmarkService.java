package org.aco.museumapi.service;

import org.aco.museumapi.model.Bookmark;
import org.aco.museumapi.repository.BookmarkRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookmarkService {

    private final BookmarkRepository bookmarkRepository;

    public BookmarkService(BookmarkRepository bookmarkRepository) {
        this.bookmarkRepository = bookmarkRepository;
    }

    public List<Bookmark> getAllBookmarks() {
        return bookmarkRepository.findAll();
    }

    public Optional<Bookmark> getBookmarkById(String bookmarkId) {
        return bookmarkRepository.findById(bookmarkId);
    }

    public Bookmark saveBookmark(Bookmark bookmark) {
        return bookmarkRepository.save(bookmark);
    }

    public void deleteBookmark(String bookmarkId) {
        bookmarkRepository.deleteById(bookmarkId);
    }
}
