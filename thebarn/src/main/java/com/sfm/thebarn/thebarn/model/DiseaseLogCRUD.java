package com.sfm.thebarn.thebarn.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface DiseaseLogCRUD extends CrudRepository<DiseaseLog,Integer> {
    @Query("select a from DiseaseLog a where " +
            "a.animalid.id LIKE CONCAT('%',:query,'%') or " +
            "a.animalid.farmid.FarmName LIKE CONCAT('%',:query,'%')")
    List<DiseaseLog> findByAnimalIdOrFarmName(@RequestParam(value = "query", required = false) String query);

    @Query("select a from DiseaseLog a where "+
            "a.animalid.farmid.id = :query ")
    List<DiseaseLog> findAllByFarmId(@RequestParam(value = "query",required = false) String query);

    @Query("select a from DiseaseLog a where "+
            "a.animalid.id LIKE CONCAT('%',:query,'%') and "+
            "a.animalid.farmid.id = :farmid ")
    List<DiseaseLog> findByIdFixedFarmId(@RequestParam(value = "query",required = false) String query,
                                         @RequestParam(value = "query",required = true) String farmid);
}
