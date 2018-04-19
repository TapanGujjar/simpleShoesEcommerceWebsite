package generalHelpers;

import io.ebean.ExpressionList;
import models.categories;
import models.company;
import models.occasion;
import models.products;

public class productHelperFunctions {
	
	public static categories getCategoryByID(int id) {
		categories category=categories.categoryFinder.byId(id);
		return category;
	}
	
	public static company getManufacturersByID(int id) {
		company manufacturer=company.companyFinder.byId(id);
		return manufacturer;
	}
	
	public static occasion getOccasionByID(int id) {
		occasion occ=occasion.occasionFinder.byId(id);
		return occ;
	}
	
	public static products getProductFromCategory(int categoryID) {
		ExpressionList<products> product=products.productFinder.query().where().like("productCategory",Integer.toString(categoryID));
		
		return null;
		
	}
	
	
	public static products insertProduct(products newProduct) {
		newProduct.save();
		return newProduct;
	}

}
