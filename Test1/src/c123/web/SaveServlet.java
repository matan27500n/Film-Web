package c123.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import c123.model.Film;
import c123.service.FilmServiceImp;

@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SaveServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

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

		Film film = new Film(title, description, release_year, language_id, original_language_id, rental_duration,
				rental_rate, length, replacement_cost, rating, special_features, last_update);
		FilmServiceImp filmServiceImp = new FilmServiceImp();
		filmServiceImp.addFilm(film);

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<html><body>");
		out.println("Create " + film.getTitle() + " successfully");
		out.println("</body></html>");
		RequestDispatcher rs = request.getRequestDispatcher("film.html");
		rs.forward(request, response);
		out.close();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
