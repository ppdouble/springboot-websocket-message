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

registry a broker 

`registry.enableSimpleBroker("/ppdouble-topic");`

**controller: respond the subscription of client**

`@SendTo("/ppdouble-topic/user")`

**client subscribe**

`stompClient.subscribe('/ppdouble-topic/user"', function (greetingmessage){}`

## send

**server config**

`registry.setApplicationDestinationPrefixes("/app");`

**controller: receive the request from client**

`@MessageMapping("/user")`

**client send message**

`stompClient.send("/app/user", {}, JSON.stringify({'name': $("#name").val()}));`

## packaging
default `jar`

**packaging**
```xml
<packaging>jar</packaging>
```

**run and change server port by adding flag**

`java -jar target/springboot-websocket-message-0.0.1-SNAPSHOT.jar --server.port=8090 --trace`

## Ref

[Using Spring Boot for WebSocket Implementation with STOMP](https://www.toptal.com/java/stomp-spring-boot-websocket)

[Spring Boot + Websocket Example](https://www.devglan.com/spring-boot/spring-boot-websocket-example)

[Using WebSocket to build an interactive web application](https://spring.io/guides/gs/messaging-stomp-websocket/)
