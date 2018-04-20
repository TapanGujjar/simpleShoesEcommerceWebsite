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
@Table (name="cart")
public class cart extends Model {
	
	@Id
	@Column(name="cartID")
	private int cartID=0;
	
	@ManyToOne
	@JoinColumn (name="userID")
	private users user;
	
	@ManyToOne
	@JoinColumn (name="productSizeID")
	private productColorSize element;
	
	@Column (name="value")
	private int value;
	
	public static Finder <Integer,cart> cartFinder=new Finder<>(cart.class);

	public int getCartID() {
		return cartID;
	}

	public void setCartID(int cartID) {
		this.cartID = cartID;
	}

	public users getUser() {
		return user;
	}

	public void setUser(users user) {
		this.user = user;
	}

	public productColorSize getElement() {
		return element;
	}

	public void setElement(productColorSize element) {
		this.element = element;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	
 	
	
	
}
