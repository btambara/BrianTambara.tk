package com.tambara.omoikane.service.resume;

import com.tambara.omoikane.model.resume.Education;
import com.tambara.omoikane.repository.resume.EducationRepo;
import com.tambara.omoikane.service.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//Purpose: The service class for Education.
@Service
public class EducationService implements EducationBaseService {
    @Autowired
    private EducationRepo educationRepo;

    @Override
    public List<Education> getAll() {
        return educationRepo.findAll();
    }

    @Override
    public Education get(long eid) {
        return educationRepo.findById(eid)
                .orElseThrow(() -> new ResourceNotFoundException("Unable to locate Education with ID: " + eid));
    }

    @Override
    public Education add(Education e) {
        return educationRepo.save(e);
    }

    @Override
    public void remove(long eid) {
        educationRepo.deleteById(eid);
    }

    @Override
    public Education update(Education e) {
        return educationRepo.findById(e.getEid())
                .map(education -> {
                    education.setName(e.getName());
                    education.setLocation(e.getLocation());
                    education.setCertification(e.getCertification());
                    education.setStarted(e.getStarted());
                    education.setEnded(e.getEnded());
                    return educationRepo.save(education);
                })
                .orElseGet(() -> add(e));
    }
}
