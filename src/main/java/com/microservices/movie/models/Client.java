package com.microservices.movie.msmovie.models;

import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "client")
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    @jakarta.persistence.Id
    @Schema(description = "Unique ID of the user, usually a typed ID", example = "14463182")
    protected String id;
    @Schema(description = "User name", example = "Alejandro")
    protected String name;
    @Schema(description = "User lastName", example = "Tortolero")
    protected String lastName;
    @Schema(description = "User email", example = "email@example.com")
    protected String email;
    @Override
    public String toString() {
        return "User {" +
                "  id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
