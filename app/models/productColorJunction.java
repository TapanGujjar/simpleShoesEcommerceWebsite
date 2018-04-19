package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import io.ebean.Finder;
import io.ebean.Model;

@Entity
@Table (name="productColorJunction")
public class productColorJunction extends Model{
	
	@PrimaryKeyJoinColumn
	@ManyToOne
	@JoinColumn(name="productColorID")
	@Column(name="productColorID")
	private productColor productColorElement;
	
	@Column (name="colorName")
	private String colorName;
	
	public static Finder<productColor,productColorJunction> productColorJunctionFinder=new Finder<>(productColorJunction.class);

	public productColor getProductColorElement() {
		return productColorElement;
	}

	public void setProductColorElement(productColor productColorElement) {
		this.productColorElement = productColorElement;
	}

	public String getColorName() {
		return colorName;
	}

	public void setColorName(String colorName) {
		this.colorName = colorName;
	}
	
	

}
