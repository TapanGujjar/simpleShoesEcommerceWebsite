package generalHelpers;

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
	
	
	public static products insertProduct(products newProduct) {
		newProduct.save();
		System.out.println("NewProdut="+newProduct.getProductID());
		return newProduct;
	}

}
