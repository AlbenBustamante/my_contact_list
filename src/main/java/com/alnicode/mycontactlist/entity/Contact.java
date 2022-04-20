package com.alnicode.mycontactlist.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
@Table(name = "contacts")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_id")
    private Long id;

    @NotNull
    @Size(min = 3, max = 100)
    private String name;

    @NotNull
    @Size(min = 3, max = 100)
    @Column(name = "last_name")
    private String lastname;

    @NotNull
    @Size(min = 10, max = 15)
    private String phone;

    @NotNull
    @Size(min = 12, max = 200)
    private String email;

    @NotNull
    @Size(min = 20, max = 300)
    private String direction;

    @NotNull
    @Min(1L)
    @Max(Long.MAX_VALUE)
    @Column(name = "contact_book_id")
    private Long bookId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contact_book_id", insertable = false, updatable = false)
    private ContactBook book;
}
