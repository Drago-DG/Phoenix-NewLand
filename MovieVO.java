/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.newland.moviess;

import java.io.Serializable;

/**
 *
 * @author Adel
 */
public class MovieVO implements Serializable{

    private int id_movie;
    private String movie_name;
    private int year;
    private int id_genre;

    private String genre_descrip;

    public int getId_movie() {
        return id_movie;
    }

    public void setId_movie(int id_movie) {
        this.id_movie = id_movie;
    }

    public String getMovie_name() {
        return movie_name;
    }

    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGenre_descrip() {
        return genre_descrip;
    }

    public void setGenre_descrip(String genre_descrip) {
        this.genre_descrip = genre_descrip;
    }

    public int getId_genre() {
        return id_genre;
    }

    public void setId_genre(int id_genre) {
        this.id_genre = id_genre;
    }

}
