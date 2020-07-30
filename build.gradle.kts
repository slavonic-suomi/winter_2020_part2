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


    implementation("javax.annotation:javax.annotation-api:1.3.2")
    implementation("org.liquibase:liquibase-core:3.10.2")
    implementation("org.yaml:snakeyaml:1.26")

    implementation("org.springframework:spring-core:5.2.8.RELEASE")
    implementation("org.springframework:spring-beans:5.2.8.RELEASE")
    implementation("org.springframework:spring-context:5.2.8.RELEASE")
    implementation("org.springframework:spring-jdbc:5.2.8.RELEASE")

    runtimeOnly("mysql:mysql-connector-java:8.0.20")

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