import sbt._

trait Defaults {
  def androidPlatformName = "android-$platform$"
}
class Parent(info: ProjectInfo) extends ParentProject(info) {
  override def shouldCheckOutputDirectories = false

  lazy val main  = project(".", "$name$", new MainProject(_))
  lazy val tests = project("tests",  "tests", new TestProject(_), main)

  class MainProject(info: ProjectInfo) extends AndroidProject(info) with Defaults with MarketPublish with TypedResources {
    val keyalias  = "change-me"
    val scalatest = "org.scalatest" % "scalatest" % "1.0" % "test"
  }

  class TestProject(info: ProjectInfo) extends AndroidTestProject(info) with Defaults
}
