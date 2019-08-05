package com.tambara.omoikane.service.contact;

import com.tambara.omoikane.model.contact.Contact;
import com.tambara.omoikane.service.ResourceNotFoundException;
import org.springframework.stereotype.Component;

@Component
public interface ContactBaseService {
    Contact get() throws ResourceNotFoundException;

    Contact create(Contact c);

    Contact update(Contact c);
}
