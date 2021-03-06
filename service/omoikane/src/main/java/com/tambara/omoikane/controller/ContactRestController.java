package com.tambara.omoikane.controller;

import com.tambara.omoikane.dto.contact.ContactDto;
import com.tambara.omoikane.mapper.contact.ContactMapper;
import com.tambara.omoikane.model.contact.Contact;
import com.tambara.omoikane.service.contact.ContactBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

//Purpose: The REST (HATEOAS) controller for the contact part of the application.
//Notes:
//1) Only ONE entry should be in this table.
@RestController
@RequestMapping(value = "/api/contact")
public class ContactRestController {

    @Bean
    public ContactMapper createContactMapper() {
        return new ContactMapper();
    }

    @Autowired
    private ContactBaseService personalContactService;

    @Autowired
    private ContactMapper contactMapper;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Resource<ContactDto> getContact() {
        ContactDto contactDto = contactMapper.convertToContactDto(personalContactService.get());
        Link link = linkTo(methodOn(ContactRestController.class).getContact()).withSelfRel();
        return new Resource<>(contactDto, link);
    }

    @PostMapping
    @ResponseBody
    public Resource<ContactDto> addContact(@RequestBody ContactDto cdto) {
        ContactDto contactDto = contactMapper.convertToContactDto(personalContactService.create(contactMapper.convertToContact(cdto)));
        Link link = linkTo(methodOn(ContactRestController.class).addContact(cdto)).withSelfRel();
        return new Resource<>(contactDto, link);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateContact(@RequestBody ContactDto cdto) {
        Contact contact = contactMapper.convertToContact(cdto);
        personalContactService.update(contact);
    }
}
