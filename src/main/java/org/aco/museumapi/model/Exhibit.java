package org.aco.museumapi.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Exhibit {

    @Id
    private String exhibitId; // Primary key for the exhibit

    private String name;
    private String description;
    private String audioUrlEnglish;
    private String audioUrlMacedonian;
    private LocalDateTime createdAt;

    // One exhibit can be bookmarked by many users
    @OneToMany(mappedBy = "exhibit", cascade = CascadeType.ALL)
    @JsonManagedReference("exhibit-bookmarks")
    private List<Bookmark> bookmarks;

    // One exhibit can be played by many users
    @OneToMany(mappedBy = "exhibit", cascade = CascadeType.ALL)
    @JsonManagedReference("exhibit-playbacks")
    private List<PlaybackLog> playbackLogs;

    public Exhibit() {}

    // Getters and setters
    public String getExhibitId() { return exhibitId; }
    public void setExhibitId(String exhibitId) { this.exhibitId = exhibitId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getAudioUrlEnglish() { return audioUrlEnglish; }
    public void setAudioUrlEnglish(String audioUrlEnglish) { this.audioUrlEnglish = audioUrlEnglish; }

    public String getAudioUrlMacedonian() { return audioUrlMacedonian; }
    public void setAudioUrlMacedonian(String audioUrlMacedonian) { this.audioUrlMacedonian = audioUrlMacedonian; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public List<Bookmark> getBookmarks() { return bookmarks; }
    public void setBookmarks(List<Bookmark> bookmarks) { this.bookmarks = bookmarks; }

    public List<PlaybackLog> getPlaybackLogs() { return playbackLogs; }
    public void setPlaybackLogs(List<PlaybackLog> playbackLogs) { this.playbackLogs = playbackLogs; }
}
