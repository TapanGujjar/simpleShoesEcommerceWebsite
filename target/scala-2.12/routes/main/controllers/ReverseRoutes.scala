// @GENERATOR:play-routes-compiler
// @SOURCE:/home/silverstar/javaProject/shoesstoreonline/conf/routes
// @DATE:Fri Apr 20 11:13:52 EDT 2018

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers {

  // @LINE:12
  class ReverseuserController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:12
    def userSignUp(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "api/user/signup")
    }
  
    // @LINE:13
    def userLogin(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "api/user/login")
    }
  
  }

  // @LINE:16
  class ReverseproductController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:17
    def searchForProduct(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/product/search")
    }
  
    // @LINE:16
    def addNewProduct(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "api/products/add")
    }
  
    // @LINE:25
    def getAllCategories(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/category/all")
    }
  
    // @LINE:19
    def getAllProduct(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/product/all")
    }
  
    // @LINE:18
    def getAllShoeSizes(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/product/sizes")
    }
  
    // @LINE:21
    def addToCart(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/product/addToCart")
    }
  
    // @LINE:27
    def getAllOccasions(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/occasion/all")
    }
  
    // @LINE:22
    def getmyCart(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/product/getMyCart")
    }
  
    // @LINE:20
    def getProductColorByID(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/product/color")
    }
  
    // @LINE:26
    def getAllCompanies(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/company/all")
    }
  
  }

  // @LINE:6
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:6
    def at(): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"), ("file", "addProduct.html"))); _rrc
      Call("GET", _prefix)
    }
  
    // @LINE:9
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/v"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }


}
