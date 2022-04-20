package com.alnicode.mycontactlist.dto.contact;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class ContactResponse {
    @Min(1L)
    private long id;

    @NotBlank
    private String name;
    
    @NotBlank
    private String lastname;
    
    @NotBlank
    private String phone;
    
    @NotBlank
    @Email
    private String email;
    
    @NotBlank
    private String direction;
    
    @Min(1L)
    private long bookId;
}
