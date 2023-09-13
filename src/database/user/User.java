package database.user;

import fileInput.MovieInput;

import java.util.ArrayList;

public class User {
    private Credentials credentials;
    private int tokensCount;
    private int numFreePremiumMovies;
    private ArrayList<MovieInput> purchasedMovies;
    private ArrayList<MovieInput> watchedMovies;
    private ArrayList<MovieInput> likedMovies;
    private ArrayList<MovieInput> ratedMovies;



    /* Getters and Setters */
    public Credentials getCredentials() {
        return credentials;
    }
    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }
    public int getTokensCount() {
        return tokensCount;
    }
    public void setTokensCount(int tokensCount) {
        this.tokensCount = tokensCount;
    }
    public int getNumFreePremiumMovies() {
        return numFreePremiumMovies;
    }
    public void setNumFreePremiumMovies(int numFreePremiumMovies) {
        this.numFreePremiumMovies = numFreePremiumMovies;
    }
    public ArrayList<MovieInput> getPurchasedMovies() {
        return purchasedMovies;
    }
    public void setPurchasedMovies(ArrayList<MovieInput> purchasedMovies) {
        this.purchasedMovies = purchasedMovies;
    }
    public ArrayList<MovieInput> getWatchedMovies() {
        return watchedMovies;
    }
    public void setWatchedMovies(ArrayList<MovieInput> watchedMovies) {
        this.watchedMovies = watchedMovies;
    }
    public ArrayList<MovieInput> getLikedMovies() {
        return likedMovies;
    }
    public void setLikedMovies(ArrayList<MovieInput> likedMovies) {
        this.likedMovies = likedMovies;
    }
    public ArrayList<MovieInput> getRatedMovies() {
        return ratedMovies;
    }
    public void setRatedMovies(ArrayList<MovieInput> ratedMovies) {
        this.ratedMovies = ratedMovies;
    }
}
