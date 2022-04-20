package com.alnicode.mycontactlist.service.impl;

import java.util.List;
import java.util.Optional;

import com.alnicode.mycontactlist.dto.book.ContactBookRequest;
import com.alnicode.mycontactlist.dto.book.ContactBookResponse;
import com.alnicode.mycontactlist.entity.ContactBook;
import com.alnicode.mycontactlist.mapper.IContactBookMapper;
import com.alnicode.mycontactlist.repository.IContactBookRepository;
import com.alnicode.mycontactlist.service.IContactBookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ContactBookServiceImpl extends DeleteService<ContactBook> implements IContactBookService {
    @Autowired
    private IContactBookRepository repository;

    @Autowired
    private IContactBookMapper mapper;

    @Override
    public ContactBookResponse save(ContactBookRequest request) {
        return this.mapper.toResponse(this.repository.save(this.mapper.toEntity(request)));
    }

    @Override
    public List<ContactBookResponse> getAll() {
        return this.mapper.toResponses(this.repository.findAll());
    }

    @Override
    public Optional<ContactBookResponse> get(long id) {
        return this.repository.findById(id).map(mapper::toResponse);
    }

    @Override
    public Optional<ContactBookResponse> update(long id, ContactBookRequest request) {
        var toFind = this.repository.findById(id);
        if (!toFind.isPresent()) {
            return Optional.empty();
        }
        
        var entity = this.mapper.toEntity(request);
        entity.setId(id);
        entity.setDate(toFind.get().getDate());

        return Optional.of(this.mapper.toResponse(this.repository.save(entity)));
    }

    @Override
    protected JpaRepository<ContactBook, Long> repository() {
        return this.repository;
    }
    
}