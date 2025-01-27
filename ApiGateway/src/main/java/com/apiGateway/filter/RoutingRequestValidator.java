package com.apiGateway.filter;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;


import java.util.function.Predicate;



import java.util.List;


@Component
public class RoutingRequestValidator {

    public static final List<String> bypassEndpoints = List.of(
            "/users/signup",
            "/users/generateToken",
            "/users/validateToken",
            "/users/swagger-ui/**",
            "/users/v3/api-docs/**"
    );

    public Predicate<ServerHttpRequest> isAuthenticated =
            serverHttpRequest -> bypassEndpoints.stream().noneMatch(endpoint -> serverHttpRequest.getURI().getPath().contains(endpoint));
}