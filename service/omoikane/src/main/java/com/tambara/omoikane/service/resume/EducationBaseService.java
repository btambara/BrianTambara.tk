package com.tambara.omoikane.service.resume;

import com.tambara.omoikane.model.resume.Education;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface EducationBaseService {
    List<Education> getAll();

    Education get(long eid);

    Education add(Education e);

    void remove(long eid);

    Education update(Education e);
}
