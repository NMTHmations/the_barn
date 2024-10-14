package com.sfm.thebarn.thebarn.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalsCRUD extends CrudRepository<Animals, String> {
}
