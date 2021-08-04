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

	public static final String SELECT_FILMS_BY_COLUMN = "SELECT * FROM sakila.film ORDER BY ? limit 10;";
}
