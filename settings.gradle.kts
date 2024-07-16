enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

// arrayOf("gradle.properties", "gradle").forEach(::copyToBuildSrc)

pluginManagement {
  repositories {
    google()
    gradlePluginPortal()
    mavenCentral()
  }
}

dependencyResolutionManagement {
  repositories {
    google()
    mavenCentral()
  }
}

rootProject.name = "pet-kmm"
include(":androidApp")
include(":common")

fun includeProject(name: String, filePath: String) {
  include(name)
  project(name).projectDir = File(filePath)
}

fun copyToBuildSrc(sourcePath: String) {
  rootDir.resolve(sourcePath).copyRecursively(
    target = rootDir.resolve("buildSrc").resolve(sourcePath),
    overwrite = true,
  )
  rootDir.resolve(sourcePath).copyRecursively(
    target = rootDir.resolve("buildSrc")
      .resolve("buildSrc")
      .resolve(sourcePath),
    overwrite = true,
  )
  println("[DONE] copied $sourcePath")
}

plugins {
  id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}
