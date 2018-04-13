// @GENERATOR:play-routes-compiler
// @SOURCE:/home/silverstar/javaProject/shoesstoreonline/conf/routes
// @DATE:Fri Apr 13 02:36:42 EDT 2018

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  Assets_1: controllers.Assets,
  // @LINE:12
  userController_2: controllers.userController,
  // @LINE:16
  productController_0: controllers.productController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    Assets_1: controllers.Assets,
    // @LINE:12
    userController_2: controllers.userController,
    // @LINE:16
    productController_0: controllers.productController
  ) = this(errorHandler, Assets_1, userController_2, productController_0, "/")

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, Assets_1, userController_2, productController_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.Assets.at(path:String = "/public", file:String = "addProduct.html")"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/v", file:Asset)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/user/signup""", """controllers.userController.userSignUp"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/user/login""", """controllers.userController.userLogin"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/products/add""", """controllers.productController.addNewProduct"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/category/all""", """controllers.productController.getAllCategories"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/company/all""", """controllers.productController.getAllCompanies"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/occasion/all""", """controllers.productController.getAllOccasions"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_Assets_at0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_Assets_at0_invoker = createInvoker(
    Assets_1.at(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "at",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """""",
      """ An example controller showing a sample home page""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val controllers_Assets_versioned1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned1_invoker = createInvoker(
    Assets_1.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )

  // @LINE:12
  private[this] lazy val controllers_userController_userSignUp2_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/user/signup")))
  )
  private[this] lazy val controllers_userController_userSignUp2_invoker = createInvoker(
    userController_2.userSignUp,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.userController",
      "userSignUp",
      Nil,
      "POST",
      this.prefix + """api/user/signup""",
      """ User Controller""",
      Seq()
    )
  )

  // @LINE:13
  private[this] lazy val controllers_userController_userLogin3_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/user/login")))
  )
  private[this] lazy val controllers_userController_userLogin3_invoker = createInvoker(
    userController_2.userLogin,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.userController",
      "userLogin",
      Nil,
      "POST",
      this.prefix + """api/user/login""",
      """""",
      Seq()
    )
  )

  // @LINE:16
  private[this] lazy val controllers_productController_addNewProduct4_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/products/add")))
  )
  private[this] lazy val controllers_productController_addNewProduct4_invoker = createInvoker(
    productController_0.addNewProduct,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.productController",
      "addNewProduct",
      Nil,
      "POST",
      this.prefix + """api/products/add""",
      """Product Controller""",
      Seq()
    )
  )

  // @LINE:19
  private[this] lazy val controllers_productController_getAllCategories5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/category/all")))
  )
  private[this] lazy val controllers_productController_getAllCategories5_invoker = createInvoker(
    productController_0.getAllCategories,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.productController",
      "getAllCategories",
      Nil,
      "GET",
      this.prefix + """api/category/all""",
      """Category,Company and occasion Controller""",
      Seq()
    )
  )

  // @LINE:20
  private[this] lazy val controllers_productController_getAllCompanies6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/company/all")))
  )
  private[this] lazy val controllers_productController_getAllCompanies6_invoker = createInvoker(
    productController_0.getAllCompanies,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.productController",
      "getAllCompanies",
      Nil,
      "GET",
      this.prefix + """api/company/all""",
      """""",
      Seq()
    )
  )

  // @LINE:21
  private[this] lazy val controllers_productController_getAllOccasions7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/occasion/all")))
  )
  private[this] lazy val controllers_productController_getAllOccasions7_invoker = createInvoker(
    productController_0.getAllOccasions,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.productController",
      "getAllOccasions",
      Nil,
      "GET",
      this.prefix + """api/occasion/all""",
      """""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_Assets_at0_route(params@_) =>
      call(Param[String]("path", Right("/public")), Param[String]("file", Right("addProduct.html"))) { (path, file) =>
        controllers_Assets_at0_invoker.call(Assets_1.at(path, file))
      }
  
    // @LINE:9
    case controllers_Assets_versioned1_route(params@_) =>
      call(Param[String]("path", Right("/v")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned1_invoker.call(Assets_1.versioned(path, file))
      }
  
    // @LINE:12
    case controllers_userController_userSignUp2_route(params@_) =>
      call { 
        controllers_userController_userSignUp2_invoker.call(userController_2.userSignUp)
      }
  
    // @LINE:13
    case controllers_userController_userLogin3_route(params@_) =>
      call { 
        controllers_userController_userLogin3_invoker.call(userController_2.userLogin)
      }
  
    // @LINE:16
    case controllers_productController_addNewProduct4_route(params@_) =>
      call { 
        controllers_productController_addNewProduct4_invoker.call(productController_0.addNewProduct)
      }
  
    // @LINE:19
    case controllers_productController_getAllCategories5_route(params@_) =>
      call { 
        controllers_productController_getAllCategories5_invoker.call(productController_0.getAllCategories)
      }
  
    // @LINE:20
    case controllers_productController_getAllCompanies6_route(params@_) =>
      call { 
        controllers_productController_getAllCompanies6_invoker.call(productController_0.getAllCompanies)
      }
  
    // @LINE:21
    case controllers_productController_getAllOccasions7_route(params@_) =>
      call { 
        controllers_productController_getAllOccasions7_invoker.call(productController_0.getAllOccasions)
      }
  }
}
