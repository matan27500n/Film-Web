package c123.dbdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import c123.dao.FilmDAO;
import c123.model.Film;
import c123.sql.SqlQueries;
import c123.util.ConnectionUtil;

public class FilmDBDAO implements FilmDAO {
	private List<Film> films;
	private PreparedStatement ps = null;
	private Connection con = null;
	private int film_id;
	private String title;
	private String description;
	private int release_year;
	private int language_id;
	private int original_language_id;
	private int rental_duration;
	private double rental_rate;
	private int length;
	private double replacement_cost;
	private String rating;
	private String special_features;
	private Timestamp last_update;

	@Override
	public Iterator<Film> selectAllFilms() throws SQLException {
		films = new ArrayList<Film>();
		con = ConnectionUtil.getConnection();
		ps = con.prepareStatement(SqlQueries.SELECT_ALL_FILMS);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			film_id = rs.getInt(1);
			title = rs.getString(2);
			description = rs.getString(3);
			release_year = rs.getInt(4);
			language_id = rs.getInt(5);
			original_language_id = rs.getInt(6);
			rental_duration = rs.getInt(7);
			rental_rate = rs.getDouble(8);
			length = rs.getInt(9);
			replacement_cost = rs.getDouble(10);
			rating = rs.getString(11);
			special_features = rs.getString(12);
			last_update = rs.getTimestamp(13);
			films.add(new Film(film_id, title, description, release_year, language_id, original_language_id,
					rental_duration, rental_rate, length, replacement_cost, rating, special_features, last_update));
		}
		con.close();
		ps.close();
		rs.close();
		Iterator<Film> iterator = films.iterator();
		return iterator;
	}

	@Override
	public int insertFilm(Film film) throws SQLException {
		int status = 0;
		con = ConnectionUtil.getConnection();
		ps = con.prepareStatement(SqlQueries.INSERT_FILM);
		ps.setString(1, film.getTitle());
		ps.setString(2, film.getDescription());
		ps.setInt(3, film.getRelease_year());
		ps.setInt(4, film.getLanguage_id());
		ps.setInt(5, film.getOriginal_language_id());
		ps.setInt(6, film.getRental_duration());
		ps.setDouble(7, film.getRental_rate());
		ps.setInt(8, film.getLength());
		ps.setDouble(9, film.getReplacement_cost());
		ps.setString(10, film.getRating());
		ps.setString(11, film.getSpecial_features());
		ps.setTimestamp(12, film.getLast_update());
		status = ps.executeUpdate();
		con.close();
		ps.close();
		return status;
	}

	@Override
	public int updateFilm(Film film) throws SQLException {
		int status = 0;
		con = ConnectionUtil.getConnection();
		ps = con.prepareStatement(SqlQueries.UPDATE_FILM);
		ps.setString(1, film.getTitle());
		ps.setString(2, film.getDescription());
		ps.setInt(3, film.getRelease_year());
		ps.setInt(4, film.getLanguage_id());
		ps.setInt(5, film.getRental_duration());
		ps.setDouble(6, film.getRental_rate());
		ps.setInt(7, film.getLength());
		ps.setDouble(8, film.getReplacement_cost());
		ps.setString(9, film.getRating());
		ps.setString(10, film.getSpecial_features());
		ps.setTimestamp(11, film.getLast_update());
		ps.setInt(12, film.getFilm_id());
		status = ps.executeUpdate();
		con.close();
		ps.close();
		return status;
	}

	@Override
	public Film selectFilmById(int film_id) throws SQLException {
		Film film = null;
		con = ConnectionUtil.getConnection();
		ps = con.prepareStatement(SqlQueries.SELECT_FILM_BY_ID);
		ps.setInt(1, film_id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			title = rs.getString(2);
			description = rs.getString(3);
			release_year = rs.getInt(4);
			language_id = rs.getInt(5);
			original_language_id = rs.getInt(6);
			rental_duration = rs.getInt(7);
			rental_rate = rs.getDouble(8);
			length = rs.getInt(9);
			replacement_cost = rs.getDouble(10);
			rating = rs.getString(11);
			special_features = rs.getString(12);
			last_update = rs.getTimestamp(13);
			film = new Film(film_id, title, description, release_year, language_id, original_language_id,
					rental_duration, rental_rate, length, replacement_cost, rating, special_features, last_update);
		}
		con.close();
		ps.close();
		rs.close();
		return film;
	}

	@Override
	public int deleteFilm(int film_id) throws SQLException {
		int status = 1;
		con = ConnectionUtil.getConnection();
		PreparedStatement ps1 = con.prepareStatement(SqlQueries.DELETE_FILM_ACTOR);
		ps1.setInt(1, film_id);
		ps1.executeUpdate();
		PreparedStatement ps2 = con.prepareStatement(SqlQueries.DELETE_FILM_CATEGORY);
		ps2.setInt(1, film_id);
		ps2.executeUpdate();
		PreparedStatement ps3 = con.prepareStatement(SqlQueries.DELETE_FILM_RENTAL);
		ps3.setInt(1, film_id);
		ps3.executeUpdate();
		PreparedStatement ps4 = con.prepareStatement(SqlQueries.DELETE_FILM_INVENTORY);
		ps4.setInt(1, film_id);
		ps4.executeUpdate();
		PreparedStatement ps5 = con.prepareStatement(SqlQueries.DELETE_FILM_BY_ID);
		ps5.setInt(1, film_id);
		ps5.executeUpdate();
		con.close();
		ps1.close();
		ps2.close();
		ps3.close();
		ps4.close();
		ps5.close();
		return status;
	}

	@Override
	public Iterator<Film> selectFilmsOrderByColumn(String column, int limit, int skip) throws SQLException {
		con = ConnectionUtil.getConnection();
		switch (column) {
		case "film_id":
			ps = con.prepareStatement(SqlQueries.SELECT_FILMS_ORDDER_BY_FILM_ID);
			break;
		case "title":
			ps = con.prepareStatement(SqlQueries.SELECT_FILMS_ORDER_BY_TITLE);
			break;
		case "description":
			ps = con.prepareStatement(SqlQueries.SELECT_FILMS_ORDER_BY_DESCRIPTION);
			break;
		case "release_year":
			ps = con.prepareStatement(SqlQueries.SELECT_FILMS_ORDER_BY_RELEASE_YEAR);
			break;
		case "language_id":
			ps = con.prepareStatement(SqlQueries.SELECT_FILMS_ORDER_BY_LANGUAGE_ID);
			break;
		case "rental_duration":
			ps = con.prepareStatement(SqlQueries.SELECT_FILMS_ORDER_BY_RENTAL_DURATION);
			break;
		case "rental_rate":
			ps = con.prepareStatement(SqlQueries.SELECT_FILMS_ORDER_BY_RENTAL_RATE);
			break;
		case "length":
			ps = con.prepareStatement(SqlQueries.SELECT_FILMS_ORDER_BY_LENGTH);
			break;
		case "replacement_cost":
			ps = con.prepareStatement(SqlQueries.SELECT_FILMS_ORDER_BY_REPLACEMENT_COST);
			break;
		case "rating":
			ps = con.prepareStatement(SqlQueries.SELECT_FILMS_ORDER_BY_RATING);
			break;
		case "special_features":
			ps = con.prepareStatement(SqlQueries.SELECT_FILMS_ORDER_BY_SPECIAL_FEATURES);
			break;
		case "last_update":
			ps = con.prepareStatement(SqlQueries.SELECT_FILMS_ORDER_BY_SPECIAL_LAST_UPDATE);
			break;
		}
		films = getfilmsOrdered(ps, limit, skip);
		Iterator<Film> iterator = films.iterator();
		con.close();
		ps.close();
		return iterator;
	}

	@Override
	public Iterator<Film> selectFilmsOrderByColumnDesc(String column, int limit, int skip) throws SQLException {
		con = ConnectionUtil.getConnection();
		switch (column) {
		case "film_id":
			ps = con.prepareStatement(SqlQueries.SELECT_FILMS_ORDDER_BY_FILM_ID_DESC);
			break;
		case "title":
			ps = con.prepareStatement(SqlQueries.SELECT_FILMS_ORDER_BY_TITLE_DESC);
			break;
		case "description":
			ps = con.prepareStatement(SqlQueries.SELECT_FILMS_ORDER_BY_DESCRIPTION_DESC);
			break;
		case "release_year":
			ps = con.prepareStatement(SqlQueries.SELECT_FILMS_ORDER_BY_RELEASE_YEAR_DESC);
			break;
		case "language_id":
			ps = con.prepareStatement(SqlQueries.SELECT_FILMS_ORDER_BY_LANGUAGE_ID_DESC);
			break;
		case "rental_duration":
			ps = con.prepareStatement(SqlQueries.SELECT_FILMS_ORDER_BY_RENTAL_DURATION_DESC);
			break;
		case "rental_rate":
			ps = con.prepareStatement(SqlQueries.SELECT_FILMS_ORDER_BY_RENTAL_RATE_DESC);
			break;
		case "length":
			ps = con.prepareStatement(SqlQueries.SELECT_FILMS_ORDER_BY_LENGTH_DESC);
			break;
		case "replacement_cost":
			ps = con.prepareStatement(SqlQueries.SELECT_FILMS_ORDER_BY_REPLACEMENT_COST_DESC);
			break;
		case "rating":
			ps = con.prepareStatement(SqlQueries.SELECT_FILMS_ORDER_BY_RATING_DESC);
			break;
		case "special_features":
			ps = con.prepareStatement(SqlQueries.SELECT_FILMS_ORDER_BY_SPECIAL_FEATURES_DESC);
			break;
		case "last_update":
			ps = con.prepareStatement(SqlQueries.SELECT_FILMS_ORDER_BY_SPECIAL_LAST_UPDATE_DESC);
			break;
		}
		films = getfilmsOrdered(ps, limit, skip);
		Iterator<Film> iterator = films.iterator();
		con.close();
		ps.close();
		return iterator;
	}

	private List<Film> getfilmsOrdered(PreparedStatement ps, int limit, int skip) throws SQLException {
		films = new ArrayList<Film>();
		ps.setInt(1, limit);
		ps.setInt(2, skip);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			film_id = rs.getInt(1);
			title = rs.getString(2);
			description = rs.getString(3);
			release_year = rs.getInt(4);
			language_id = rs.getInt(5);
			original_language_id = rs.getInt(6);
			rental_duration = rs.getInt(7);
			rental_rate = rs.getDouble(8);
			length = rs.getInt(9);
			replacement_cost = rs.getDouble(10);
			rating = rs.getString(11);
			special_features = rs.getString(12);
			last_update = rs.getTimestamp(13);
			films.add(new Film(film_id, title, description, release_year, language_id, original_language_id,
					rental_duration, rental_rate, length, replacement_cost, rating, special_features, last_update));
		}
		return films;
	}
}
