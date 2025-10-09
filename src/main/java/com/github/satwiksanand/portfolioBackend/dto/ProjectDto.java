package com.github.satwiksanand.portfolioBackend.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ProjectDto {
    private String id;
    private String imageUrl;
    private String name;
    private String description;
    private List<String> technologyUsed;
    private String githubUrl;
    private String liveUrl;
}
