package DatabaseHelpers;

import java.util.HashMap;
import java.util.List;

import javax.persistence.NonUniqueResultException;

import io.ebean.ExpressionList;
import io.ebean.Query;
import models.users;
import models.users;
import generalHelpers.simpleHelper;


public class userDatabaseHelpers {
	
	public static users insertUser(users user) {
		user.save();
		return user;
	}
	
	public static users getUserById(String id) {
		return users.userfind.byId(id);
	}
	
	public static ExpressionList<users> findUserByAttribute(String attribute,String value) {
		ExpressionList<users> userList=users.userfind.query().where().like(attribute, value);
		return userList;
	}
	
	
	public static int checkEmailExists(String email) {
		ExpressionList<users> userList=findUserByAttribute("email", email);
		return userList.findCount();
	}
	
	public static users createUserObject(String fname,String lname,String email,String password) {
		return new users(fname,lname,email,password);
		
	}
	
	public static users addAccessKey(users user) {
		user.setAccessKey(simpleHelper.getSaltString(30));
		return user;
	}
	
	public static users checkLoginCred(String email,String password) {
		ExpressionList<users> userList=users.userfind.query().where().like("email", email).like("password", password);
		
		if(userList.findCount()<=0) {
			return null;
		}
		else if(userList.findCount()>1) {
			return null;
		}
		else {
			try {
				return userList.findOne();
				
			}catch(NonUniqueResultException e) {
				return null;
			}
		}
		
	}
	
	public static users userUpdate(users user,String fname,String lname,String email,String password) {
		user.setFname(fname);
		user.setLname(lname);
		user.setEmail(email);
		user.setPassword(password);
		user=addAccessKey(user);
		
		user.update();
		return user;
		
	}
	
}
