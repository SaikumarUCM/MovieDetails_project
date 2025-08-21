package com.saikumar.microservice.antramoviedetailsproject.service;


import com.saikumar.microservice.antramoviedetailsproject.dto.MovieResponse;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class MovieService {


    private static final String BASE_URL = "https://jsonmock.hackerrank.com/api/moviesdata/search/";

    private final RestClient restClient;
    public MovieService() {
        this.restClient = RestClient.create();
    }

    public MovieResponse search(String title, int page) {
        String url = UriComponentsBuilder.fromHttpUrl(BASE_URL)
                .queryParam("Title", title)
                .queryParam("page", page)
                .build()
                .toUriString();

        return restClient.get()
                .uri(url)
                .retrieve()
                .onStatus(HttpStatusCode::isError, (req, res) -> {
                    throw new RuntimeException("Upstream error: " + res.getStatusCode());
                })
                .body(MovieResponse.class);
    }
}
