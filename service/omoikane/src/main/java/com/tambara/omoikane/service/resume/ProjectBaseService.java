package com.tambara.omoikane.service.resume;

import com.tambara.omoikane.model.resume.Project;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProjectBaseService {
    List<Project> getAll();

    Project get(long pid);

    Project add(Project p);

    void remove(long pid);

    Project update(Project p);
}
