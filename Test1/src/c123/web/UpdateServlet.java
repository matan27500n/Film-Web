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
		out.print("<link rel='stylesheet' \r\n"
				+ "	href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\">");

		int film_id = Integer.parseInt(request.getParameter("film_id").trim());
		FilmServiceImp filmServiceImp = new FilmServiceImp();
		Film film = filmServiceImp.findFilmById(film_id);

		out.print("<div class='container' align='center'>");
		out.println("<h1 align='center'>Update Film " + film_id + "</h1>");
		out.print("<form action='UpdateServlet2' method='post'>");

		out.print("<fieldset class='form-group col-md-6' >");
		out.print("<input name='film_id' type='hidden' class='form-control' value='" + film.getFilm_id() + "'/>");
		out.print("</fieldset>");

		out.print("<fieldset class='form-group col-md-6' >");
		out.print("<label align='left'>Title</label>");
		out.print("<input type='text' name='title' class='form-control' value='" + film.getTitle() + "'/>");
		out.print("</fieldset>");

		out.print("<fieldset class='form-group col-md-6' >");
		out.print("<label>Description</label>");
		out.print("<input type='text' name='description' class='form-control' value='" + film.getDescription() + "'/>");
		out.print("</fieldset>");

		out.print("<fieldset class='form-group col-md-6' >");
		out.print("<label>Release Year</label>");
		out.print("<input type='number' name='release_year' class='form-control' value='" + film.getRelease_year()
				+ "'/>");
		out.print("</fieldset>");

		out.print("<fieldset class='form-group col-md-6' >");
		out.print("<label>Language Id</label>");
		out.print(
				"<input type='number' name='language_id' class='form-control' value='" + film.getLanguage_id() + "'/>");
		out.print("</fieldset>");

		out.print("<fieldset class='form-group col-md-6' >");
		out.print("<label>Original Language Id</label>");
		out.print("<input type='number' name='original_language_id' class='form-control' value='"
				+ film.getOriginal_language_id() + "'/>");
		out.print("</fieldset>");

		out.print("<fieldset class='form-group col-md-6' >");
		out.print("<label>Rental Duration</label>");
		out.print("<input type='number' name='rental_duration' class='form-control' value='" + film.getRental_duration()
				+ "'/>");
		out.print("</fieldset>");

		out.print("<fieldset class='form-group col-md-6' >");
		out.print("<label>Rental Rate</label>");
		out.print("<input type='number' name='rental_rate' step='0.01' class='form-control' value='"
				+ film.getRental_rate() + "'/>");
		out.print("</fieldset>");

		out.print("<fieldset class='form-group col-md-6' >");
		out.print("<label>Length</label>");
		out.print("<input type='number' name='length' class='form-control' value='" + film.getLength() + "'/>");
		out.print("</fieldset>");

		out.print("<fieldset class='form-group col-md-6' >");
		out.print("<label>Replacement Cost</label>");
		out.print("<input type='number' name='replacement_cost' step='0.01' class='form-control' value='"
				+ film.getReplacement_cost() + "'/>");
		out.print("</fieldset>");

		out.print("<fieldset class='form-group col-md-6' >");
		out.print("<label>Rating</label>");
		out.print("<input type='text' name='rating' class='form-control' value='" + film.getRating() + "'/>");
		out.print("</fieldset>");

		out.print("<fieldset class='form-group col-md-6' >");
		out.print("<label>Special Features</label>");
		out.print("<input type='text' name='special_features' class='form-control' value='" + film.getSpecial_features()
				+ "'/>");
		out.print("</fieldset>");

		out.print("<button type='submit' class='btn btn-warning'>Update</button>");
		out.print("</form>");
		out.print("</div>");

		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
