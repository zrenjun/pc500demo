import org.gradle.internal.impldep.bsh.commands.dir

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.lepu.pc500demo"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.lepu.pc500demo"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        vectorDrawables {
            useSupportLibrary = true
        }
        ndk {
            abiFilters.add("armeabi-v7a")
        }
    }

    signingConfigs {
        getByName("debug") {
            storeFile = file("vthkey.jks")
            storePassword = "aaaa2222"
            keyAlias = "key0"
            keyPassword = "aaaa2222"
        }
    }


    buildTypes {
        release {
            signingConfig = signingConfigs.getByName("debug")
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
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    implementation("androidx.activity:activity-compose:1.7.0")
    implementation("androidx.appcompat:appcompat:1.6.1")

    implementation ("com.github.zrenjun:pcecg500:1.0.1")
}