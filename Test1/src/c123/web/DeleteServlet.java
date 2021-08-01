package c123.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import c123.service.FilmServiceImp;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteServlet() {
		// super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int film_id = Integer.parseInt(request.getParameter("film_id").trim());
		System.out.println("film id 123: " + film_id);
		System.out.println("hello world");
		FilmServiceImp filmServiceImp = new FilmServiceImp();
		System.out.println("servlet 1");
		int status = filmServiceImp.deleteFilm(film_id);
		System.out.println("servlet 2");
		if (status > 0) {
			out.print("<p>Record deleted successfully!</p>");
			// response.sendRedirect("film.html");
		} else {
			out.println("Sorry! unable to delete record");
			// response.sendRedirect("film.html");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
