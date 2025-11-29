package com.github.satwiksanand.portfolioBackend.models;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
@Builder
public class Projects {
    @Id
    private String id;

    @NotNull(message = "imageUrl cannot be null")
    private String imageUrl;

    @NotEmpty(message = "name must be provided")
    @NotNull(message = "name cannot be null")
    private String name;

    private String description;

    private List<String> technologyUsed;

    @NotNull(message = "githubUrl is a mandatory field")
    private String githubUrl;
    private String liveUrl;
}
