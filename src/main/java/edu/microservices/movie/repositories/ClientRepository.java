package edu.microservices.movie.repositories;

import edu.microservices.movie.models.Client;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface ClientRepository extends R2dbcRepository<Client, String> {

}
