package edu.microservices.movie.repositories;

import edu.microservices.movie.models.Movie;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface MovieRepository  extends R2dbcRepository<Movie, String> {
}