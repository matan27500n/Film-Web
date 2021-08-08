package c123.service;

import java.sql.SQLException;
import java.util.Iterator;
import c123.dbdao.FilmDBDAO;
import c123.model.Film;

public class FilmServiceImp implements FilmService {

	public FilmServiceImp() {
	}

	private FilmDBDAO filmDBDAO = new FilmDBDAO();

	@Override
	public Iterator<Film> findAllFilms() {
		Iterator<Film> films = null;
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

	@Override
	public Iterator<Film> selectFilmsByColumn(String column, int limit, int skip) {
		Iterator<Film> films = null;
		try {
			films = filmDBDAO.selectFilmsOrderByColumn(column, limit, skip);
		} catch (SQLException e) {
			System.err.println(e);
		}
		return films;
	}

	@Override
	public Iterator<Film> selectFilmsByColumnDesc(String column, int limit, int skip) {
		Iterator<Film> films = null;
		try {
			films = filmDBDAO.selectFilmsOrderByColumnDesc(column, limit, skip);
		} catch (SQLException e) {
			System.err.println(e);
		}
		return films;
	}
}
