package c123.service;

import java.util.List;

import c123.model.Film;

public interface FilmService {

	List<Film> findAllFilms();

	Film findFilmById(int film_id);

	int updateFilm(Film film);

	int deleteFilm(int film_id);

	void addFilm(Film film);

	List<Film> selectFilmsByColumn(String column);

}
