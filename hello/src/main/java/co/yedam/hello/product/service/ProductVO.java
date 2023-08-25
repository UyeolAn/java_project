package co.yedam.hello.product.service;

import lombok.Data;

@Data // getter, setter
public class ProductVO {

	private String productId;
	
	private String productName;
	
	private int productPrice;
	
	private String productModel;
	
	
	public ProductVO() {
		
	}
	
	public ProductVO(String productId, String productName, int productPrice, String productModel) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productModel = productModel;
	}
	
	
	public String toString() {
		String res = "ID: " + productId + ", ";
		res += "상품명: " + productName + ", ";
		res += "가격: " + productPrice + ", ";
		res += "모델명: " + productModel;
		return res;
	}

}
