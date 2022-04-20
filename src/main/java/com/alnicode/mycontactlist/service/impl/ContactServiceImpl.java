package com.alnicode.mycontactlist.service.impl;

import java.util.List;
import java.util.Optional;

import com.alnicode.mycontactlist.dto.contact.ContactRequest;
import com.alnicode.mycontactlist.dto.contact.ContactResponse;
import com.alnicode.mycontactlist.entity.Contact;
import com.alnicode.mycontactlist.mapper.IContactMapper;
import com.alnicode.mycontactlist.repository.IContactRepository;
import com.alnicode.mycontactlist.service.IContactService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl extends DeleteService<Contact> implements IContactService {
    @Autowired
    private IContactRepository repository;

    @Autowired
    private IContactMapper mapper;

    @Override
    public ContactResponse save(ContactRequest request) {
        return this.mapper.toResponse(this.repository.save(this.mapper.toEntity(request)));
    }

    @Override
    public List<ContactResponse> getAll() {
        return this.mapper.toResponses(this.repository.findAll());
    }

    @Override
    public Optional<ContactResponse> get(long id) {
        return this.repository.findById(id).map(mapper::toResponse);
    }

    @Override
    public Optional<ContactResponse> update(long id, ContactRequest request) {
        if (!this.repository.existsById(id)) {
            return Optional.empty();
        }

        var entity = this.mapper.toEntity(request);
        entity.setId(id);

        return Optional.of(this.mapper.toResponse(this.repository.save(entity)));
    }

    @Override
    public Optional<List<ContactResponse>> getByBookId(long bookId) {
        return this.repository.findByBookId(bookId).map(mapper::toResponses);
    }

    @Override
    public Optional<List<ContactResponse>> getByName(String name) {
        return this.repository.findByName(name).map(mapper::toResponses);
    }

    @Override
    protected JpaRepository<Contact, Long> repository() {
        return this.repository;
    }
    
}
