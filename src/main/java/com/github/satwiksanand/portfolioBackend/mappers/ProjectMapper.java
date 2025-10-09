package com.github.satwiksanand.portfolioBackend.mappers;

import com.github.satwiksanand.portfolioBackend.dto.ProjectDto;
import com.github.satwiksanand.portfolioBackend.models.Projects;

public class ProjectMapper {
    public static ProjectDto toDto(Projects projects){
        return ProjectDto.builder()
                .id(projects.getId())
                .name(projects.getName())
                .description(projects.getDescription())
                .technologyUsed(projects.getTechnologyUsed())
                .githubUrl(projects.getGithubUrl())
                .liveUrl(projects.getLiveUrl())
                .imageUrl(projects.getImageUrl())
                .build();
    }
}
