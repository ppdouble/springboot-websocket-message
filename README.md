## server configuration
**server config**
```java
    @Override
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
        stompEndpointRegistry.addEndpoint("/ppdouble-websocket").withSockJS();
    }
```

**client connection**

`var socket = new SockJS('http://127.0.0.1:8080/ppdouble-websocket');`

or 

`var socket = new SockJS('/ppdouble-websocket');`

## subscribe

**server config**

defining broker 

`registry.enableSimpleBroker("/ppdouble-broker");`

**controller: respond the subscription of client**

`@SendTo("/ppdouble-broker/user")`

**client subscribe**

`stompClient.subscribe('/ppdouble-broker/user"', function (greetingmessage){}`

## send

**server config**

`registry.setApplicationDestinationPrefixes("/app");`

**controller: receive the request from client*

`@MessageMapping("/user")`

**client send message**

`stompClient.send("/app/user", {}, JSON.stringify({'name': $("#name").val()}));`