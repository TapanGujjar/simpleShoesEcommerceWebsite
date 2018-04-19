package models;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import io.ebean.Finder;
import io.ebean.Model;

@Entity
@Table(name="productColor")
public class productColor extends Model {
	
	@Id
	@Column(name="productColorID")
	private int productColorID=0;
	
	@ManyToOne
	@JoinColumn(name="productID")
	@Column(name="productID")
	private products product;
	
	@Column (name="productImageUrl")
	private String productImageUrl;
	
	@Column (name="price")
	private int price;
	
	public static Finder<Integer,productColor> productColorFinder =new Finder<>(productColor.class);

	
	@OneToMany(cascade = CascadeType.ALL)
	public ArrayList<productColorSize> productColorSizeList=new ArrayList<>();
	
	
	public productColor(products product, String productImageUrl, int price) {
		super();
		this.product = product;
		this.productImageUrl = productImageUrl;
		this.price = price;
	}

	public int getProductColorID() {
		return productColorID;
	}

	public void setProductColorID(int productColorID) {
		this.productColorID = productColorID;
	}

	public products getProduct() {
		return product;
	}

	public void setProduct(products product) {
		this.product = product;
	}

	public String getProductImageUrl() {
		return productImageUrl;
	}

	public void setProductImageUrl(String productImageUrl) {
		this.productImageUrl = productImageUrl;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
	
	
	

}
