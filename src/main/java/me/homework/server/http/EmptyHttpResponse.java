package me.homework.server.http;

import me.homework.server.helpers.Logger;

import java.io.*;

/**
 * HttpResponse extension that writes an empty response.
 */
public class EmptyHttpResponse extends HttpResponse {

    private final static String TAG = "me.homework.server.http.EmptyHttpResponse";

    public EmptyHttpResponse(int statusCode) {
        super();

        this.statusCode = statusCode;
    }

    /**
     * This function writes the HTTP response to an output stream.
     *
     * @param out the target {@link OutputStream} for writing
     */
    public void write(OutputStream out) {
        try {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
            writer.write(getResponseLine());
            writer.write("\r\n");

            for (String key: headers.keySet()) {
                writer.write(key + ":" + headers.get(key));
                writer.write("\r\n");
            }
            writer.write("\r\n");

            writer.flush();
        } catch (IOException e) {
            Logger.error(TAG, e.getMessage());
        }
    }
}

