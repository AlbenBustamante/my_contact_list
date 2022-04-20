package com.alnicode.mycontactlist.repository;

import java.util.List;
import java.util.Optional;

import com.alnicode.mycontactlist.entity.Contact;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IContactRepository extends JpaRepository<Contact, Long> {
    Optional<List<Contact>> findByBookId(long bookId);
    Optional<List<Contact>> findByName(String name);
}
