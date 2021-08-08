package c123.dao;

import java.sql.SQLException;
import java.util.Iterator;
import c123.model.Film;

public interface FilmDAO {

	int insertFilm(Film film) throws SQLException;

	int updateFilm(Film film) throws SQLException;

	Film selectFilmById(int film_id) throws SQLException;

	Iterator<Film> selectAllFilms() throws SQLException;

	int deleteFilm(int film_id) throws SQLException;

	Iterator<Film> selectFilmsOrderByColumn(String column, int limit, int skip) throws SQLException;

	Iterator<Film> selectFilmsOrderByColumnDesc(String column, int limit, int skip) throws SQLException;
}
