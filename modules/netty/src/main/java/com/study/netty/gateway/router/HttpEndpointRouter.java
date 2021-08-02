package com.study.netty.gateway.router;

import com.study.netty.gateway.domain.ServerConfig;
import java.util.List;

public interface HttpEndpointRouter {
  ServerConfig route(List<ServerConfig> endpoints);
}
