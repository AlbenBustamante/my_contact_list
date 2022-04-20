package com.alnicode.mycontactlist.service;

import java.util.List;
import java.util.Optional;

import com.alnicode.mycontactlist.dto.contact.ContactRequest;
import com.alnicode.mycontactlist.dto.contact.ContactResponse;

public interface IContactService extends ICrudService<ContactRequest, ContactResponse> {
    Optional<List<ContactResponse>> getByBookId(long bookId);
    Optional<List<ContactResponse>> getByName(String name);
}
