package com.alnicode.mycontactlist.repository;

import com.alnicode.mycontactlist.entity.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
