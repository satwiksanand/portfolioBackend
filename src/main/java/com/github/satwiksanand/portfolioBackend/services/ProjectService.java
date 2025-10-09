package com.github.satwiksanand.portfolioBackend.services;

import com.github.satwiksanand.portfolioBackend.dto.ProjectDto;

import java.util.List;

public interface ProjectService {
    ProjectDto getProjectById(String id) throws Exception;
    List<ProjectDto> getAllProjects();
}
