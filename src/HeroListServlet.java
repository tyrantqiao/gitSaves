
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// TODO: Auto-generated Javadoc
/**
 * The Class HeroListServlet.
 */
public class HeroListServlet extends HttpServlet {

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.http.HttpServlet#service(javax.servlet.http.
	 * HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");

		int start = 0;
		int count = 5;

		List<Hero> heros = new HeroMethod().list();
		for (Hero hero : heros) {
			System.out.println(hero.getName() + hero.getId() + hero.getDamage() + hero.getHp());
		}
		request.setAttribute("Heros", heros);

		request.getRequestDispatcher("listHero.jsp").forward(request, response);

	}
}