// @GENERATOR:play-routes-compiler
// @SOURCE:/home/silverstar/javaProject/shoesstoreonline/conf/routes
// @DATE:Fri Apr 20 11:13:52 EDT 2018


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
