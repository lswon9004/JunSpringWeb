package com.spring.movie.command;

import java.util.ArrayList;

import lombok.Data;
@Data
public class MovieListResult {
	String boxofficeType;
    String showRange;

    ArrayList<Movie> dailyBoxOfficeList = new ArrayList<Movie>();

}