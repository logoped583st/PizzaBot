group = "com.logoped583st"
version = "1.0-SNAPSHOT"

buildscript {
    repositories {
        jcenter()
        google()
    }
    dependencies{
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.0")
        classpath("com.android.tools.build:gradle:4.0.2")
    }
}

allprojects {
    repositories {
        jcenter()
        google()
        mavenCentral()
        gradlePluginPortal()
        maven(url = "https://dl.bintray.com/ekito/koin")
    }
}
