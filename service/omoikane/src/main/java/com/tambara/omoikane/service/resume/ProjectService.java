package com.tambara.omoikane.service.resume;

import com.tambara.omoikane.model.resume.Project;
import com.tambara.omoikane.repository.resume.ProjectRepo;
import com.tambara.omoikane.service.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//Purpose: The service class for Projects.
@Service
public class ProjectService implements ProjectBaseService {
    @Autowired
    private ProjectRepo projectRepo;

    @Override
    public List<Project> getAll() {
        return projectRepo.findAll();
    }

    @Override
    public Project get(long pid) {
        return projectRepo.findById(pid)
                .orElseThrow(() -> new ResourceNotFoundException("Unable to locate Project with ID: " + pid));
    }

    @Override
    public Project add(Project p) {
        return projectRepo.save(p);
    }

    @Override
    public void remove(long pid) {
        projectRepo.deleteById(pid);
    }

    @Override
    public Project update(Project p) {
        return projectRepo.findById(p.getPid())
                .map(project -> {
                    project.setName(p.getName());
                    project.setLocation(p.getLocation());
                    project.setTitle(p.getTitle());
                    project.setSummary(p.getSummary());
                    project.setWebsiteLink(p.getWebsiteLink());
                    project.setRepositoryLink(p.getSummary());
                    project.setProjectStart(p.getProjectStart());
                    project.setProjectEnd(p.getProjectEnd());
                    return projectRepo.save(project);
                })
                .orElseGet(() -> add(p));
    }
}
