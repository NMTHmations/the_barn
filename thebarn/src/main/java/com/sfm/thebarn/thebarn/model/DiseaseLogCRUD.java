package com.sfm.thebarn.thebarn.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiseaseLogCRUD extends CrudRepository<DiseaseLog,Integer> {
}
