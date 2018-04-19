package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.ebean.Finder;
import io.ebean.Model;

@Entity
@Table(name="productColorSize")
public class productColorSize extends Model{

	@Id
	@Column (name="productSizeID")
	private int productSizeID;
	
	@ManyToOne
	@JoinColumn (name="productColorID")
	@Column (name="productColorID")
	private productColor productColorElement;
	
	@Column (name="size")
	private int size;
	
	@Column (name="quantity")
	private int quantity;

	public static Finder <Integer,productColorSize> productColorSizeFinder=new Finder<>(productColorSize.class);
	
	public productColorSize(productColor productColorElement, int size, int quantity) {
		super();
		this.productColorElement = productColorElement;
		this.size = size;
		this.quantity = quantity;
	}

	public int getProductSizeID() {
		return productSizeID;
	}

	public void setProductSizeID(int productSizeID) {
		this.productSizeID = productSizeID;
	}

	public productColor getProductColorElement() {
		return productColorElement;
	}

	public void setProductColorElement(productColor productColorElement) {
		this.productColorElement = productColorElement;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
	
	
}
