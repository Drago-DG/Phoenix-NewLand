package com.newland.moviess;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Adel
 */
public class MovieDAOImplement implements Serializable, MovieDAO {

    int id_movie = 0;

    @Override
    public List<MovieVO> getMovies() {
        String user = "postgres";
        String password = "postgres";
        String url = "jdbc:postgresql://192.168.1.214:5432/TelematicsDev";
        Connection conexion = null;
        List<MovieVO> lista = new ArrayList<>();
        try {
            Class.forName("org.postgresql.Driver");
            conexion = DriverManager.getConnection(url, user, password);
            if (conexion != null) {
                System.out.println("UFFF Conexion a la BD");
            } else {
                System.out.println("VLV NO se pudo conectar");
                return lista;
            }
            Statement st = conexion.createStatement();
            ResultSet result = st.executeQuery("select * from cat_movies a left join cat_movie_genre b on a.id_genre = b.id_genre order by id_movie desc;");
            while (result.next()) {
                MovieVO mov = new MovieVO();
                mov.setId_movie(result.getInt("id_movie"));
                mov.setMovie_name(result.getString("movie_name"));
                mov.setYear(result.getInt("movie_year"));
                mov.setId_genre(result.getInt("id_genre"));
                mov.setGenre_descrip(result.getString("genre_desc"));
                lista.add(mov);

            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(MovieDAOImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    @Override
    public int InsertMovie(MovieVO movie) {
        String user = "postgres";
        String password = "postgres";
        String url = "jdbc:postgresql://192.168.1.214:5432/TelematicsDev";
        Connection conexion = null;

        try {
            Class.forName("org.postgresql.Driver");
            conexion = DriverManager.getConnection(url, user, password);
            if (conexion != null) {
                System.out.println("UFFF Conexion a la BD");
            } else {
                System.out.println("VLV NO se pudo conectar");
                return 0;
            }
            Statement st = conexion.createStatement();
            ResultSet result = st.executeQuery("select max(id_movie) from cat_movies");

            while (result.next()) {

                id_movie = result.getInt("max");
                id_movie++;
            }
            result = st.executeQuery("Insert into cat_movies(id_movie, movie_name, movie_year, id_genre) values(" + id_movie + ", '" + movie.getMovie_name() + "', " + movie.getYear() + ", " + movie.getId_genre() + ");");
            result.close();
            st.close();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(MovieDAOImplement.class.getName()).log(Level.SEVERE, null, ex);

        } finally {

            try {
                conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(MovieDAOImplement.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return 0;
    }

}
