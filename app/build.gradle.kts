import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties
import org.jetbrains.kotlin.konan.file.File
import org.jetbrains.kotlin.konan.properties.Properties
import org.jetbrains.kotlin.konan.properties.saveToFile
import java.io.FileOutputStream
import java.io.OutputStreamWriter

/*
 * Project Honkai Stargazer and app Stargazer (星穹觀星者) were
 * Organized & Develop by Coding Band.
 * Copyright © 2024 Coding Band 版權所有
 */

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlinx-serialization")
}

//input this versionCode
val propsFile = file("version.properties")
var props = Properties()
props.load(propsFile.inputStream())

//declare
var versionCodeLocal = props.getProperty("versionCode").toInt()
var versionNameLocal = "2.4.0"
var versionInnerCodeLocal = "Clara"

//output the next versionCode
props.setProperty("versionCode",(versionCodeLocal + 1).toString())
props.store(propsFile.outputStream(), null)

android {
    namespace = "com.voc.honkai_stargazer"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.voc.honkai_stargazer"
        minSdk = 28
        targetSdk = 34
        versionCode = versionCodeLocal
        versionName = versionNameLocal

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    flavorDimensions("version")
    productFlavors {
        // For Google Play Store
        create("dev") {
            versionCode = versionCodeLocal
            versionNameSuffix = "-dev" + " (" + versionCodeLocal + ")"
            applicationId = "com.voc.honkai_stargazer_gp"
        }
        // For Google Play Store
        create("gp") {
            versionCode = versionCodeLocal
            versionNameSuffix = "-prod" + " (" + versionCodeLocal + ")"
            applicationId = "com.voc.honkai_stargazer_gp"
            bundle {
                language {
                    enableSplit = false
                }
            }
        }
        // For Develop Testing
        create("XBeta") {
            versionCode = versionCodeLocal
            versionNameSuffix = "-beta" + " (" + versionCodeLocal + ")"
            applicationId = "com.voc.honkai_stargazer_beta"


        }
        // For iOS
        create("ios") {
            versionCode = versionCodeLocal
            versionNameSuffix = "-prod" + " (" + versionCodeLocal + ")"
            applicationId = "com.voc.honkaistargazer"


        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.11"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }


    /*

    sourceSets.getByName("main") {
        res.srcDirs(
            "/src/main/res/drawable",
            "/src/main/res/drawable/phosphor",
        )
    }
     */
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.activity:activity-compose:1.8.2")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    //implementation("com.github.Dimezis:BlurView:version-2.0.3") //BlurView https://github.com/Dimezis/BlurView/issues/212
    implementation("androidx.navigation:navigation-compose:2.7.7") //Navigation Compose
    implementation("com.google.accompanist:accompanist-systemuicontroller:0.27.0") //System UI Controller
    implementation("dev.chrisbanes.haze:haze:0.6.2") //Haze's BlurView https://github.com/chrisbanes/haze
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.3") //Kotlin Serialization
}