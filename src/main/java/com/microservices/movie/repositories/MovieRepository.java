package com.microservices.movie.msmovie.repositories;

import com.microservices.movie.msmovie.models.Movie;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface MovieRepository  extends R2dbcRepository<Movie, String> {
}
