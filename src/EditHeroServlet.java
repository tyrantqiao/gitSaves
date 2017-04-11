import java.util.List;

import javax.servlet.http.HttpServlet;

public class EditHeroServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(javax.servlet.http.HttpServletRequest arg0, javax.servlet.http.HttpServletResponse arg1)
			throws javax.servlet.ServletException, java.io.IOException {
		List<Hero> heros = new HeroMethod().list(1, 5);

		arg0.setAttribute("heros", heros);

		arg0.getRequestDispatcher("listHero.jsp").forward(arg0, arg1);

	}

}
