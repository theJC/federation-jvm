rootProject.name = "federation-parent"

include(":federation-graphql-java-support")
include(":federation-graphql-java-support-api")
include(":dgs-federated-tracing-spring-boot-starter")
project(":federation-graphql-java-support").projectDir = file("graphql-java-support")
project(":federation-graphql-java-support-api").projectDir = file("graphql-java-support-api")
project(":dgs-federated-tracing-spring-boot-starter").projectDir = file("dgs-federated-tracing-spring-boot-starter")
