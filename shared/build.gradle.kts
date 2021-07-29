import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("com.android.library")
    id("com.chromaticnoise.multiplatform-swiftpackage") version "2.0.3"
}

version = "1.0"

kotlin {
    val ktor = "1.6.1"

    android()

    val sdkName: String? = System.getenv("SDK_NAME")

    val isiOSDevice = sdkName.orEmpty().startsWith("iphoneos")
    if (isiOSDevice) {
        iosArm64("iOS")
    } else {
        iosX64("iOS")
    }
    macosX64("macOS")

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        ios.deploymentTarget = "14.1"
        frameworkName = "shared"
        podfile = project.file("../iosApp/Podfile")
    }
    
    sourceSets {
        val commonMain by getting
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        val androidMain by getting
        val androidTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
                implementation("junit:junit:4.13.2")
            }
        }
        val iOSMain by getting
        val macOSMain by getting
        val iOSTest by getting
    }
}

android {
    compileSdkVersion(31)
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdkVersion(16)
        targetSdkVersion(31)
    }
}

multiplatformSwiftPackage {
    outputDirectory(File("/Users/tsouza/AndroidStudioProjects/GitTest"))
    packageName("MyApp")
    swiftToolsVersion("5.3")
    targetPlatforms {
        iOS { v("13") }

         macOS { v("13") }
    }
}