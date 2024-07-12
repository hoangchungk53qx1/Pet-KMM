plugins {
  alias(libs.plugins.kotlinMultiplatform)
  alias(libs.plugins.kotlinCocoapods)
  alias(libs.plugins.androidLibrary)
  id("co.touchlab.skie") version "0.8.2"
}

kotlin {
  jvmToolchain {
    languageVersion = JavaLanguageVersion.of(17)
  }

  tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinJvmCompile>().configureEach {
    compilerOptions {
      jvmTarget = org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_11
    }
  }

  androidTarget()
  iosX64()
  iosArm64()
  iosSimulatorArm64()

  cocoapods {
    summary = "Some description for the Shared Module"
    homepage = "Link to the Shared Module homepage"
    version = "1.0"
    ios.deploymentTarget = "16.0"
    podfile = project.file("../iosApp/Podfile")
    framework {
      baseName = "common"
      isStatic = true
    }
  }

  sourceSets {
    all {
      languageSettings.run {
        optIn("kotlinx.coroutines.FlowPreview")
        optIn("kotlinx.coroutines.ExperimentalCoroutinesApi")
      }
    }
    commonMain.dependencies {
      //put your multiplatform dependencies here
    }
    commonTest.dependencies {
      implementation(libs.kotlin.test)
    }
  }

  tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinJvmCompile>().configureEach {
    compilerOptions {
      // 'expect'/'actual' classes (including interfaces, objects, annotations, enums,
      // and 'actual' typealiases) are in Beta.
      // You can use -Xexpect-actual-classes flag to suppress this warning.
      // Also see: https://youtrack.jetbrains.com/issue/KT-61573
      freeCompilerArgs =
        listOf(
          "-Xexpect-actual-classes",
        )
    }
  }
}

android {
  namespace = "com.vn.chungha.pet_kmm"
  compileSdk = 34
  defaultConfig {
    minSdk = 26
  }
  compileOptions {

    isCoreLibraryDesugaringEnabled = true

    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
  }

  buildFeatures {
    buildConfig = true
  }

  dependencies {
    coreLibraryDesugaring(libs.jdkDesugar)
  }
}
