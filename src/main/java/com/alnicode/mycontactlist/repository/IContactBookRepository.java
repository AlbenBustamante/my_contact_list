package com.alnicode.mycontactlist.repository;

import com.alnicode.mycontactlist.entity.ContactBook;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IContactBookRepository extends JpaRepository<ContactBook, Long> {
    
}
