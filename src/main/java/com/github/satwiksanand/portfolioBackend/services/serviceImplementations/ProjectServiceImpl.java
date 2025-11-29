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

    @Override
    public ProjectDto submitProject(ProjectDto projectDto) {
        Projects newProject = ProjectMapper.toEntity(projectDto);
        return ProjectMapper.toDto(projectRepository.save(newProject));
    }

    @Override
    public void deleteProject(String id) throws Exception {
        if(projectRepository.existsById(id)){
            projectRepository.deleteById(id);
        }
        else{
            throw new Exception("project does not exist!");
        }
    }

    @Override
    public ProjectDto editProject(ProjectDto projectDto) throws Exception {
        Projects projects = projectRepository.findById(projectDto.getId()).orElseThrow(
                ()->new Exception("project does not exist")
        );
        projects.setName(projectDto.getName());
        projects.setDescription(projectDto.getDescription());
        projects.setGithubUrl(projectDto.getGithubUrl());
        projects.setLiveUrl(projectDto.getLiveUrl());
        projects.setImageUrl(projectDto.getImageUrl());
        projects.setTechnologyUsed(projectDto.getTechnologyUsed());
        return ProjectMapper.toDto(projectRepository.save(projects));
    }
}
