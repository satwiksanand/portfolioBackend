package com.github.satwiksanand.portfolioBackend.controllers;

import com.github.satwiksanand.portfolioBackend.api.ApiResp;
import com.github.satwiksanand.portfolioBackend.dto.ProjectDto;
import com.github.satwiksanand.portfolioBackend.services.ProjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService){
        this.projectService = projectService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectDto> getProjectById(@PathVariable String id) throws Exception {
        return ResponseEntity.ok(projectService.getProjectById(id));
    }

    @GetMapping
    public ResponseEntity<List<ProjectDto>> getAllProjects(){
        return ResponseEntity.ok(projectService.getAllProjects());
    }

    @PostMapping("/create")
    public ResponseEntity<ProjectDto> submitProject(@RequestBody ProjectDto projectDto){
        return ResponseEntity.ok(projectService.submitProject(projectDto));
    }

    @DeleteMapping
    public ResponseEntity<ApiResp> deleteProject(@RequestParam String id) throws Exception {
        projectService.deleteProject(id);
        ApiResp apiResponse = new ApiResp("project deleted successfully");
        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping
    public ResponseEntity<ProjectDto> editProject(@RequestBody ProjectDto projectDto) throws Exception {
        return ResponseEntity.ok(projectService.editProject(projectDto));
    }
}
