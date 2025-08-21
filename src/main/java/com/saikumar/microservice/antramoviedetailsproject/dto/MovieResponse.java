package com.saikumar.microservice.antramoviedetailsproject.dto;

import java.util.List;

public class MovieResponse {
    public int page;
    public int per_page;
    public int total;
    public int total_pages;
    public List<Movie> data;
}

class Movie {
    public String Title;
    public int Year;
    public String imdbID;

}
