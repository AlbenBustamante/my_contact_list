package com.alnicode.mycontactlist.service.impl;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public abstract class DeleteService<Entity> {
    protected abstract JpaRepository<Entity, Long> repository();

    @Transactional
    public boolean delete(long id) {
        try {
            this.repository().deleteById(id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
