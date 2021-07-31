package c123.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import c123.model.Film;
import c123.service.FilmServiceImp;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1>Update Film</h1>");
		int film_id = Integer.parseInt(request.getParameter("film_id").trim());
		out.print("<tr><td>" + film_id + "</td><td>");
		FilmServiceImp filmServiceImp = new FilmServiceImp();
		Film film = filmServiceImp.findFilmById(film_id);
		out.print("<form action='UpdateServlet2' method='post'>");
		out.print("<table>");
		out.print("<tr><td></td><td><input name='film_id' type='hidden' value='" + film.getFilm_id() + "'/></td></tr>");
		out.print("<tr><td>Title:</td><td><input type='text' name='title' value='" + film.getTitle() + "'/></td></tr>");
		out.print("<tr><td>Description:</td><td><input type='text' name='description' value='" + film.getDescription()
				+ "'/> </td></tr>");
		out.print("<tr><td>Release Year:</td><td><input type='number' name='release_year' value='"
				+ film.getRelease_year() + "'/></td></tr>");
		out.print("<tr><td>Language Id:</td><td><input type='number' name='language_id' value='" + film.getLanguage_id()
				+ "'/></td></tr>");
		out.print("<tr><td>Original Language Id:</td><td><input type='number' name='original_language_id' value='"
				+ film.getOriginal_language_id() + "'/></td></tr>");
		out.print("<tr><td>Rental Duration:</td><td><input type='number' name='rental_duration' value='"
				+ film.getRental_duration() + "'/></td></tr>");
		out.print("<tr><td>Rental Rate:</td><td><input type='number' step='0.01' name='rental_rate' value='"
				+ film.getRental_rate() + "'/></td></tr>");
		out.print("<tr><td>Length:</td><td><input type='number' name='length' value='" + film.getLength()
				+ "'/></td></tr>");
		out.print("<tr><td>Replacement Cost:</td><td><input type='number' name='replacement_cost' value='"
				+ film.getReplacement_cost() + "'/></td></tr>");
		out.print("<tr><td>Rating:</td><td><input type='text' name='rating' value='" + film.getRating()
				+ "'/></td></tr>");
		out.print("<tr><td>special_features:</td><td><input type='text' name='special_features' value='"
				+ film.getSpecial_features() + "'/></td></tr>");

		out.print("<tr><td colspan='2'><input type='submit' value='Update '/></td></tr>");
		out.print("</table>");
		out.print("</form>");

		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
