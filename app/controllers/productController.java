package controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

import models.categories;
import models.company;
import models.occasion;
import models.productColor;
import models.productColorJunction;
import models.productColorSize;
import models.products;
import models.searchProduct;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import generalHelpers.productHelperFunctions;
import io.ebean.Ebean;
import io.ebean.Query;
import io.ebean.RawSql;
import io.ebean.RawSqlBuilder;

public class productController extends Controller {
	
	public Result getAllCategories() {
		
		List<categories> categoryList=categories.categoryFinder.all();
		System.out.println(categoryList.get(0).categoryProductList);
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
	
	public Result getAllShoeSizes() {
		HashMap<String,String> map=new HashMap<String,String>();
		int i;
		try {
		List<productColorSize> shoeSizes=productColorSize.productColorSizeFinder.nativeSql("Select * from productColorSize where 1 group by size").findList();
		System.out.println(shoeSizes.size());
		if(shoeSizes.size()<=0) {
			throw new NullPointerException("No value Found");
		}
		i=0;
		for(i=0;i<shoeSizes.size();i++) {
			System.out.println(shoeSizes.get(i).getSize());
			map.put("size_"+Integer.toString(shoeSizes.get(i).getSize()),Integer.toString(shoeSizes.get(i).getSize()));
		}
		System.out.println("map Size="+map.size());
		return ok(Json.toJson(map));
		}
		catch(NullPointerException e) {
			map.put("success", "-1");
			map.put("Message","No Record Found");
			return badRequest(Json.toJson(map));
		}
	}
	
	public Result getAllProduct() {
		HashMap<String,String> map=new HashMap<String,String>();

		String offset=request().getQueryString("offset");
		
		int i=0;
		try {
			String sql="Select `id`, `productID`, `productColorID`, `productSizeID`, `productName`, `productDesc`, `productType`, `productMaterial`, `categoryID`, `categoryName`, `companyID`, `companyName`, `occasionID`, `occasionName`, `productSolHeight`, `productSolMaterial`, `productImageUrl`, `price`, `size`, `quantity`, `colorName` from searchProduct where 1 ";
		    
			System.out.println("Sql String="+sql);
			List<searchProduct> products=searchProduct.searchProductFinder.nativeSql(sql).findList();
			
			if(products.size()<=0) {
				throw new NullPointerException("Zero Values");
			}
			
			i=0;
			ArrayList<searchProduct> finalProducts=new ArrayList<searchProduct>();
			HashSet<Integer> set=new HashSet<Integer>();
			for(i=0;i<products.size();i++) {
				if(set.contains(products.get(i).getProductColorID())==false) {
					set.add(products.get(i).getProductColorID());
					finalProducts.add(products.get(i));
				}
			}
			
			System.out.println(products.get(0).getProductImageUrl());
			return ok(Json.toJson(finalProducts));
			
		}
		catch(NullPointerException e) {
			map.put("success","-1");
			map.put("message","No value found");
			return badRequest(Json.toJson(map));
		}
		
		
		
	}
	
	public Result addNewProduct() {
		JsonNode json=request().body().asJson();
		HashMap<String,String> map=new HashMap<>();
		
		String productName,productDesc;
		String productType;
		String productMaterial,productCategory,productOccasion;
		String productSolHeight,productSolMaterial,productManufacturers;
		int numVariant;
		String[] variantIndices;
		productColor[] productColorElements;
		String productImageUrl,productColor;
		int price;
		String sizeString;
		String quantityString;
		int cur_index;
		try {
			
			numVariant=Integer.parseInt(json.get("numVariant").asText());
			variantIndices=json.get("variantIndex").asText().split("_");
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
			System.out.println("1");;
			productColorElements=new productColor[numVariant+1];
			for(int i=0;i<=numVariant;i++) {
				cur_index=Integer.parseInt(variantIndices[i]);
				System.out.println("cur_index="+cur_index);
				productImageUrl=json.get("productImageUrl"+cur_index).asText();
				System.out.println("3");
				productColor=json.get("productColor"+cur_index).asText();
				price=Integer.parseInt(json.get("price"+cur_index).asText());
				sizeString=json.get("size"+cur_index).asText();
				quantityString=json.get("quantity"+cur_index).asText();
				
				System.out.println("ProductCOlor="+productColor);
				String sizes[]=sizeString.split(",");
				String quantity[]=quantityString.split(",");
				String colors[]=productColor.split(",");
				
				
				if(quantity.length==sizes.length) {
					productColorElements[i]=new productColor(newProduct,productImageUrl,price);
					productColorElements[i].save();
					
					//Adding product Color 
					for(int k=0;k<colors.length;k++) {
						productColorJunction junc=new productColorJunction();
						junc.setProductColorElement(productColorElements[i]);
						junc.setColorName(colors[k]);
						junc.save();
					}
					
					
					//Adding product Color Sizes 
					for(int j=0;j<sizes.length;j++) {
						productColorSize productColorSizeElement=new productColorSize(productColorElements[i], Integer.parseInt(sizes[j]), Integer.parseInt(quantity[j]));
						productColorSizeElement.save();
					}
					
				}
				else {
					map.put("success","-1");
					map.put("message","Sizes and quantiy of variant are not same");
					return badRequest(Json.toJson(map));
				}
				
			}
			
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
	
	public Result searchForProduct() {
		String searchQuery=request().getQueryString("term");
		
		String[] columnName= {"id", "productID", "productColorID", "productSizeID", "productName", "productDesc", "productType", "productMaterial", "categoryID", "categoryName", "companyID", "companyName", "occasionID", "occasionName", "productSolHeight", "productSolMaterial", "productImageUrl", "price", "size", "quantity", "colorName"};
		String[] searchTerms=searchQuery.split(" ");
		System.out.println("Column Length="+columnName.length);
		System.out.println("SearchTerms="+searchTerms.length);
		int i,j;
		String query="Select * from searchProduct where ";
		for(i=0;i<searchTerms.length;i++) {
			for(j=0;j<columnName.length;j++){
				query=query+ (columnName[j]+" like '%"+searchTerms[i]+"%'");
				if(j<columnName.length ) {
					System.out.println("j="+j);
					System.out.println("i="+i);
					if(i<searchTerms.length)
						query=query+" OR ";
				}
			}
		}
		query=query.substring(0, query.length()-3);
		
		List<searchProduct> searchProductList=searchProduct.searchProductFinder.nativeSql(query).findList();
		ArrayList<searchProduct> searchList=new ArrayList<searchProduct>();
		i=0;
		HashSet<Integer> set=new HashSet<Integer>();
		for(i=0;i<searchProductList.size();i++) {
			if(set.contains(searchProductList.get(i).getProductColorID())==false) {
				set.add(searchProductList.get(i).getProductColorID());
				searchList.add(searchProductList.get(i));
			}
		}
		

				
		return ok(Json.toJson(searchList));
	}
	
	


}
