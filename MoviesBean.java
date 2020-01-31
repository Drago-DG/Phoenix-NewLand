/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.newland.moviess;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Adel
 *
 */
@ManagedBean
@ViewScoped
public class MoviesBean implements Serializable {

    private List<MovieVO> movies;
    private MovieDAO movieDAO;
    private List<MovieVO> cop;
    private String filtro;
    private MovieVO movie;

    @PostConstruct
    public void init() {
        movieDAO = new MovieDAOImplement();
        movies = movieDAO.getMovies();
        cop = new ArrayList<>();
        cop.addAll(movies);
        movie = new MovieVO();

    }

    public void filtrar() {
        cop.clear();
        for (MovieVO mov : movies) {
            if (mov.getMovie_name().toUpperCase().contains(filtro.toUpperCase())) {
                //System.out.print(buscar);

                MovieVO movi = new MovieVO();
                movi.setId_movie(mov.getId_movie());
                movi.setMovie_name(mov.getMovie_name());
                movi.setYear(mov.getYear());
                movi.setId_genre(mov.getId_genre());
                movi.setGenre_descrip(mov.getGenre_descrip());

                cop.add(movi);

            }
        }

    }
    


    public void saveMovie() {
        movies.size();
        movieDAO.InsertMovie(movie);
        
    }

    
    //Parametros Getter y Setter
    public List<MovieVO> getMovies() {
        return movies;
    }

    public void setMovies(List<MovieVO> movies) {
        this.movies = movies;
    }

    public MovieDAO getMovieDAO() {
        return movieDAO;
    }

    public void setMovieDAO(MovieDAO movieDAO) {
        this.movieDAO = movieDAO;
    }

    public List<MovieVO> getCop() {
        return cop;
    }

    public void setCop(List<MovieVO> cop) {
        this.cop = cop;
    }

    public String getFiltro() {
        return filtro;
    }

    public void setFiltro(String filtro) {
        this.filtro = filtro;
    }

    public MovieVO getMovie() {
        return movie;
    }

    public void setMovie(MovieVO movie) {
        this.movie = movie;
    }

}
