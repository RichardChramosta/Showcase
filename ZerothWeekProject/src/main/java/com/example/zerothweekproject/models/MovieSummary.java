package com.example.zerothweekproject.models;

import com.example.zerothweekproject.models.DTOs.Type;

import java.util.Set;

public class MovieSummary {
        private String id;
        private String title;
        private Set<Type> genres;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

    public Set<Type> getGenres() {
        return genres;
    }

    public void setGenres(Set<Type> genres) {
        this.genres = genres;
    }
}

