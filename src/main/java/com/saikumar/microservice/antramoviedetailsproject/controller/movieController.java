package com.saikumar.microservice.antramoviedetailsproject.controller;


import com.saikumar.microservice.antramoviedetailsproject.dto.MovieResponse;
import com.saikumar.microservice.antramoviedetailsproject.service.MovieServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class movieController {


    @Autowired
    private MovieServiceInterface movieServiceInterface;


    @GetMapping()
    public ResponseEntity<MovieResponse> getMoviesDetails(@RequestParam(name = "title") String title,
                                                          @RequestParam(name = "page", required = false, defaultValue = "1") int page) {

        MovieResponse movieResponse = movieServiceInterface.getMovies(title, page);

        return ResponseEntity.ok(movieResponse);

    }

}

