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

    public static Projects toEntity(ProjectDto projectDto){
        return Projects.builder()
                .liveUrl(projectDto.getLiveUrl())
                .name(projectDto.getName())
                .description(projectDto.getDescription())
                .technologyUsed(projectDto.getTechnologyUsed())
                .githubUrl(projectDto.getGithubUrl())
                .imageUrl(projectDto.getImageUrl())
                .build();
    }
}
