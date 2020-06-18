plugins {
    java
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
//    testCompile group: 'org.junit.jupiter', name: 'junit-jupiter-engine', version: '5.6.2'
    testImplementation(group = "org.junit.jupiter", name = "junit-jupiter-engine", version = "5.6.2")
    testImplementation("org.mockito:mockito-core:3.3.3")
    testImplementation("org.mockito:mockito-junit-jupiter:3.3.3")

}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_11
}

tasks.withType<Jar> {
    manifest {
        attributes["Main-Class"] = "by.gsu.winter20.GenericMenuMain"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}