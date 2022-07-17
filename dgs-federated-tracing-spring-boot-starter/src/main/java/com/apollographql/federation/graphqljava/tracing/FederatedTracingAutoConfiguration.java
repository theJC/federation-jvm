package com.apollographql.federation.graphqljava.tracing;

import graphql.execution.instrumentation.Instrumentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(FederatedTracingProperties.class)
public class FederatedTracingAutoConfiguration {

  @Autowired private FederatedTracingProperties federatedTracingProperties;

  @Bean
  @ConditionalOnMissingBean
  // GraphQLContextContributor introduced in Netflix DGS 5.0.6 and higher, if not available, don't
  // create this bean.
  @ConditionalOnClass(name = "com.netflix.graphql.dgs.context.GraphQLContextContributor")
  public FederatedTracingGraphQLContextContributor federatedTracingGraphQLContextContributor() {
    return new FederatedTracingGraphQLContextContributor();
  }

  @Bean
  public Instrumentation federatedInstrumentation() {
    return new FederatedTracingInstrumentation(
        new FederatedTracingInstrumentation.Options(federatedTracingProperties.isDebug()));
  }
}
