import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    id("java")
    id("application")
    id("com.github.johnrengelman.shadow") version "8.1.1"
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

application{
    mainClass.set("com.cburch.logisim.Main")
}
//java.sourceCompatibility = org.gradle.api.JavaVersion.VERSION_1_5
//java.targetCompatibility = org.gradle.api.JavaVersion.VERSION_1_5
