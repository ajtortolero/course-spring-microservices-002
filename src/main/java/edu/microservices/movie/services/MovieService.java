package edu.microservices.movie.services;

import edu.microservices.movie.models.Movie;
import edu.microservices.movie.repositories.MovieRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;
    private final Logger LOGGER = LoggerFactory.getLogger(MovieService.class);
    public Flux<Movie> findAll(){
        return movieRepository.findAll()
            .onErrorResume(throwable -> {
                LOGGER.error("Error querying all movies", throwable);
                return Mono.empty();
            })
            .switchIfEmpty(Mono.error(
                    new ResponseStatusException(HttpStatus.NOT_FOUND, "No movies found").getMostSpecificCause()));
    }
    public Mono<Movie> findById(String id){
        return movieRepository.findById(id)
                .onErrorResume(throwable -> {
                    LOGGER.error("Error querying a movies with id= " + id, throwable);
                    return Mono.empty();
                })
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Movies with id= " + id + " not found").getMostSpecificCause()));
    }
}
