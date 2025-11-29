package com.github.satwiksanand.portfolioBackend.services;

import com.github.satwiksanand.portfolioBackend.dto.ProjectDto;

import java.util.List;

public interface ProjectService {
    ProjectDto getProjectById(String id) throws Exception;
    List<ProjectDto> getAllProjects();
    ProjectDto submitProject(ProjectDto projectDto);
    void deleteProject(String id) throws Exception;
    ProjectDto editProject(ProjectDto projectDto) throws Exception;
}
