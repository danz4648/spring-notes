package com.danz.springnotes.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.danz.springnotes.model.UserNotes;

@Repository
public interface UserDao extends CrudRepository<UserNotes, String> {
    Optional<UserNotes> findByUsername(String username);
}
