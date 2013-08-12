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
 * 選択した商品を返します。
 */
@WebServlet("/PurchaseCheck")
public class PurchaseCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * チェックボックス接頭辞。
	 */
	private static final String SELECT = "select";

	/**
	 * エラーメッセージ（お名前）。
	 */
	private static final String ERROR_MESSAGE_NAME = "お名前が入力されていません。";

	/**
	 * エラーメッセージ（購入商品）。
	 */
	private static final String ERROR_MESSAGE_NO_PRODUCTS = "購入商品が選択されていません。";

	/**
	 * エラーメッセージ（所持金）。
	 */
	private static final String ERROR_MESSAGE_MONEY = "購入金額が所持金を超えています。";

	/**
	 * 選択した商品から料金を計算します。
	 * 
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		// 購入商品取得
		List<Product> products = Data.getProducts();
		List<Product> purchase = new ArrayList<>();
		List<String> checked = new ArrayList<>();
		int total = 0;
		for (int i = 0; i < products.size(); i++) {
			if (request.getParameter(PurchaseCheckServlet.SELECT + i) != null) {
				purchase.add(products.get(i));
				// 合計料金計算
				total += products.get(i).getPrice();
				// 選択項目
				checked.add("checked=\"checked\"");
			} else {
				// 選択項目
				checked.add("");
			}
		}

		// 名前が入力されていない場合
		if ((request.getParameter("name") == null) || request.getParameter("name").isEmpty()) {
			request.setAttribute("message", PurchaseCheckServlet.ERROR_MESSAGE_NAME);
			PurchaseCheckServlet.back(request, response, checked);
			return;
		}

		// 商品が選択されていない場合
		if (purchase.isEmpty()) {
			request.setAttribute("message", PurchaseCheckServlet.ERROR_MESSAGE_NO_PRODUCTS);
			PurchaseCheckServlet.back(request, response, checked);
			return;
		}

		// 所持金より購入金額が多い場合
		if (Integer.parseInt(request.getParameter("money")) < total) {
			request.setAttribute("message", PurchaseCheckServlet.ERROR_MESSAGE_MONEY);
			PurchaseCheckServlet.back(request, response, checked);
			return;
		}

		// 取得値設定
		request.setAttribute("purchase", purchase);
		request.setAttribute("total", total);

		// 画面遷移
		request.getRequestDispatcher("PurchaseCheck.jsp").forward(request, response);
	}

	/**
	 * 元画面へ遷移するパラメーターを設定します。
	 * 
	 * @param request
	 *            リクエスト
	 * @param response
	 *            レスポンス
	 * @pram checked 選択項目
	 * @throws ServletException
	 *             forward失敗時
	 * @throws IOException
	 *             forward失敗時
	 */
	private static void back(HttpServletRequest request, HttpServletResponse response, List<String> checked) throws ServletException, IOException {
		request.setAttribute("checked", checked);
		request.setAttribute("products", Data.getProducts());
		request.setAttribute("money", Data.getMoney());
		request.getRequestDispatcher("VendingMachine.jsp").forward(request, response);
	}
}
