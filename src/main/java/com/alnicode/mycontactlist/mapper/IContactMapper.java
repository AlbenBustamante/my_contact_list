package com.alnicode.mycontactlist.mapper;

import java.util.List;

import com.alnicode.mycontactlist.dto.contact.ContactRequest;
import com.alnicode.mycontactlist.dto.contact.ContactResponse;
import com.alnicode.mycontactlist.entity.Contact;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IContactMapper {
    ContactResponse toResponse(Contact entity);
    List<ContactResponse> toResponses(List<Contact> entities);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "book", ignore = true)
    Contact toEntity(ContactRequest request);
}
