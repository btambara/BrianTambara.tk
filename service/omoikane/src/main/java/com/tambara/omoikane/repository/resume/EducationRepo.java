package com.tambara.omoikane.repository.resume;

import com.tambara.omoikane.model.resume.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface EducationRepo extends JpaRepository<Education, Long> {
}
