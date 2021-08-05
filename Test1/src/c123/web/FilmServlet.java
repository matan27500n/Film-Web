package c123.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import c123.model.Film;
import c123.service.FilmService;
import c123.service.FilmServiceImp;

@WebServlet("/FilmServlet")
public class FilmServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private FilmService filmService;

	@Override
	public void init() throws ServletException {
		super.init();
		filmService = new FilmServiceImp();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Film> films = filmService.findAllFilms();
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		Gson gson = new Gson();
		if (films.size() > 0) {
			String jsonData = gson.toJson(films);
			out.print(jsonData);
		}
		out.close();
	}
}
