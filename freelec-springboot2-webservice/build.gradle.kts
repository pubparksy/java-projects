plugins {
    id ("org.springframework.boot") version ("2.7.1")
    id ("io.spring.dependency-management") version ("1.0.11.RELEASE")
    id("java")
}

group = "com.jojoldu.book"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("junit:junit:4.13.1")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("com.h2database:h2")
    implementation("org.springframework.boot:spring-boot-starter-mustache")
    compileOnly("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}