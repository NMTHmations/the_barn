package com.sfm.thebarn.thebarn.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalsCRUD extends CrudRepository<Animals, String> {
    //@Query("select a from Animals a where a.id = :query or a.farmid.id = :query or a.farmid.FarmName = :query")
    @Query("select a from Animals a where " +
            "a.id LIKE CONCAT('%',:query,'%') or " +
            "a.farmid.id LIKE CONCAT('%',:query,'%') or " +
            "a.farmid.FarmName LIKE CONCAT('%',:query,'%')")
    List<Animals> findByIdOrFarmIdOrFarmName(@Param("query") String query);
}
