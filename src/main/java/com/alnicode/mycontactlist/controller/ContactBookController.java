package com.alnicode.mycontactlist.controller;

import com.alnicode.mycontactlist.dto.book.ContactBookRequest;
import com.alnicode.mycontactlist.dto.book.ContactBookResponse;
import com.alnicode.mycontactlist.service.IContactBookService;
import com.alnicode.mycontactlist.service.ICrudService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class ContactBookController extends CrudController<ContactBookRequest, ContactBookResponse> {
    @Autowired
    private IContactBookService service;

    @Override
    protected ICrudService<ContactBookRequest, ContactBookResponse> service() {
        return this.service;
    }
    
}
