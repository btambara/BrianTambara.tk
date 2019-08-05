package com.tambara.omoikane.mapper.resume;

import com.tambara.omoikane.dto.resume.JobDto;
import com.tambara.omoikane.model.resume.Job;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class JobMapper {
    @Autowired
    private ModelMapper modelMapper;

    public JobDto convertToDto(Job j) {
        return modelMapper.map(j, JobDto.class);
    }

    public Job convertToModel(JobDto dto) {
        return modelMapper.map(dto, Job.class);
    }
}
