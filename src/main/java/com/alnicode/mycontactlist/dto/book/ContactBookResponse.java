package com.alnicode.mycontactlist.dto.book;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class ContactBookResponse {
    @Min(1L)
    private long id;

    @NotBlank
    private String name;
}
