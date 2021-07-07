import com.logoped583st.build_src.setupAndroid

plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-android-extensions")
}
group = "com.logoped583st"
version = "1.0-SNAPSHOT"

dependencies {
    implementation(project(":PizzaBotCore"))
    implementation("io.insert-koin:koin-core-jvm:3.1.2")

    implementation("com.google.android.material:material:1.2.0")
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("androidx.constraintlayout:constraintlayout:1.1.3")
}
android {
    setupAndroid()
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}