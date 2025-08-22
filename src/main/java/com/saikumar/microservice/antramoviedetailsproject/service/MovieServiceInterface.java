package com.saikumar.microservice.antramoviedetailsproject.service;


import com.saikumar.microservice.antramoviedetailsproject.dto.MovieResponse;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriComponentsBuilder;


public interface MovieServiceInterface {
    MovieResponse getMovies(String title, int page);
}
