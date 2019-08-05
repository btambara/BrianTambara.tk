package com.tambara.omoikane.mapper.resume;

import com.tambara.omoikane.dto.resume.ProjectDto;
import com.tambara.omoikane.model.resume.Project;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class ProjectMapper {
    @Autowired
    private ModelMapper modelMapper;

    public ProjectDto convertToDto(Project j) {
        return modelMapper.map(j, ProjectDto.class);
    }

    public Project convertToModel(ProjectDto dto) {
        return modelMapper.map(dto, Project.class);
    }
}
