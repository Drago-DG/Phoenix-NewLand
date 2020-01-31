/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.newland.moviess;

import java.util.List;

/**
 *
 * @author Adel
 */
public interface MovieDAO {

    public List<MovieVO> getMovies();

    public int InsertMovie(MovieVO movie);

}
