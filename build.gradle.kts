plugins {
    id("java")
    id("application")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(files(
        "libs/colorpicker.jar",
        "libs/fontchooser.jar",
        "libs/jh.jar",
        "libs/MRJAdapter.jar",
    ))

    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

//java.sourceCompatibility = org.gradle.api.JavaVersion.VERSION_1_5
//java.targetCompatibility = org.gradle.api.JavaVersion.VERSION_1_5
