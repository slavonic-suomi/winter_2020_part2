plugins {
    java
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    annotationProcessor("org.projectlombok:lombok:1.18.12")
    implementation("org.projectlombok:lombok:1.18.12")
    implementation("com.fasterxml.jackson.core:jackson-core:2.11.0")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.11.0")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.11.0")

//    compile group: 'mysql', name: 'mysql-connector-java', version: '8.0.20'
    runtimeOnly("mysql:mysql-connector-java:8.0.20")

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