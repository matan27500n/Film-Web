package c123.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import c123.model.Film;
import c123.service.FilmServiceImp;

@WebServlet("/UpdateServlet2")
public class UpdateServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateServlet2() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int film_id = Integer.parseInt(request.getParameter("film_id"));
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		int release_year = Integer.parseInt(request.getParameter("release_year"));
		int language_id = Integer.parseInt(request.getParameter("language_id"));
		int original_language_id = Integer.parseInt(request.getParameter("original_language_id"));
		int rental_duration = Integer.parseInt(request.getParameter("rental_duration"));
		double rental_rate = Double.parseDouble(request.getParameter("rental_rate"));
		int length = Integer.parseInt(request.getParameter("length"));
		double replacement_cost = Double.parseDouble(request.getParameter("replacement_cost"));
		String rating = request.getParameter("rating");
		String special_features = request.getParameter("special_features");
		Timestamp last_update = new Timestamp(System.currentTimeMillis());
		Film film = new Film(film_id, title, description, release_year, language_id, original_language_id,
				rental_duration, rental_rate, length, replacement_cost, rating, special_features, last_update);
		FilmServiceImp filmServiceImp = new FilmServiceImp();
		int status = filmServiceImp.updateFilm(film);
		if (status > 0) {
			out.println("Record updated succesfully...");
			response.sendRedirect("film.html");
		} else {
			out.println("Sorry! unable to update record");
			response.sendRedirect("film.html");
		}
		out.close();
	}
}
