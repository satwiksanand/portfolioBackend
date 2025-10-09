package com.github.satwiksanand.portfolioBackend.services.serviceImplementations;

import com.github.satwiksanand.portfolioBackend.dto.ProjectDto;
import com.github.satwiksanand.portfolioBackend.mappers.ProjectMapper;
import com.github.satwiksanand.portfolioBackend.models.Projects;
import com.github.satwiksanand.portfolioBackend.repositories.ProjectRepository;
import com.github.satwiksanand.portfolioBackend.services.ProjectService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public ProjectDto getProjectById(String id) throws Exception {
        Projects projects = projectRepository.findById(id).orElseThrow(
                ()->new Exception("project not found!")
        );
        return ProjectMapper.toDto(projects);
    }

    @Override
    public List<ProjectDto> getAllProjects() {
        List<Projects> allProjects = projectRepository.findAll();
        return allProjects.stream().map(ProjectMapper::toDto).collect(Collectors.toList());
    }
}
