package org.aco.museumapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class PlaybackLog {

    @Id
    private String playbackId; // Primary key for playback log

    private String language;
    private LocalDateTime timestamp;

    // Many logs can belong to one user
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference("user-playbacks")
    private User user;

    // Many logs can refer to one exhibit
    @ManyToOne
    @JoinColumn(name = "exhibit_id")
    @JsonBackReference("exhibit-playbacks")
    private Exhibit exhibit;

    public PlaybackLog() {}

    // Getters and setters
    public String getPlaybackId() { return playbackId; }
    public void setPlaybackId(String playbackId) { this.playbackId = playbackId; }

    public String getLanguage() { return language; }
    public void setLanguage(String language) { this.language = language; }

    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public Exhibit getExhibit() { return exhibit; }
    public void setExhibit(Exhibit exhibit) { this.exhibit = exhibit; }
}
