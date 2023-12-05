plugins {
    id("com.android.library")
    alias(libs.plugins.kotlin)
    alias(libs.plugins.hilt)
    id("kotlin-parcelize")
    kotlin("kapt")

}

android {
    namespace = "com.example.socialapp.data"
    compileSdk = 34

    defaultConfig {
        minSdk = 24
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}
dependencies {
    //hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)

    implementation(project(":domain"))
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)

    implementation(libs.retrofit)
    implementation(libs.logging.interceptor)
    implementation(libs.converter.gson)
    implementation ("com.google.code.gson:gson:2.9.0")
}