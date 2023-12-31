package edu.microservices.movie.models;

import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.persistence.Entity;
//import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity(name = "movie")
@Table(name = "movie")
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    //@Id
    @jakarta.persistence.Id
    @Schema(description = "Unique ID of the movie", example = "1")
    private String id;
    @Schema(description = "Title of the movie", example = "Inception")
    private String title;
    @Schema(description = "Director of the movie", example = "Christopher Nolan")
    private String director;
    @Schema(description = "Release year of the movie", example = "2010")
    private Integer releaseYear;
    @Schema(description = "Genre of the movie", example = "Sci-Fi")
    private String genre;
    @Override
    public String toString() {
        return "Movie {" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", director='" + director + '\'' +
                ", releaseYear=" + releaseYear +
                ", genre='" + genre + '\'' +
                '}';
    }
}
