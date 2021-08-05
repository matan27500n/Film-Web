package c123.sql;

public class SqlQueries {
	public static final String INSERT_FILM = "INSERT INTO film\r\n" + "(\r\n" + "`title`,\r\n" + "`description`,\r\n"
			+ "`release_year`,\r\n" + "`language_id`,\r\n" + "`original_language_id`,\r\n" + "`rental_duration`,\r\n"
			+ "`rental_rate`,\r\n" + "`length`,\r\n" + "`replacement_cost`,\r\n" + "`rating`,\r\n"
			+ "`special_features`,\r\n" + "`last_update`)\r\n" + "VALUES(? ,? ,?,?,?,?,?,?,?, ?,?,?);";

	public static final String SELECT_FILM_BY_ID = "SELECT * FROM sakila.film WHERE film_id = ?;";

	public static final String SELECT_ALL_FILMS = "SELECT * FROM sakila.film LIMIT 30;";

	public static final String DELETE_FILM_ACTOR = "DELETE FROM sakila.film_actor WHERE film_id = ?;";
	public static final String DELETE_FILM_CATEGORY = "DELETE FROM sakila.film_category WHERE film_id = ?;";
	public static final String DELETE_FILM_RENTAL = "DELETE FROM sakila.rental WHERE inventory_id IN (\r\n"
			+ "SELECT inventory_id FROM inventory WHERE film_id = ?);";
	public static final String DELETE_FILM_INVENTORY = "DELETE FROM sakila.inventory WHERE film_id = ?;";
	public static final String DELETE_FILM_BY_ID = "DELETE FROM film WHERE film_id = ?;";

	public static final String UPDATE_FILM = "UPDATE film \r\n"
			+ "set title = ?, description = ?, release_year = ?, \r\n"
			+ "language_id = ?, rental_duration = ?, rental_rate = ?, length = ?,\r\n"
			+ "replacement_cost = ?, rating = ?, special_features = ?,last_update = ?\r\n" + "WHERE film_id = ?;";

	public static final String SELECT_FILMS_ORDDER_BY_FILM_ID = "SELECT * FROM sakila.film ORDER BY film_id limit ? OFFSET ?;";
	public static final String SELECT_FILMS_ORDER_BY_TITLE = "SELECT * FROM sakila.film ORDER BY title limit ? OFFSET ?;";
	public static final String SELECT_FILMS_ORDER_BY_DESCRIPTION = "SELECT * FROM sakila.film ORDER BY description limit ? OFFSET ?;";
	public static final String SELECT_FILMS_ORDER_BY_RELEASE_YEAR = "SELECT * FROM sakila.film ORDER BY release_year limit ? OFFSET ?;";
	public static final String SELECT_FILMS_ORDER_BY_LANGUAGE_ID = "SELECT * FROM sakila.film ORDER BY language_id limit ? OFFSET ?;";
	public static final String SELECT_FILMS_ORDER_BY_RENTAL_DURATION = "SELECT * FROM sakila.film ORDER BY rental_duration limit ? OFFSET ?;";
	public static final String SELECT_FILMS_ORDER_BY_RENTAL_RATE = "SELECT * FROM sakila.film ORDER BY rental_rate limit ? OFFSET ?;";
	public static final String SELECT_FILMS_ORDER_BY_LENGTH = "SELECT * FROM sakila.film ORDER BY length limit ? OFFSET ?;";
	public static final String SELECT_FILMS_ORDER_BY_REPLACEMENT_COST = "SELECT * FROM sakila.film ORDER BY replacement_cost limit ? OFFSET ?;";
	public static final String SELECT_FILMS_ORDER_BY_RATING = "SELECT * FROM sakila.film ORDER BY rating limit ? OFFSET ?;";
	public static final String SELECT_FILMS_ORDER_BY_SPECIAL_FEATURES = "SELECT * FROM sakila.film ORDER BY special_features limit ? OFFSET ?;";
	public static final String SELECT_FILMS_ORDER_BY_SPECIAL_LAST_UPDATE = "SELECT * FROM sakila.film ORDER BY last_update limit ? OFFSET ?;";

	public static final String SELECT_FILMS_ORDDER_BY_FILM_ID_DESC = "SELECT * FROM sakila.film ORDER BY film_id DESC limit ? OFFSET ?;";
	public static final String SELECT_FILMS_ORDER_BY_TITLE_DESC = "SELECT * FROM sakila.film ORDER BY title DESC limit ? OFFSET ?;";
	public static final String SELECT_FILMS_ORDER_BY_DESCRIPTION_DESC = "SELECT * FROM sakila.film ORDER BY description DESC limit ? OFFSET ?;";
	public static final String SELECT_FILMS_ORDER_BY_RELEASE_YEAR_DESC = "SELECT * FROM sakila.film ORDER BY release_year DESC limit ? OFFSET ?;";
	public static final String SELECT_FILMS_ORDER_BY_LANGUAGE_ID_DESC = "SELECT * FROM sakila.film ORDER BY language_id DESC limit ? OFFSET ?;";
	public static final String SELECT_FILMS_ORDER_BY_RENTAL_DURATION_DESC = "SELECT * FROM sakila.film ORDER BY rental_duration DESC limit ? OFFSET ?;";
	public static final String SELECT_FILMS_ORDER_BY_RENTAL_RATE_DESC = "SELECT * FROM sakila.film ORDER BY rental_rate DESC limit ? OFFSET ?;";
	public static final String SELECT_FILMS_ORDER_BY_LENGTH_DESC = "SELECT * FROM sakila.film ORDER BY length DESC limit ? OFFSET ?;";
	public static final String SELECT_FILMS_ORDER_BY_REPLACEMENT_COST_DESC = "SELECT * FROM sakila.film ORDER BY replacement_cost DESC limit ? OFFSET ?;";
	public static final String SELECT_FILMS_ORDER_BY_RATING_DESC = "SELECT * FROM sakila.film ORDER BY rating DESC limit ? OFFSET ?;";
	public static final String SELECT_FILMS_ORDER_BY_SPECIAL_FEATURES_DESC = "SELECT * FROM sakila.film ORDER BY special_features DESC limit ? OFFSET ?;";
	public static final String SELECT_FILMS_ORDER_BY_SPECIAL_LAST_UPDATE_DESC = "SELECT * FROM sakila.film ORDER BY last_update DESC limit ? OFFSET ?;";

}
