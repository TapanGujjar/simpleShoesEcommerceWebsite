package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import io.ebean.Finder;
import io.ebean.Model;

@Entity
public class products extends Model {
	@Id
	@Column(name="productID")
	private int productID=0;
	@Column(name="productName")
	private String productName;
	@Column(name="productDesc")
	private String productDesc;
	@Column(name="productType")
	private char productType;
	@Column(name="productMaterial")
	private String productMaterial;
	@PrimaryKeyJoinColumn
	@Column(name="productCategory")
	private categories category;
	@PrimaryKeyJoinColumn
	@Column(name="productOccasion")
	private occasion occasion;
	@Column(name="productSolHeight")
	private String productSolHeight;
	@Column(name="productSolMaterial")
	private String productSolMaterial;
	@PrimaryKeyJoinColumn
	@Column(name="productManufacturers")
	private company manufacturers;

	public static Finder<Integer,products> productFinder=new Finder<>(products.class);

	
	
	public products( String productName, String productDesc, char productType, String productMaterial,
			categories category, models.occasion occasion, String productSolHeight, String productSolMaterial,
			company manufacturers) {
		super();
		this.productName = productName;
		this.productDesc = productDesc;
		this.productType = productType;
		this.productMaterial = productMaterial;
		this.category = category;
		this.occasion = occasion;
		this.productSolHeight = productSolHeight;
		this.productSolMaterial = productSolMaterial;
		this.manufacturers = manufacturers;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public char getProductType() {
		return productType;
	}

	public void setProductType(char productType) {
		this.productType = productType;
	}

	public String getProductMaterial() {
		return productMaterial;
	}

	public void setProductMaterial(String productMaterial) {
		this.productMaterial = productMaterial;
	}

	public categories getCategory() {
		return category;
	}

	public void setCategory(categories category) {
		this.category = category;
	}

	public occasion getOccasion() {
		return occasion;
	}

	public void setOccasion(occasion occasion) {
		this.occasion = occasion;
	}

	public String getProductSolHeight() {
		return productSolHeight;
	}

	public void setProductSolHeight(String productSolHeight) {
		this.productSolHeight = productSolHeight;
	}

	public String getProductSolMaterial() {
		return productSolMaterial;
	}

	public void setProductSolMaterial(String productSolMaterial) {
		this.productSolMaterial = productSolMaterial;
	}

	public company getManufacturers() {
		return manufacturers;
	}

	public void setManufacturers(company manufacturers) {
		this.manufacturers = manufacturers;
	}
	
	
	
}