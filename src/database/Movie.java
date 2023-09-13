package database;

import java.util.ArrayList;

public class Movie {
    private String name;
    private int year;
    private int duration;
    private ArrayList<String> genres;
    private ArrayList<String> actors;
    private ArrayList<String> countriesBanned;
    private int numLikes;
    private double rating;
    private int numRatings;

    /**
     * Implements the Builder pattern for Movie class.
     */
    public static class Builder {
        private String name;
        private int year;
        private int duration;
        private ArrayList<String> genres;
        private ArrayList<String> actors;
        private ArrayList<String> countriesBanned;
        private int numLikes;
        private double rating;
        private int numRatings;

        public Builder() {
            numLikes = 0;
            rating = 0.00;
            numRatings = 0;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }
        public Builder setYear(int year) {
            this.year = year;
            return this;
        }
        public Builder setDuration(int duration) {
            this.duration = duration;
            return this;
        }
        public Builder setGenres(ArrayList<String> genres) {
            this.genres = genres;
            return this;
        }
        public Builder setActors(ArrayList<String> actors) {
            this.actors = actors;
            return this;
        }
        public Builder setCountriesBanned(ArrayList<String> countriesBanned) {
            this.countriesBanned = countriesBanned;
            return this;
        }

        public Movie build() {
            return new Movie(this);
        }
    }

    /* Movie constructor for Builder pattern. */
    private Movie(Builder builder) {
        this.name = builder.name;
        this.year = builder.year;
        this.duration = builder.duration;
        this.genres = builder.genres;
        this.actors = builder.actors;
        this.countriesBanned = builder.countriesBanned;
        this.numLikes = builder.numLikes;
        this.rating = builder.rating;
        this.numRatings = builder.numRatings;
    }

    /* Getters and Setters */
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public int getDuration() {
        return duration;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }
    public ArrayList<String> getGenres() {
        return genres;
    }
    public void setGenres(ArrayList<String> genres) {
        this.genres = genres;
    }
    public ArrayList<String> getActors() {
        return actors;
    }
    public void setActors(ArrayList<String> actors) {
        this.actors = actors;
    }
    public ArrayList<String> getCountriesBanned() {
        return countriesBanned;
    }
    public void setCountriesBanned(ArrayList<String> countriesBanned) {
        this.countriesBanned = countriesBanned;
    }
    public int getNumLikes() {
        return numLikes;
    }
    public void setNumLikes(int numLikes) {
        this.numLikes = numLikes;
    }
    public double getRating() {
        return rating;
    }
    public void setRating(double rating) {
        this.rating = rating;
    }
    public int getNumRatings() {
        return numRatings;
    }
    public void setNumRatings(int numRatings) {
        this.numRatings = numRatings;
    }
}
