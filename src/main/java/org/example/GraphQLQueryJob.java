package org.example;
import okhttp3.*;
import org.example.grapql.response.GraphQLResponse;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import com.google.gson.Gson;

public class GraphQLQueryJob implements Job {

    private static final String GRAPHQL_API_URL = "http://localhost:8080/graphql";

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        OkHttpClient client = new OkHttpClient();

        String query = "{\"query\": \"query { events { edges { node { id  title description date } } } }\"}";

        Request request = new Request.Builder()
                .url(GRAPHQL_API_URL)
                .post(RequestBody.create(query, MediaType.parse("application/json")))
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }

            String jsonData = response.body().string();
            saveResponseToFile(jsonData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveResponseToFile(String jsonData) {
        System.out.println("Response JSON: " + jsonData);
        Gson gson = new Gson();
        GraphQLResponse graphQLResponse = gson.fromJson(jsonData, GraphQLResponse.class);

        try (FileWriter file = new FileWriter("events.json")) {
            gson.toJson(graphQLResponse, file);
            System.out.println("GraphQL data saved to events.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
