/**
 * ServletTest
 */
package moscowmule2240.java004;

/**
 * 商品クラス。
 * 
 * @author moscowmule2240
 */
public class Product {

	/**
	 * 商品名。
	 */
	private String name;

	/**
	 * 価格。
	 */
	private int price;

	/**
	 * コンストラクタ。
	 * 
	 * @param name
	 *            商品名
	 * @param price
	 *            価格
	 */
	public Product(String name, int price) {
		this.name = name;
		this.price = price;
	}

	/**
	 * 商品名を取得します。
	 * 
	 * @return name 商品名
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * 価格を取得します。
	 * 
	 * @return price 価格
	 */
	public int getPrice() {
		return this.price;
	}
}
