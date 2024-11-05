package com.sfm.thebarn.thebarn.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalsCRUD extends CrudRepository<Animals, String> {
}
