package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import io.ebean.Finder;
import io.ebean.Model;

@Entity
public class occasion extends Model{
	@Id
	@Column(name="occasionID")
	private int occasionID=0;
	@Column(name="occasionName")
	private String occasionName;
	
	public static Finder<Integer,occasion> occasionFinder=new Finder<>(occasion.class);

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


}
