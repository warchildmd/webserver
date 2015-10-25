package me.homework.server.apps;


import me.homework.server.http.HttpRequest;
import me.homework.server.http.FileHttpResponse;
import me.homework.server.http.HttpResponse;

/**
 * Applications that want to be compatible with the server must implement this interface.
 */
public interface WebApp {

    /**
     *
     * @param request {@link HttpRequest} sent by the client
     * @return a {@link HttpResponse}
     */
    HttpResponse handle(HttpRequest request);
}
