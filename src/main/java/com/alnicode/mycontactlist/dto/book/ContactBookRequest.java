package com.alnicode.mycontactlist.dto.book;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class ContactBookRequest {
    @NotBlank
    private String name;
}
