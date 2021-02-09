package com.logoped583st.build_src

import com.android.build.gradle.BaseExtension
import org.jetbrains.kotlin.gradle.dsl.KotlinJsProjectExtension
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.targets.js.dsl.KotlinJsTargetDsl

private const val compile_sdk_version = 30
private const val build_tools_version = "30.0.3"

private const val min_sdk = 21
private const val target_sdk = compile_sdk_version

private const val version_code = 1
private const val version_name = "1.0.0"

fun BaseExtension.setupAndroid() {
    compileSdkVersion(compile_sdk_version)
    buildToolsVersion(build_tools_version)

    defaultConfig {
        versionCode = version_code
        versionName = version_name
        minSdkVersion(min_sdk)
        targetSdkVersion(target_sdk)
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}

fun KotlinMultiplatformExtension.setupJs() {
    js(LEGACY) {
        jsConfig()
    }
}

fun KotlinJsProjectExtension.setupJs() {
    js(LEGACY) {
        jsConfig()
    }
}

private fun KotlinJsTargetDsl.jsConfig() {
    browser {
        binaries.executable()
        webpackTask {
            cssSupport.enabled = true
        }
        runTask {
            cssSupport.enabled = true
        }
        testTask {
            useKarma {
                useChromeHeadless()
                webpackConfig.cssSupport.enabled = true
            }
        }
    }
}

