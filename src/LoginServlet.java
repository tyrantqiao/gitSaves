
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class LoginServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");

		String name = request.getParameter("name");
		String password = request.getParameter("password");

		String result = "<h>" + name + "  " + password + "<h>";
		response.setCharacterEncoding("UTF-8");
		response.getWriter().println(result);

		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload();

		// request.getRequestDispatcher("success.html").forward(request,
		// response);
		// response.sendRedirect("success.html");
	}

	// protected void doPost(HttpServletRequest request, HttpServletResponse
	// response)
	// throws ServletException, IOException {
	// String name = request.getParameter("name");
	// String password = request.getParameter("password");
	//
	// response.getWriter().println("<h1>Hello Servlet!</h1>");
	//
	// System.out.println("name:" + name);
	// System.out.println("password:" + password);
	// }

}