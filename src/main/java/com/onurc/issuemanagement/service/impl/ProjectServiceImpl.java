package com.onurc.issuemanagement.service.impl;

import com.onurc.issuemanagement.DTO.ProjectDto;
import com.onurc.issuemanagement.entity.Project;
import com.onurc.issuemanagement.repo.ProjectRepository;
import com.onurc.issuemanagement.repo.UserRepository;
import com.onurc.issuemanagement.service.ProjectService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository, ModelMapper modelMapper, UserRepository userRepository) {
        this.projectRepository = projectRepository;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
    }

    @Override
    public ProjectDto save(ProjectDto project) {

        Project projectCheck = projectRepository.getByProjectCode(project.getProjectCode());
        if (projectCheck != null)
            throw new IllegalArgumentException("Project code already exist");

        Project p = modelMapper.map(project, Project.class);
        p = projectRepository.save(p);
        project.setId(p.getId());
        return project;
    }

    @Override
    public ProjectDto getById(Long id) {
        Project p = projectRepository.getOne(id);
        return modelMapper.map(p, ProjectDto.class);
    }

    @Override
    public ProjectDto getByProjectCode(String projectCode) {
        return null;
    }

    @Override
    public List<Project> getByProjectCodeContains(String projectCode) {
        return null;
    }

    @Override
    public Page<Project> getAllPageable(Pageable pageable) {
        return projectRepository.findAll(pageable);
    }

    @Override
    public Boolean delete(Project project) {
        return null;
    }

    @Override
    public ProjectDto update(Long id, ProjectDto project) {

        Project projectDb = projectRepository.getOne(id);
        if (projectDb == null){
            throw new IllegalArgumentException("Project Does Not Exist");
        }

        Project projectCheck = projectRepository.getByProjectCodeAndIdNot(project.getProjectCode(),id);
        if (projectCheck != null)
            throw new IllegalArgumentException("Project code already exist");

        projectDb.setProjectCode(project.getProjectCode());
        projectDb.setProjectName(project.getProjectName());
        projectRepository.save(projectDb);
        return modelMapper.map(projectDb, ProjectDto.class);
    }
}
