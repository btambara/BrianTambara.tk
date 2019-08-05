package com.tambara.omoikane.repository.resume;

import com.tambara.omoikane.model.resume.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface JobRepo extends JpaRepository<Job, Long> {
}
