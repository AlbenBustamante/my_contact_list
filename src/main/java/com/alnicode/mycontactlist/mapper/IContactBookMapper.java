package com.alnicode.mycontactlist.mapper;

import java.util.List;

import com.alnicode.mycontactlist.dto.book.ContactBookRequest;
import com.alnicode.mycontactlist.dto.book.ContactBookResponse;
import com.alnicode.mycontactlist.entity.ContactBook;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static com.alnicode.mycontactlist.util.AppConstants.DATE_TIME_FORMAT;

@Mapper(componentModel = "spring")
public interface IContactBookMapper {
    @Mapping(target = "date", dateFormat = DATE_TIME_FORMAT)
    ContactBookResponse toResponse(ContactBook entity);
    List<ContactBookResponse> toResponses(List<ContactBook> entities);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "date", ignore = true)
    @Mapping(target = "contacts", ignore = true)
    ContactBook toEntity(ContactBookRequest request);
}
