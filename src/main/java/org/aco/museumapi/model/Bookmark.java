package org.aco.museumapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Bookmark {

    @Id
    private String bookmarkId; // Primary key for bookmark

    private LocalDateTime timestamp;

    // Many bookmarks can belong to one user
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference("user-bookmarks")
    private User user;

    // Many bookmarks can refer to one exhibit
    @ManyToOne
    @JoinColumn(name = "exhibit_id")
    @JsonBackReference("exhibit-bookmarks")
    private Exhibit exhibit;

    public Bookmark() {}

    // Getters and setters
    public String getBookmarkId() { return bookmarkId; }
    public void setBookmarkId(String bookmarkId) { this.bookmarkId = bookmarkId; }

    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public Exhibit getExhibit() { return exhibit; }
    public void setExhibit(Exhibit exhibit) { this.exhibit = exhibit; }
}
