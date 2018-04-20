// @GENERATOR:play-routes-compiler
// @SOURCE:/home/silverstar/javaProject/shoesstoreonline/conf/routes
// @DATE:Fri Apr 20 11:13:52 EDT 2018

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers.javascript {

  // @LINE:12
  class ReverseuserController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:12
    def userSignUp: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.userController.userSignUp",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/user/signup"})
        }
      """
    )
  
    // @LINE:13
    def userLogin: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.userController.userLogin",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/user/login"})
        }
      """
    )
  
  }

  // @LINE:16
  class ReverseproductController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:17
    def searchForProduct: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.productController.searchForProduct",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/product/search"})
        }
      """
    )
  
    // @LINE:16
    def addNewProduct: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.productController.addNewProduct",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/products/add"})
        }
      """
    )
  
    // @LINE:25
    def getAllCategories: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.productController.getAllCategories",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/category/all"})
        }
      """
    )
  
    // @LINE:19
    def getAllProduct: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.productController.getAllProduct",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/product/all"})
        }
      """
    )
  
    // @LINE:18
    def getAllShoeSizes: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.productController.getAllShoeSizes",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/product/sizes"})
        }
      """
    )
  
    // @LINE:21
    def addToCart: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.productController.addToCart",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/product/addToCart"})
        }
      """
    )
  
    // @LINE:27
    def getAllOccasions: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.productController.getAllOccasions",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/occasion/all"})
        }
      """
    )
  
    // @LINE:22
    def getmyCart: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.productController.getmyCart",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/product/getMyCart"})
        }
      """
    )
  
    // @LINE:20
    def getProductColorByID: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.productController.getProductColorByID",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/product/color"})
        }
      """
    )
  
    // @LINE:26
    def getAllCompanies: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.productController.getAllCompanies",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/company/all"})
        }
      """
    )
  
  }

  // @LINE:6
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:6
    def at: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.at",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
    // @LINE:9
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }


}
