package com.github.books.javacore2.chapter4.client;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublisher;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

class MoreBodyPublishers {
    public static BodyPublisher ofFormData(Map<Object, Object> data) {
        var first = true;
        var builder = new StringBuilder();
        for (Map.Entry<Object, Object> entry : data.entrySet()) {
            if (first) first = false;
            else builder.append("&");
            builder.append(URLEncoder.encode(entry.getKey().toString(),
                    StandardCharsets.UTF_8));
            builder.append("=");
            builder.append(URLEncoder.encode(entry.getValue().toString(),
                    StandardCharsets.UTF_8));
        }
        return BodyPublishers.ofString(builder.toString());
    }

    private static byte[] bytes(String s) {
        return s.getBytes(StandardCharsets.UTF_8);
    }

    public static BodyPublisher ofMimeMultipartData(Map<Object, Object> data, String boundary)
            throws IOException {
        var byteArrays = new ArrayList<byte[]>();
        byte[] separator = bytes("--" + boundary + "\nContent-Disposition: form-data; name=");
        for (Map.Entry<Object, Object> entry : data.entrySet()) {
            byteArrays.add(separator);

            if (entry.getValue() instanceof Path) {
                var path = (Path) entry.getValue();
                String mimeType = Files.probeContentType(path);
                byteArrays.add(bytes("\"" + entry.getKey() + "\"; filename=\"" + path.getFileName()
                        + "\"\nContent-Type: " + mimeType + "\n\n"));
                byteArrays.add(Files.readAllBytes(path));
            } else
                byteArrays.add(bytes("\"" + entry.getKey() + "\"\n\n" + entry.getValue() + "\n"));
        }
        byteArrays.add(bytes("--" + boundary + "--"));
        return BodyPublishers.ofByteArrays(byteArrays);
    }

    public static BodyPublisher ofSimpleJSON(Map<Object, Object> data) {
        var builder = new StringBuilder();
        builder.append("{");
        var first = true;
        for (Map.Entry<Object, Object> entry : data.entrySet()) {
            if (first) first = false;
            else
                builder.append(",");
            builder.append(jsonEscape(entry.getKey().toString())).append(": ")
                    .append(jsonEscape(entry.getValue().toString()));
        }
        builder.append("}");
        return BodyPublishers.ofString(builder.toString());
    }

    private static Map<Character, String> replacements = Map.of('\b', "\\b", '\f', "\\f",
            '\n', "\\n", '\r', "\\r", '\t', "\\t", '"', "\\\"", '\\', "\\\\");

    private static StringBuilder jsonEscape(String str) {
        var result = new StringBuilder("\"");
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String replacement = replacements.get(ch);
            if (replacement == null) result.append(ch);
            else result.append(replacement);
        }
        result.append("\"");
        return result;
    }
}

public class HttpClientTest {
    public static void main(String[] args)
            throws IOException, URISyntaxException, InterruptedException {
        System.setProperty("jdk.httpclient.HttpClient.log", "headers,errors");
        String propsFilename = args.length > 0 ? args[0] : "D:\\DevelopSpace\\IDEA\\JavaStudyDemo\\src\\main\\java\\com\\github\\books\\javacore2\\chapter4\\client\\fileupload.properties";
        Path propsPath = Paths.get(propsFilename);
        var props = new Properties();
        try (InputStream in = Files.newInputStream(propsPath)) {
            props.load(in);
        }
        String urlString = "" + props.remove("url");
        String contentType = "" + props.remove("Content-Type");
        if (contentType.equals("multipart/form-data")) {
            var generator = new Random();
            String boundary = new BigInteger(256, generator).toString();
            contentType += ";boundary=" + boundary;
            props.replaceAll((k, v) ->
                    v.toString().startsWith("file://")
                            ? propsPath.getParent().resolve(Paths.get(v.toString().substring(7)))
                            : v);
        }
        String result = doPost(urlString, contentType, props);
        System.out.println(result);
    }

    public static String doPost(String url, String contentType, Map<Object, Object> data)
            throws IOException, URISyntaxException, InterruptedException {
        HttpClient client = HttpClient.newBuilder()
                .followRedirects(HttpClient.Redirect.ALWAYS).build();

        BodyPublisher publisher = null;
        if (contentType.startsWith("multipart/form-data")) {
            String boundary = contentType.substring(contentType.lastIndexOf("=") + 1);
            publisher = MoreBodyPublishers.ofMimeMultipartData(data, boundary);
        } else if (contentType.equals("application/x-www-form-urlencoded"))
            publisher = MoreBodyPublishers.ofFormData(data);
        else {
            contentType = "application/json";
            publisher = MoreBodyPublishers.ofSimpleJSON(data);
        }

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(url))
                .header("Content-Type", contentType)
                .POST(publisher)
                .build();
        HttpResponse<String> response
                = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
}
