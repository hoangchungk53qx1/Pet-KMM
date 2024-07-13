plugins {
  alias(libs.plugins.androidApplication)
  alias(libs.plugins.kotlinAndroid)
  alias(libs.plugins.compose.compiler)
//  alias(libs.plugins.kotlin.kapt)
}

kotlin {
  jvmToolchain {
    languageVersion = JavaLanguageVersion.of(17)
  }
}

android {
  namespace = "com.vn.chungha.pet_kmm.android"
  compileSdk = 34
  defaultConfig {
    applicationId = "com.vn.chungha.pet_kmm.android"
    minSdk = 26
    targetSdk = 34
    versionCode = 1
    versionName = "1.0"
  }

  buildFeatures {
    viewBinding = true
    compose = true
  }

  packaging {
    resources {
      excludes += "/META-INF/{AL2.0,LGPL2.1}"
    }
  }
  buildTypes {
    getByName("release") {
      isMinifyEnabled = false
    }
  }

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }

  kotlinOptions {
    options.jvmTarget = org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_11
    freeCompilerArgs = freeCompilerArgs + buildComposeMetricsParameters() + listOf(
      "-opt-in=kotlin.RequiresOptIn",
      // Enable experimental coroutines APIs, including Flow
      "-opt-in=kotlinx.coroutines.ExperimentalCoroutinesApi",
      "-opt-in=kotlinx.coroutines.FlowPreview",
      "-opt-in=kotlin.Experimental",
      // Enable experimental kotlinx serialization APIs
      "-opt-in=kotlinx.serialization.ExperimentalSerializationApi",
    )
  }
}

dependencies {
  implementation(projects.common)
  coreLibraryDesugaring(libs.jdkDesugar)
  implementation(libs.compose.ui)
  implementation(libs.compose.ui.tooling.preview)
  implementation(libs.compose.material3)
  implementation(libs.androidx.activity.compose)
  debugImplementation(libs.compose.ui.tooling)
}

fun Project.buildComposeMetricsParameters(): List<String> {
  val metricParameters = mutableListOf<String>()
  val enableMetricsProvider = project.providers.gradleProperty("enableComposeCompilerMetrics")
  val enableMetrics = (enableMetricsProvider.orNull == "true")
  if (enableMetrics) {
    val composeMetrics = layout.buildDirectory.dir("compose-metrics")

//    val metricsFolder = File(project.buildDir, "compose-metrics")
    metricParameters.add("-P")
    metricParameters.add(
      "plugin:androidx.compose.compiler.plugins.kotlin:metricsDestination=" + composeMetrics.get().asFile.absolutePath,
    )
  }

  val enableReportsProvider = project.providers.gradleProperty("enableComposeCompilerReports")
  val enableReports = (enableReportsProvider.orNull == "true")
  if (enableReports) {
    val composeReports = layout.buildDirectory.dir("compose-reports")

//    val reportsFolder = File(project.buildDir, "compose-reports")
    metricParameters.add("-P")
    metricParameters.add(
      "plugin:androidx.compose.compiler.plugins.kotlin:reportsDestination=" + composeReports.get().asFile.absolutePath,
    )
  }
  return metricParameters.toList()
}
