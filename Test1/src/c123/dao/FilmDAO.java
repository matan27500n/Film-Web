package c123.dao;

import java.sql.SQLException;
import java.util.List;
import c123.model.Film;

public interface FilmDAO {

	int insertFilm(Film film) throws SQLException;

	int updateFilm(Film film) throws SQLException;

	Film selectFilmById(int film_id) throws SQLException;

	List<Film> selectAllFilms() throws SQLException;

	int deleteFilm(int film_id) throws SQLException;
}
