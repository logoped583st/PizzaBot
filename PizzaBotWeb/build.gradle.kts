import com.logoped583st.build_src.setupJs

plugins {
    kotlin("js")
}

group = "com.logoped583st"
version = "1.0"

dependencies {
    testImplementation(kotlin("test-js"))
    implementation(project(":PizzaBotCore"))
    implementation("org.koin:koin-core:3.0.0-alpha-1")
    implementation("org.jetbrains:kotlin-react:16.13.1-pre.113-kotlin-1.4.0")
    implementation("org.jetbrains:kotlin-react-dom:16.13.1-pre.113-kotlin-1.4.0")
    implementation("org.jetbrains:kotlin-styled:1.0.0-pre.113-kotlin-1.4.0")
    implementation("org.jetbrains:kotlin-react-router-dom:5.1.2-pre.113-kotlin-1.4.0")
}

kotlin {
    setupJs()
}