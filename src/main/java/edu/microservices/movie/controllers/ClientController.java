package edu.microservices.movie.controllers;

import edu.microservices.movie.models.Client;
import edu.microservices.movie.services.ClientService;
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
@RequestMapping("/v1/client")
@Tag(name = "Clients", description = "Operations on client of API")
public class ClientController {
    private final ClientService clientService;
    @GetMapping("")
    @Operation(
            summary = "Get all clients",
            description = "Allows you to obtain the list of all clients"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Movies created in the system",
                    content = @Content(schema = @Schema(implementation = Client.class)))
    })
    public Flux<Client> getAllClients(){
        return clientService.findAll();
    }
}
