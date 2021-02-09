import Build_gradle.GradleBuild.build_gradle
import Build_gradle.GradleBuild.kotlin_gradle_plugin

plugins {
    `kotlin-dsl`
}

repositories {
    jcenter()
    google()
}

object GradleBuild {
    private const val kotlin_version = "1.4.0"
    private const val build_gradle_version = "4.0.1"

    const val kotlin_gradle_plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version"
    const val build_gradle = "com.android.tools.build:gradle:$build_gradle_version"
}

dependencies {
    implementation(kotlin_gradle_plugin)
    implementation(build_gradle)
}


