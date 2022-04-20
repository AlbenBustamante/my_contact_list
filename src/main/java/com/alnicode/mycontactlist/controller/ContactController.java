package com.alnicode.mycontactlist.controller;

import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.alnicode.mycontactlist.dto.contact.ContactRequest;
import com.alnicode.mycontactlist.dto.contact.ContactResponse;
import com.alnicode.mycontactlist.service.IContactService;
import com.alnicode.mycontactlist.service.ICrudService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/contacts")
public class ContactController extends CrudController<ContactRequest, ContactResponse> {
    @Autowired
    private IContactService service;

    @Override
    protected ICrudService<ContactRequest, ContactResponse> service() {
        return this.service;
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<List<ContactResponse>> getByBook(@Min(1L) @PathVariable("id") long bookId) {
        return ResponseEntity.of(this.service.getByBookId(bookId));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<ContactResponse>> getByName(@NotBlank @PathVariable("name") String name) {
        return ResponseEntity.of(this.service.getByName(name));
    }
    
}
