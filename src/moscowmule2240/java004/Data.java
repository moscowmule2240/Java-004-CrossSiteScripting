/**
 * ServletTest
 */
package moscowmule2240.java004;

import java.util.ArrayList;
import java.util.List;

/**
 * データを取得します。
 * 
 * @author moscowmule2240
 */
public class Data {

	/**
	 * 商品。
	 */
	private static final List<Product> PRODUCTS;

	/**
	 * 所持金。
	 */
	private static final List<Integer> MONEY;

	static {
		PRODUCTS = new ArrayList<>();
		Data.PRODUCTS.add(new Product("アラバマ", 100));
		Data.PRODUCTS.add(new Product("アーカンソー", 110));
		Data.PRODUCTS.add(new Product("アリゾナ", 120));
		Data.PRODUCTS.add(new Product("カリフォルニア", 140));
		Data.PRODUCTS.add(new Product("コロラド", 150));
		Data.PRODUCTS.add(new Product("コネチカット", 200));
		Data.PRODUCTS.add(new Product("コロンビア", 250));
		Data.PRODUCTS.add(new Product("フロリダ", 110));
		Data.PRODUCTS.add(new Product("ジョージア", 100));
		Data.PRODUCTS.add(new Product("ハワイ", 120));
		Data.PRODUCTS.add(new Product("アイオワ", 150));
		Data.PRODUCTS.add(new Product("アイダホ", 200));
		Data.PRODUCTS.add(new Product("イリノイ", 140));
		Data.PRODUCTS.add(new Product("インディアナ", 250));
		Data.PRODUCTS.add(new Product("ケンタッキー", 100));
		Data.PRODUCTS.add(new Product("ルイジアナ", 250));
		Data.PRODUCTS.add(new Product("マサチューセッツ", 110));
		Data.PRODUCTS.add(new Product("メリーランド", 80));
		Data.PRODUCTS.add(new Product("メーン", 120));
		Data.PRODUCTS.add(new Product("ミシガン", 140));
		Data.PRODUCTS.add(new Product("ミネソタ", 200));
		Data.PRODUCTS.add(new Product("ミシシッピ", 110));
		Data.PRODUCTS.add(new Product("モンタナ", 120));
		Data.PRODUCTS.add(new Product("ノースカロライナ", 140));
		Data.PRODUCTS.add(new Product("ノースダコタ", 250));
		Data.PRODUCTS.add(new Product("ネブラスカ", 80));
		Data.PRODUCTS.add(new Product("ニューハンプシャー", 100));
		Data.PRODUCTS.add(new Product("ニュージャージー", 150));

		MONEY = new ArrayList<>();
		Data.MONEY.add(100);
		Data.MONEY.add(500);
		Data.MONEY.add(1000);
		Data.MONEY.add(5000);
	}

	/**
	 * 商品を返します。
	 * 
	 * @return 商品
	 */
	public static List<Product> getProducts() {
		return Data.PRODUCTS;
	}

	/**
	 * 所持金を返します。
	 * 
	 * @return 所持金
	 */
	public static List<Integer> getMoney() {
		return Data.MONEY;
	}
}
