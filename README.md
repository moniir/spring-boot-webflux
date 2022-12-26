# spring-boot-webflux

**import & run application**

1. Added Mono and Flux test class in test package

2. Added traditional approach to get response by below url:

http://localhost:8080/customers/
Note: After hit above url, the response will show 50 seconds since it will give synchronous response

3. http://localhost:8080/customers/stream
Note: Above url will generate immediate response since it use asynchronous approach.
