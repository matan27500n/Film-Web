package c123.service;

import java.util.Iterator;
import c123.model.Film;

public interface FilmService {

	Iterator<Film> findAllFilms();

	Film findFilmById(int film_id);

	int updateFilm(Film film);

	int deleteFilm(int film_id);

	void addFilm(Film film);

	Iterator<Film> selectFilmsByColumn(String column, int limit, int skip);

	Iterator<Film> selectFilmsByColumnDesc(String column, int limit, int skip);

}
