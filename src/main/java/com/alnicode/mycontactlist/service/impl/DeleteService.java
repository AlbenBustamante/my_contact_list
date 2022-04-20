package com.alnicode.mycontactlist.service.impl;

import org.springframework.data.jpa.repository.JpaRepository;

public abstract class DeleteService<Entity> {
    protected abstract JpaRepository<Entity, Long> repository();

    public boolean delete(long id) {
        try {
            this.repository().deleteById(id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
