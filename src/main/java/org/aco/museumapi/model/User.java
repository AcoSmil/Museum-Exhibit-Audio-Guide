package org.aco.museumapi.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "app_user") // ✅ rename from "user" to avoid SQL keyword conflict


    public class User {

        @Id
        private String userId; // Primary key for the user

        private String name;
        private String email;

        // One user can have many bookmarks
        @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
        @JsonManagedReference("user-bookmarks")
        private List<Bookmark> bookmarks;

        // One user can have many playback logs
        @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
        @JsonManagedReference("user-playbacks")
        private List<PlaybackLog> playbackLogs;

        public User() {
        }

        // Getters and setters
        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public List<Bookmark> getBookmarks() {
            return bookmarks;
        }

        public void setBookmarks(List<Bookmark> bookmarks) {
            this.bookmarks = bookmarks;
        }

        public List<PlaybackLog> getPlaybackLogs() {
            return playbackLogs;
        }

        public void setPlaybackLogs(List<PlaybackLog> playbackLogs) {
            this.playbackLogs = playbackLogs;
        }
    }

