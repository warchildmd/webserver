# ${1:Multi-threaded web server}
A multi-threaded (e.g. file-based) web server with thread-pooling
implemented in Java.

Any class that implements `WebApp` interface can be plugged as the handler application. In this example
I'm using `FileServingApp` (serves static files from a document root) as my handler application. The single method
that must be implemented is `HttpResponse handle(HttpRequest request)`.

### Request flow
1. Server receives a request.
2. Server creates a Handler (Runnable) for this request.
2. Handler parses the request into a HttpRequest.
3. Handler passes the HttpRequest to the handler application.
4. Handler writes the response received from the handler application to the output stream.
5. Handler closes the streams.

A compiled version `webserver-1.0-SNAPSHOT.jar` can be found in the root directory.
 
`WebServer` - listens for connections and delegates them to worker threads.
`Handler` - handles a single request, by parsing it and sending it to the handler application.
`ExecutorMonitor` - prints server status once every 10 seconds.
`FileServingApp` - an application that serves static files from it's document root.

## Installation
`gradle build`
## Usage
`java -jar webserver-<version> <port> <threads> <document root>`