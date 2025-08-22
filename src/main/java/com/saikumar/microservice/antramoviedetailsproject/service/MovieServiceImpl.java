package com.saikumar.microservice.antramoviedetailsproject.service;

import com.saikumar.microservice.antramoviedetailsproject.dto.MovieResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class MovieServiceImpl implements MovieServiceInterface {

    private final RestClient restClient;

    public MovieServiceImpl(RestClient restClient) {
        this.restClient = restClient;
    }


    public MovieResponse getMovies(String title, int page) {
        String url= UriComponentsBuilder.fromUriString("https://jsonmock.hackerrank.com/api/movies")
                .queryParam("Title", title)
                .queryParam("page", page)
                .build().toUriString();

        return restClient.get()
                .uri(url)
                .retrieve()
                .body(MovieResponse.class);
    }
}
