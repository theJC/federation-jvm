description = "Netflix DGS support for providing signal from headers to FederatedTracingInstrumentation "

plugins {
    id("com.apollographql.federation.java-conventions")
}

val annotationsVersion: String by project
val graphQLJavaVersion: String by project
val junitVersion: String by project
val slf4jVersion: String by project
val springVersion: String by project
val springBootVersion: String by project
val dgsVersion: String by project

dependencies {
    compileOnly("org.jetbrains:annotations:$annotationsVersion")
    compileOnly(platform("org.springframework:spring-framework-bom:$springVersion"))
    implementation("org.springframework:spring-context")
    api("org.springframework:spring-web")
    implementation("org.springframework.boot:spring-boot-autoconfigure:$springBootVersion")
    implementation("com.netflix.graphql.dgs:graphql-dgs:$dgsVersion")
    api(project(":federation-graphql-java-support"))
    api("com.graphql-java:graphql-java:$graphQLJavaVersion")
    api("org.slf4j:slf4j-api:$slf4jVersion")
    testCompileOnly("org.jetbrains:annotations:$annotationsVersion")
}
