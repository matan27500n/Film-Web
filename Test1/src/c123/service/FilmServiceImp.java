package c123.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import c123.dbdao.FilmDBDAO;
import c123.model.Film;

public class FilmServiceImp implements FilmService {

	private FilmDBDAO filmDBDAO = new FilmDBDAO();

	@Override
	public List<Film> findAllFilms() {
		List<Film> films = new ArrayList<Film>();
		try {
			films = filmDBDAO.selectAllFilms();
		} catch (SQLException e) {
			System.err.println(e);
		}
		return films;
	}

	@Override
	public Film findFilmById(int film_id) {
		Film film = new Film();
		try {
			film = filmDBDAO.selectFilmById(film_id);
		} catch (SQLException e) {
			System.err.println(e);
		}
		return film;
	}

	@Override
	public int updateFilm(Film film) {
		int status = 0;
		try {
			status = filmDBDAO.updateFilm(film);
		} catch (SQLException e) {
			System.err.println(e);
		}
		return status;
	}

	@Override
	public int deleteFilm(int film_id) {
		int status = 0;
		try {
			status = filmDBDAO.deleteFilm(film_id);
		} catch (SQLException e) {
			System.err.println(e);
		}
		return status;
	}

	@Override
	public void addFilm(Film film) {
		try {
			filmDBDAO.insertFilm(film);
		} catch (SQLException e) {
			System.err.println(e);
		}
	}
}
