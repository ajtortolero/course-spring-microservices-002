package edu.microservices.movie.controllers;

import edu.microservices.movie.models.Client;
import edu.microservices.movie.models.Movie;
import edu.microservices.movie.services.MovieService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@AllArgsConstructor
@RestController
@RequestMapping("/v1/movies")
@Tag(name = "Movies", description = "Operations on movies of API")
public class MovieController {
    private final MovieService movieService;
    @GetMapping("")
    @Operation(
            summary = "Get all movies",
            description = "Allows you to obtain the list of all movies"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Movies created in the system",
                    content = @Content(schema = @Schema(implementation = Movie.class)))
    })
    public Flux<Movie> getAllMovies(){
        return movieService.findAll();
    }
}
