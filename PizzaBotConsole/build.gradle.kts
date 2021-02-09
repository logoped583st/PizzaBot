plugins {
    kotlin("jvm")
}

group = "com.logoped583st"
version = "1.0-SNAPSHOT"

dependencies {
    implementation(kotlin("stdlib"))
    implementation(project(":PizzaBotCore","jvmDefault"))
    implementation("org.koin:koin-core:3.0.0-alpha-4")
}

tasks.withType<Jar> {
    manifest {
        attributes("Main-Class" to "com.logoped583st.pizza_console.MainKt")
    }
    from(configurations.compileClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
}
