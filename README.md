# sbt-plugins

Root project for my SBT plugins.

Current plugins:
* create-source-folders-plugin

## create-source-folders-plugin

This plugin provides a task to create the source folders for a new project.
I created this plugin out of frustration because Sbt is just lacking this basic functionality
and every time I create a new project, I miss this.

_This plugin is currently not available via a public repository yet._

Build sources locally:

```sbt publishLocal```

Add it to _~/.sbt/0.13/plugins/plugins.sbt_ or _project/plugins.sbt_ in your project

```addSbtPlugin("eu.diversit.sbt.plugins" % "create-source-folders-plugin" % "1.0")```

No additional settings needed since this is an _AutoPlugin_.

### Using the plugin

The plugin has currently just 1 task: createFolders.
There are no settings.

```sbt createFolders```




