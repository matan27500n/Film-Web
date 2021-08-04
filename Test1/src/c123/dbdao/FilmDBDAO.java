package c123.dbdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import c123.dao.FilmDAO;
import c123.model.Film;
import c123.sql.SqlQueries;
import c123.util.ConnectionUtil;

public class FilmDBDAO implements FilmDAO {

	@Override
	public List<Film> selectAllFilms() throws SQLException {
		List<Film> films = new ArrayList<Film>();
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement ps = con.prepareStatement(SqlQueries.SELECT_ALL_FILMS);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			int film_id = rs.getInt(1);
			String title = rs.getString(2);
			String description = rs.getString(3);
			int release_year = rs.getInt(4);
			int language_id = rs.getInt(5);
			int original_language_id = rs.getInt(6);
			int rental_duration = rs.getInt(7);
			double rental_rate = rs.getDouble(8);
			int length = rs.getInt(9);
			double replacement_cost = rs.getDouble(10);
			String rating = rs.getString(11);
			String special_features = rs.getString(12);
			Timestamp last_update = rs.getTimestamp(13);
			films.add(new Film(film_id, title, description, release_year, language_id, original_language_id,
					rental_duration, rental_rate, length, replacement_cost, rating, special_features, last_update));
		}
		return films;
	}

	@Override
	public int insertFilm(Film film) throws SQLException {
		int status = 0;
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement ps = con.prepareStatement(SqlQueries.INSERT_FILM);
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
		return status;
	}

	@Override
	public int updateFilm(Film film) throws SQLException {
		int status = 0;
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement ps = con.prepareStatement(SqlQueries.UPDATE_FILM);
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
		return status;
	}

	@Override
	public Film selectFilmById(int film_id) throws SQLException {
		Film film = null;
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement ps = con.prepareStatement(SqlQueries.SELECT_FILM_BY_ID);
		ps.setInt(1, film_id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			String title = rs.getString(2);
			String description = rs.getString(3);
			int release_year = rs.getInt(4);
			int language_id = rs.getInt(5);
			int original_language_id = rs.getInt(6);
			int rental_duration = rs.getInt(7);
			double rental_rate = rs.getDouble(8);
			int length = rs.getInt(9);
			double replacement_cost = rs.getDouble(10);
			String rating = rs.getString(11);
			String special_features = rs.getString(12);
			Timestamp last_update = rs.getTimestamp(13);
			film = new Film(film_id, title, description, release_year, language_id, original_language_id,
					rental_duration, rental_rate, length, replacement_cost, rating, special_features, last_update);
		}
		con.close();
		return film;
	}

	@Override
	public int deleteFilm(int film_id) throws SQLException {
		int status = 1;
		Connection con = ConnectionUtil.getConnection();
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
		return status;
	}

	@Override
	public List<Film> selectFilmsOrderByColumn(String column) throws SQLException {
		List<Film> films = new ArrayList<Film>();
		Connection con = ConnectionUtil.getConnection();
		column = column.replace("'", "''");
		PreparedStatement ps = con.prepareStatement(SqlQueries.SELECT_FILMS_BY_COLUMN);
		// ps.setString(1, column);
		System.out.println(ps);
		System.out.println(column);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			int film_id = rs.getInt(1);
			String title = rs.getString(2);
			String description = rs.getString(3);
			int release_year = rs.getInt(4);
			int language_id = rs.getInt(5);
			int original_language_id = rs.getInt(6);
			int rental_duration = rs.getInt(7);
			double rental_rate = rs.getDouble(8);
			int length = rs.getInt(9);
			double replacement_cost = rs.getDouble(10);
			String rating = rs.getString(11);
			String special_features = rs.getString(12);
			Timestamp last_update = rs.getTimestamp(13);
			films.add(new Film(film_id, title, description, release_year, language_id, original_language_id,
					rental_duration, rental_rate, length, replacement_cost, rating, special_features, last_update));
		}
		return films;
	}
}
