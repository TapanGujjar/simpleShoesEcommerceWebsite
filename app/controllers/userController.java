package controllers;

import play.mvc.*;
import play.mvc.Http.RequestBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.fasterxml.jackson.databind.JsonNode;

import models.users;
import play.data.DynamicForm;
import play.data.Form;
import play.data.FormFactory;
import play.libs.Json;
import DatabaseHelpers.userDatabaseHelpers;
import io.ebean.ExpressionList;
import DatabaseHelpers.userDatabaseHelpers;

public class userController extends Controller{
	

	
	public Result userSignUp(){
		
		JsonNode json=request().body().asJson();
		HashMap<String,String> map=new HashMap<>();
		String fname,lname,email,password;
		try {
			fname=json.get("fname").asText();
			lname=json.get("lname").asText();
			email=json.get("email").asText();
			password=json.get("password").asText();
		}catch(NullPointerException e) {
			map.put("success", "-1");
			map.put("message","Value Missing");
			return badRequest(Json.toJson(map));
		}
		
		
		if(userDatabaseHelpers.checkEmailExists(email)>0) {
			map.put("success","-2");
			map.put("message","Email already exists");
			return badRequest(Json.toJson(map));
		}
		
		users user=userDatabaseHelpers.createUserObject(fname, lname, email, password);
		user=userDatabaseHelpers.addAccessKey(user);
		user=userDatabaseHelpers.insertUser(user);
		
		if(user.getUserID()<=0) {
			map.put("success","-3");
			map.put("message","Error inserting to database");
			return badRequest(Json.toJson(map));
		}
		return ok(Json.toJson(user));
		
	}
	
	
	public Result userLogin() {
		JsonNode json=request().body().asJson();
		String email,password;

		HashMap<String, String> map=new HashMap<>();
		try {
			email=json.get("email").asText();
			password=json.get("password").asText();
		}catch(NullPointerException e) {
			map.put("success", "-1");
			map.put("message","Value Missing");
			return badRequest(Json.toJson(map));
		}
		
		users user=userDatabaseHelpers.checkLoginCred(email, password);
		if(user==null) {
			map.put("success","-2");
			map.put("message","No user Found");
			return badRequest(Json.toJson(map));
		}
		
		user=userDatabaseHelpers.userUpdate(user, user.getFname(), user.getLname(), user.getEmail(),user.getPassword());
		return ok(Json.toJson(user));
		
	}
}
