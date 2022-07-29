package com.pxample.pemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration // tell springboot that this is configuration class
@EnableWebSocketMessageBroker // tell springboot that this is a websocket message broker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer{

    @Override
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
        stompEndpointRegistry.addEndpoint("/ppdouble-websocket").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // registry a broker which is also a topic
        registry.enableSimpleBroker("/ppdouble-broker");
        // the client send to destination like /app/user will respond by MessageMapping("/user")
        registry.setApplicationDestinationPrefixes("/app");
    }
}
