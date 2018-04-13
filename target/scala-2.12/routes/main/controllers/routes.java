// @GENERATOR:play-routes-compiler
// @SOURCE:/home/silverstar/javaProject/shoesstoreonline/conf/routes
// @DATE:Fri Apr 13 02:36:42 EDT 2018

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseuserController userController = new controllers.ReverseuserController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseproductController productController = new controllers.ReverseproductController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseuserController userController = new controllers.javascript.ReverseuserController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseproductController productController = new controllers.javascript.ReverseproductController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
  }

}
