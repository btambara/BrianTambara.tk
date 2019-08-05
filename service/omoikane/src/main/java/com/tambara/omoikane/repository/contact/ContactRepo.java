package com.tambara.omoikane.repository.contact;

import com.tambara.omoikane.model.contact.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface ContactRepo extends JpaRepository<Contact, Long> {
}
