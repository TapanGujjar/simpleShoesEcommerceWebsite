package models;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import io.ebean.Finder;
import io.ebean.Model;


@Entity
public class company extends Model {
	
	@Id
	@Column(name="companyID")
	private int companyID=0;
	@Column(name="companyName")
	private String companyName;
	
	public static Finder<Integer,company> companyFinder=new Finder<>(company.class);


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

    @OneToMany(cascade = CascadeType.ALL)
    public ArrayList<products> companyProductList = new ArrayList<products>();
	

}
