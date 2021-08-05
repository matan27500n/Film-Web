package c123.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import c123.model.Film;
import c123.service.FilmService;
import c123.service.FilmServiceImp;

@WebServlet("/OrderByColumnAsc")
public class OrderByColumnAsc extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FilmService filmService;

	public OrderByColumnAsc() {
		filmService = new FilmServiceImp();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String column = request.getParameter("column");
		int limit = Integer.parseInt(request.getParameter("limit"));
		int skip = Integer.parseInt(request.getParameter("skip"));
		String descending = request.getParameter("descending");
		List<Film> films = new ArrayList<Film>();
		if (descending.equals("No")) {
			films = filmService.selectFilmsByColumn(column, limit, skip);
		} else {
			films = filmService.selectFilmsByColumnDesc(column, limit, skip);
		}
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head>");
		out.print("<style type='text/css'>");
		out.print("table {width: 100%;border-collapse: collapse;}");
		out.print("table td, th {border: 1px solid #00061a;}");
		out.print("table td {text-align: center}");
		out.print("</style>");
		out.print("</head>");

		out.print("<body>");
		out.print("<div>");
		out.print("<h1 align='center'>Table Films Order</h1>");
		out.print("<hr>");
		out.print("<table style='width: 100%;border-collapse: collapse;border: 1px solid #00061a;'>");

		out.print("<tr>");
		out.print("<th>ID</th>");
		out.print("<th>Title</th>");
		out.print("<th>Description</th>");
		out.print("<th>Release Year</th>");
		out.print("<th>Language Id</th>");
		out.print("<th>Original Language Id</th>");
		out.print("<th>Rental Duration</th>");
		out.print("<th>Rental Rate</th>");
		out.print("<th><a>Length</a></th>");
		out.print("<th>Replacement Cost</th>");
		out.print("<th>Rating</th>");
		out.print("<th>Special Features</th>");
		out.print("<th>Last Update</th>");
		out.print("</tr>");

		for (Film film : films) {
			out.print("<tr>");
			out.print("<td>" + film.getFilm_id() + "</td>");
			out.print("<td>" + film.getTitle() + "</td>");
			out.print("<td>" + film.getDescription() + "</td>");
			out.print("<td>" + film.getRelease_year() + "</td>");
			out.print("<td>" + film.getLanguage_id() + "</td>");
			out.print("<td>" + film.getOriginal_language_id() + "</td>");
			out.print("<td>" + film.getRental_duration() + "</td>");
			out.print("<td>" + film.getRental_rate() + "</td>");
			out.print("<td>" + film.getLength() + "</td>");
			out.print("<td>" + film.getReplacement_cost() + "</td>");
			out.print("<td>" + film.getRating() + "</td>");
			out.print("<td>" + film.getSpecial_features() + "</td>");
			out.print("<td>" + film.getLast_update() + "</td>");
			out.print("</tr>");
		}
		out.print("</table>");
		out.print("</div>");
		out.print("</body>");
		out.print("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
