package edu.microservices.movie.services;

import edu.microservices.movie.models.Client;
import edu.microservices.movie.repositories.ClientRepository;
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
public class ClientService {
    private final ClientRepository clientRepository;
    private final Logger LOGGER = LoggerFactory.getLogger(ClientService.class);
    public Flux<Client> findAll(){
        return clientRepository.findAll()
                .onErrorResume(throwable -> {
                    LOGGER.error("Error querying all client", throwable);
                    return Mono.empty();
                })
                .switchIfEmpty(Mono.error(
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "No client found").getMostSpecificCause()));
    }
    public Mono<Client> findById(String id){
        return clientRepository.findById(id)
                .onErrorResume(throwable -> {
                    LOGGER.error("Error querying a client with id= " + id, throwable);
                    return Mono.empty();
                })
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Client with id= " + id + " not found").getMostSpecificCause()));
    }
}
