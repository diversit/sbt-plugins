package eu.diversit.sbt.plugins

import sbt.{Def, _}
import Keys._

/**
  * An SBT plugin to provide a task to create source and test folders for a new project.
  */
object CreateSourceFoldersPlugin extends AutoPlugin {

  object autoImport {

    val createFolders = taskKey[Unit]("Create all source folders")
  }

  import autoImport._

  override def trigger: PluginTrigger = allRequirements

  lazy val createFoldersSettings: Seq[Def.Setting[_]] = Seq(

    createFolders := {
      CreateFolders(streams.value.log, (sourceDirectories in Compile).value, (sourceDirectories in Test).value)
    }
  )

  override def projectSettings: Seq[Def.Setting[_]] = inConfig(Compile)(createFoldersSettings)
}

object CreateFolders {

  def apply(logger: Logger, allFolderSeqs: Seq[File]*): Unit = {
    for {
      folders <- allFolderSeqs
      folder  <- folders
    } yield {
      if (folder.exists()) {
        logger.info(s"Folder '$folder' already exists")
      } else if (folder.getPath.contains("target/scala")) {
        logger.debug(s"Ignoring folder '$folder'")
      } else {
        folder.mkdirs()
        logger.info(s"Created folder '$folder'")
      }
    }
  }
}