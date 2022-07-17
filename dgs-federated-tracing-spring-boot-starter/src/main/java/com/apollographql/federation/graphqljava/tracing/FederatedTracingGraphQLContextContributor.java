package com.apollographql.federation.graphqljava.tracing;

import static com.apollographql.federation.graphqljava.tracing.FederatedTracingInstrumentation.FEDERATED_TRACING_HEADER_NAME;

import com.netflix.graphql.dgs.context.GraphQLContextContributor;
import com.netflix.graphql.dgs.internal.DgsRequestData;
import graphql.GraphQLContext;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * GraphQLContextContributor that allows the header to set the appropriate context value to inform
 * FederatedTracingInstrumentation whether it's appropriate to instrument or not.
 */
public class FederatedTracingGraphQLContextContributor implements GraphQLContextContributor {

  @Override
  public void contribute(
      @NotNull GraphQLContext.Builder builder,
      @Nullable Map<String, ?> extensions,
      @Nullable DgsRequestData dgsRequestData) {
    if (dgsRequestData != null && dgsRequestData.getHeaders() != null) {
      String federatedTracingHeaderValue =
          dgsRequestData.getHeaders().getFirst(FEDERATED_TRACING_HEADER_NAME);
      // If the FederatedTracing instance was created without providing a value for
      // Option.shouldTracePredicate, it will look for the value stored keyed by
      // FEDERATED_TRACING_HEADER_NAME in the GraphQLContext, which this provides from http headers
      if (federatedTracingHeaderValue != null) {
        builder.put(FEDERATED_TRACING_HEADER_NAME, federatedTracingHeaderValue);
      }
    }
  }
}
