package com.microservices.movie.msmovie.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/v1/movies")
@Tag(name = "Movies", description = "Operations on movies of API")
public class MovieController {
}
