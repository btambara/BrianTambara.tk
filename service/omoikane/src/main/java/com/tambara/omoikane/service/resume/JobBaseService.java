package com.tambara.omoikane.service.resume;

import com.tambara.omoikane.model.resume.Job;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface JobBaseService {
    List<Job> getAll();

    Job get(long jid);

    Job add(Job j);

    void remove(long jid);

    Job update(Job j);
}
