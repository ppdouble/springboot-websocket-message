## server configuration
**server config**
```java
    @Override
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
        stompEndpointRegistry.addEndpoint("/ppdouble-websocket").withSockJS();
    }
```

**client**

`var socket = new SockJS('http://127.0.0.1:8080/ppdouble-websocket');`

or 

`var socket = new SockJS('/ppdouble-websocket');`

## subscribe

**server config**

defining broker 

`registry.enableSimpleBroker("/ppdouble-broker");`

**controller**

`@SendTo("/ppdouble-broker/user")`

**client**

`stompClient.subscribe('/ppdouble-broker/user"', function (greetingmessage){}`

## send

**server config**

`registry.setApplicationDestinationPrefixes("/app");`

**controller**

`@MessageMapping("/user")`

**client**

`stompClient.send("/app/user", {}, JSON.stringify({'name': $("#name").val()}));`