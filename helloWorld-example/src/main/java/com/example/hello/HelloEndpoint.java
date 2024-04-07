package com.example.hello;

import io.spring.guides.gs_producing_web_service.GetHelloRequest;
import io.spring.guides.gs_producing_web_service.GetHelloResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class HelloEndpoint {
    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

    private HelloRepository helloRepository;

    @Autowired
    public HelloEndpoint(HelloRepository helloRepository) {
        this.helloRepository = helloRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getHelloRequest")
    @ResponsePayload
    public GetHelloResponse getHello(@RequestPayload GetHelloRequest request) {
        GetHelloResponse response = new GetHelloResponse();
        response.getHello();
        return response;
    }
}