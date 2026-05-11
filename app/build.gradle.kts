import java.util.Properties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt)
    alias(libs.plugins.kotlin.serialization)
}

val localProps = Properties().apply {
    load(rootProject.file("local.properties").inputStream())
}

android {
    namespace = "com.anucodes.medicinetrackingapp"
    compileSdk {
        version = release(36) {
            minorApiLevel = 1
        }
    }

    defaultConfig {
        applicationId = "com.anucodes.medicinetrackingapp"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        buildConfigField("String", "SUPABASE_URL",     "\"${localProps["SUPABASE_URL"]}\"")
        buildConfigField("String", "SUPABASE_ANON_KEY","\"${localProps["SUPABASE_ANON_KEY"]}\"")
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
}

dependencies {
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
    debugImplementation(libs.androidx.compose.ui.tooling)

    //Navigation dependency
    implementation(libs.androidx.navigation.compose)

    //Kotlin serializable
    implementation(libs.kotlinx.serialization.json)

    //Extended Material Icons
    implementation(libs.androidx.material.icons.extended)

    //Dagger Hilt dependency
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)

    //Ktor dependency
    implementation(libs.ktor.client.engine.z)

    //Navigation dependency
    implementation(libs.androidx.navigation3.runtime)
    implementation(libs.androidx.navigation3.ui)
    implementation(libs.androidx.navigation.compose)

    //Coil dependency
    implementation(libs.coil.compose)

    //Downloadable fonts
    implementation(libs.androidx.compose.ui.text.google.fonts)

    //Supabase dependency
    implementation(platform(libs.bom))
    implementation(libs.supabase.postgrest.kt)
    implementation(libs.supabase.auth.kt)


    //K-tor
    implementation(libs.ktor.client.engine.z)

}