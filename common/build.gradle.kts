import co.touchlab.skie.configuration.DefaultArgumentInterop
import co.touchlab.skie.configuration.EnumInterop
import co.touchlab.skie.configuration.FlowInterop
import co.touchlab.skie.configuration.SealedInterop
import co.touchlab.skie.configuration.SuspendInterop
import com.codingfeline.buildkonfig.compiler.FieldSpec.Type.BOOLEAN
import com.codingfeline.buildkonfig.compiler.FieldSpec.Type.STRING
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.KotlinVersion

plugins {
  alias(libs.plugins.kotlinMultiplatform)
  alias(libs.plugins.kotlinCocoapods)
  alias(libs.plugins.androidLibrary)
  alias(libs.plugins.ksp)
  alias(libs.plugins.skie)
  alias(libs.plugins.room)
  alias(libs.plugins.kotlin.kapt)
  alias(libs.plugins.kotlinx.serialization)
  alias(libs.plugins.buildKonfig)
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

  listOf(
    iosX64(),
    iosArm64(),
    iosSimulatorArm64(),
  ).forEach {
    it.binaries.framework {
      export(libs.androidx.lifecycle.viewmodel)
      baseName = "common"
      isStatic = true
    }
  }

  androidTarget()
  jvm()

  @OptIn(ExperimentalKotlinGradlePluginApi::class)
  compilerOptions {
    languageVersion.set(KotlinVersion.KOTLIN_2_0)
  }

  cocoapods {
    summary = "Some description for the Shared Module"
    homepage = "Link to the Shared Module homepage"
    version = "1.0"
    ios.deploymentTarget = "16.0"
    podfile = project.file("../iosApp/Podfile")

    framework {
      export(libs.androidx.lifecycle.viewmodel)
      export(libs.kotlinx.coroutines)
      export(libs.napier)
      baseName = "common"
      isStatic = true
    }
  }

  sourceSets {
    all {
      languageSettings.run {
        optIn("kotlinx.coroutines.FlowPreview")
        optIn("kotlinx.coroutines.ExperimentalCoroutinesApi")
        optIn("kotlinx.cinterop.ExperimentalForeignApi")
      }
    }
    
    commonMain.dependencies {
      implementation(libs.kotlinx.coroutines)
      implementation(libs.kotlinx.serialization)
      api(libs.kotlinx.datetime)

      api(libs.koin.core)
      implementation(libs.koin.compose)
      implementation(libs.koin.composeVM)
      implementation(libs.koin.test)

      implementation(libs.bundles.ktor.common)
      api(libs.androidx.lifecycle.viewmodel)
      implementation(libs.androidx.room.runtime)
      implementation(libs.sqlite.bundled)
      implementation(libs.datastore.preferences)
      api(libs.kermit)

      implementation(libs.koalaplot.core)
      implementation(libs.image.loader)

      implementation(libs.napier)

      api(libs.immutable.collection)
    }

    sourceSets.commonMain {
      kotlin.srcDir("build/generated/ksp/metadata")
    }

    commonTest.dependencies {
      implementation(libs.kotlin.test)
    }

    androidMain.dependencies {
      implementation(libs.ktor.client.android)
      implementation(libs.koin.core)
      implementation(libs.koin.test)
    }

    iosMain.dependencies {
      implementation(libs.ktor.client.ios)
      implementation(libs.koin.core)
      implementation(libs.koin.test)
    }

    jvmMain.dependencies {
      implementation(libs.ktor.client.java)
      implementation(libs.slf4j)

      implementation("org.nield:kotlin-statistics:1.2.1")
      implementation("org.ojalgo:okalgo:0.0.2")
      implementation("org.jetbrains.kotlinx:multik-api:0.1.1")
      implementation("org.jetbrains.kotlinx:multik-jvm:0.1.1")
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
    if (name != "kspCommonMainKotlinMetadata") {
      dependsOn("kspCommonMainKotlinMetadata")
    }
  }
}

skie {
  features {
    enableSwiftUIObservingPreview = true
  }
}

dependencies {
  add("kspCommonMainMetadata", libs.androidx.room.compiler)
}

room {
  schemaDirectory("$projectDir/schemas")
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

buildkonfig {
  packageName = "com.vn.chungha.pet_kmm.buildkonfig"

  defaultConfigs {
    buildConfigField(STRING, "VERSION_NAME", version.toString())
    buildConfigField(STRING, "API_DOMAIN", "https://api.thecatapi.com/v1")
    buildConfigField(STRING, "API_KEY_DEMO", "bed9cfb9-fad4-41ae-bc4d-09cf7cb552bf")
    buildConfigField(BOOLEAN, "DEBUG", "false")
  }

  defaultConfigs("debug") {
    buildConfigField(BOOLEAN, "DEBUG", "true")
  }

  targetConfigs {
    android {
    }
  }
}
