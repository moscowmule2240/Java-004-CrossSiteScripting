/**
 * ServletTest
 */
package moscowmule2240.java004;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 商品を取得します。
 * 
 * @author moscowmule2240
 */
@WebServlet("/VendingMachine")
public class VendingMachineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 商品を取得し、画面遷移を行います。
	 * 
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 商品設定
		request.setAttribute("products", Data.getProducts());

		// 所持金設定
		request.setAttribute("money", Data.getMoney());

		// 選択項目
		List<String> checked = new ArrayList<>();
		for (int i = 0; i < Data.getProducts().size(); i++) {
			checked.add("");
		}
		request.setAttribute("checked", checked);

		// 画面遷移
		request.getRequestDispatcher("VendingMachine.jsp").forward(request, response);
	}
}
