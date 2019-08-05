package com.tambara.omoikane.mapper.resume;

import com.tambara.omoikane.dto.resume.EducationDto;
import com.tambara.omoikane.model.resume.Education;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class EducationMapper {
    @Autowired
    private ModelMapper modelMapper;

    public EducationDto convertToDto(Education e) {
        return modelMapper.map(e, EducationDto.class);
    }

    public Education convertToModel(EducationDto dto) {
        return modelMapper.map(dto, Education.class);
    }
}
