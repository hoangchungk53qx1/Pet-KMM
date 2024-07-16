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

    isCoreLibraryDesugaringEnabled = true

    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
  }

  kotlinOptions {
    options.jvmTarget = org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_11
    freeCompilerArgs = freeCompilerArgs + listOf(
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
  implementation(libs.androidx.activity.compose)

  implementation(platform(libs.androidx.compose.bom))
  implementation(libs.androidx.compose.foundation)
  implementation(libs.androidx.compose.foundation.layout)
  implementation(libs.androidx.compose.material)
  implementation(libs.androidx.compose.runtime)
  implementation(libs.androidx.compose.ui)
  implementation(libs.androidx.compose.ui.tooling)

  implementation(libs.androidx.compose.material3)
  implementation(libs.androidx.compose.material3.windowSizeClass)

  implementation(libs.androidx.navigation.compose)
  implementation(libs.androidx.lifecycle.compose)
  implementation(libs.coilCompose)

  implementation(libs.accompanist.placeholder)

  implementation(libs.immutable.collection)

  implementation(libs.koin.core)
  implementation(libs.koin.android)
  implementation(libs.koin.androidx.compose)

  testImplementation(libs.junit)
  testImplementation(libs.koin.test)
  androidTestImplementation(platform(libs.androidx.compose.bom))
  androidTestImplementation(libs.androidx.compose.ui.test)
  androidTestImplementation(libs.androidx.compose.ui.test.junit)
  debugImplementation(libs.androidx.compose.ui.test.manifest)
}

