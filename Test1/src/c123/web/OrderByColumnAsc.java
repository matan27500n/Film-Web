package c123.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
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
		List<Film> films = filmService.findAllFilms();
		List<Integer> lengths = new ArrayList<Integer>();
		for (int i = 0; i < films.size(); i++) {
			lengths.add(films.get(i).getLength());
		}
		Collections.sort(lengths);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
