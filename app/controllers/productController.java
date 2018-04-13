package controllers;

import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

import models.categories;
import models.company;
import models.occasion;
import models.products;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import generalHelpers.productHelperFunctions;

public class productController extends Controller {
	
	public Result getAllCategories() {
		
		List<categories> categoryList=categories.categoryFinder.all();
		return ok(Json.toJson(categoryList));
		
	}
	
	public Result getAllCompanies() {
		List<company> companyList=company.companyFinder.all();
		return ok(Json.toJson(companyList));
	}
	
	public Result getAllOccasions() {
		List<occasion> occasionList=occasion.occasionFinder.all();
		return ok(Json.toJson(occasionList));
	}
	
	public Result addNewProduct() {
		JsonNode json=request().body().asJson();
		HashMap<String,String> map=new HashMap<>();
		
		String productName,productDesc;
		String productType;
		String productMaterial,productCategory,productOccasion;
		String productSolHeight,productSolMaterial,productManufacturers;
		try {
			productName=json.get("productName").asText();
			System.out.println(productName);
			productDesc=json.get("productDesc").asText();
			productType=json.get("productType").asText();
			productMaterial=json.get("productMaterial").asText();
			productCategory=json.get("productCategory").asText();
			productOccasion=json.get("productOccasion").asText();
			productSolHeight=json.get("productSolHeight").asText();
			productSolMaterial=json.get("productSolMaterial").asText();
			productManufacturers=json.get("productManufacturer").asText();
			
			categories category=productHelperFunctions.getCategoryByID(Integer.parseInt(productCategory));
			occasion occasion=productHelperFunctions.getOccasionByID(Integer.parseInt(productOccasion));
			company manufacturer=productHelperFunctions.getManufacturersByID(Integer.parseInt(productManufacturers));
			
			System.out.println(category.getCategoryName());
			System.out.println(occasion.getOccasionName());
			System.out.println(manufacturer.getCompanyName());
			
			products newProduct=new products(productName, productDesc, productType.charAt(0), productMaterial, category, occasion, productSolHeight, productSolMaterial, manufacturer);
			newProduct=productHelperFunctions.insertProduct(newProduct);
			System.out.println("productID="+newProduct.getProductID());
			if(newProduct.getProductID()!=0) {
				map.put("success","1");
				map.put("message","Added");
				return ok(Json.toJson(map));
			}
			else {
				map.put("success","0");
				map.put("message","Error while inserting");
				return internalServerError(Json.toJson(map));
			}
		}catch(NullPointerException e) {
			map.put("success","-1");
			map.put("message","Some missing value");
			return badRequest(Json.toJson(map));
		}catch(NumberFormatException e) {
			map.put("success","-2");
			map.put("message","Integer Error");
			return badRequest(Json.toJson(map));
		}
		
		
	}
	
	

}
