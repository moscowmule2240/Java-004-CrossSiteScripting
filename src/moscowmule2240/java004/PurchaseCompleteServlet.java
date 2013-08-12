/**
 * ServletTest
 */
package moscowmule2240.java004;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 精算を行います。
 * 
 * @author moscowmule2240
 */
@WebServlet("/PurchaseComplete")
public class PurchaseCompleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 精算を行います。
	 * 
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		int money = Integer.parseInt(request.getParameter("money"));
		int total = Integer.parseInt(request.getParameter("total"));
		request.setAttribute("change", money - total);

		request.getRequestDispatcher("PurchaseComplete.jsp").forward(request, response);
	}
}
