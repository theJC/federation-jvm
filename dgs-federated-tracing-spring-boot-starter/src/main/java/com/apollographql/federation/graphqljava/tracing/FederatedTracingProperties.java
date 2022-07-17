package com.apollographql.federation.graphqljava.tracing;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "graphql.federation.tracing")
public class FederatedTracingProperties {
  private boolean debug;

  public boolean isDebug() {
    return debug;
  }

  public void setDebug(boolean debug) {
    this.debug = debug;
  }
}
