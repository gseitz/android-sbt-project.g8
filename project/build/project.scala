import sbt._

class TemplateProject(info: ProjectInfo) extends DefaultProject(info) with giter8.Template {
  
  override def templateSources = super.templateSources --- (descendents(templateSourcePath, "*.png"))
  
}
