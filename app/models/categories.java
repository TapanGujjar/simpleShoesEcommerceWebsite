package models;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import models.products;
import io.ebean.Finder;
import io.ebean.Model;

@Entity
public class categories extends Model{
	
	@Id
	@Column(name="categoryID")
	private int categoryID=0;
	@Column(name="categoryName")
	private String categoryName;
	
	public static Finder<Integer,categories> categoryFinder=new Finder<>(categories.class);

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
	
	
    @OneToMany(cascade = CascadeType.ALL)
    public ArrayList<products> categoryProductList = new ArrayList<products>();

	
}
