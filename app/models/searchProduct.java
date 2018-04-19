package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import io.ebean.Finder;
import io.ebean.Model;
import io.ebean.annotation.View;

@Entity
@View (name="searchProduct")
public class searchProduct extends Model{
	
	
	@Column (name="id")
	private String id;
	@Column(name="productID")
	private int productID;
	@Column(name="productColorID")
	private int productColorID;
	@Column(name="productSizeID")
	private int productSizeID;
	@Column(name="productName")
	private String productName;
	@Column(name="productDesc")
	private String productDesc;
	@Column(name="productType")
	private char productType;
	@Column(name="productMaterial")
	private String productMaterial;
	@Column(name="categoryID")
	private int categoryID;
	@Column(name="categoryName")
	private String categoryName;
	@Column(name="companyID")
	private int companyID;
	@Column(name="companyName")
	private String companyName;
	@Column(name="occasionID")
	private int occasionID;
	@Column(name="occasionName")
	private String occasionName;
	@Column(name="productSolHeight")
	private int productSolHeight;
	@Column(name="productSolMaterial")
	private String productSolMaterial;
	@Column(name="productImageUrl")
	private String productImageUrl;
	@Column(name="price")
	private int price;
	@Column(name="size")
	private int size;
	@Column(name="quantity")
	private int quantity;
	@Column(name="colorName")
	private String colorName;
	
	
	public static Finder<String,searchProduct> searchProductFinder=new Finder<>(searchProduct.class);


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public int getProductID() {
		return productID;
	}


	public void setProductID(int productID) {
		this.productID = productID;
	}


	public int getProductColorID() {
		return productColorID;
	}


	public void setProductColorID(int productColorID) {
		this.productColorID = productColorID;
	}


	public int getProductSizeID() {
		return productSizeID;
	}


	public void setProductSizeID(int productSizeID) {
		this.productSizeID = productSizeID;
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


	public int getCategoryID() {
		return categoryID;
	}


	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}


	public String getCategoryName() {
		return categoryName;
	}


	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}


	public int getCompanyID() {
		return companyID;
	}


	public void setCompanyID(int companyID) {
		this.companyID = companyID;
	}


	public String getCompanyName() {
		return companyName;
	}


	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}


	public int getOccasionID() {
		return occasionID;
	}


	public void setOccasionID(int occasionID) {
		this.occasionID = occasionID;
	}


	public String getOccasionName() {
		return occasionName;
	}


	public void setOccasionName(String occasionName) {
		this.occasionName = occasionName;
	}


	public int getProductSolHeight() {
		return productSolHeight;
	}


	public void setProductSolHeight(int productSolHeight) {
		this.productSolHeight = productSolHeight;
	}


	public String getProductSolMaterial() {
		return productSolMaterial;
	}


	public void setProductSolMaterial(String productSolMaterial) {
		this.productSolMaterial = productSolMaterial;
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


	public String getColorName() {
		return colorName;
	}


	public void setColorName(String colorName) {
		this.colorName = colorName;
	}
	
	
	
}
