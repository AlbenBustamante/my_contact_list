package com.alnicode.mycontactlist.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Data;

@Data
@Entity
@Table(name = "contact_books")
public class ContactBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_book_id")
    private Long id;

    @NotNull
    @Size(min = 5, max = 120)
    private String name;

    @DateTimeFormat(iso = ISO.DATE_TIME, pattern = "")
    @Column(name = "creation_date")
    private LocalDateTime date;

    @PrePersist
    public void setCreationDate() {
        if (this.date == null) {
            this.date = LocalDateTime.now();
        }
    }
}
