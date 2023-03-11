package cn.bugstack.chatbot.api.domain.ai.service;

import com.alibaba.fastjson.JSONObject;
import okhttp3.*;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class ChatGPT {
    private static final String API_ENDPOINT = "https://api.openai.com/v1/engines/davinci-codex/completions";
    private static final String API_KEY = "";

    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient();
        String prompt = "I like to eat pizza because";

        MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
        String requestBody = "{\"prompt\":\"" + prompt + "\",\"max_tokens\":50,\"temperature\":0.5}";

        Request request = new Request.Builder()
                .url(API_ENDPOINT)
                .header("Authorization", "Bearer " + API_KEY)
                .header("Content-Type", "application/json")
                .post(RequestBody.create(mediaType, requestBody))
                .build();

        Call call = client.newCall(request);
        call.timeout().timeout(180, TimeUnit.SECONDS);
        Response response = call.execute();

        String responseBody = response.body().string();
        System.out.println(responseBody);


    }

}

