package com.sfm.thebarn.thebarn.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import java.util.List;

@Repository
public interface AnimalsCRUD extends CrudRepository<Animals, String> {
    //todo vv temp remove before final | working query
    //@Query("select a from Animals a where a.id = :query or a.farmid.id = :query or a.farmid.FarmName = :query")
    @Query("select a from Animals a where " +
            "a.id LIKE CONCAT('%',:query,'%') or " +
            "a.farmid.id LIKE CONCAT('%',:query,'%') or " +
            "a.farmid.FarmName LIKE CONCAT('%',:query,'%')")
    List<Animals> findByIdOrFarmIdOrFarmName(@RequestParam(value = "query", required = false) String query);
    @Query("select a from Animals a where "+
            "a.farmid.id = :query ")
    List<Animals> findAllByFarmId(@RequestParam(value = "query",required = false) String query);
    @Query("select a from Animals a where "+
            "a.id LIKE CONCAT('%',:query,'%') and "+
            "a.farmid.id = :farmid ")
    List<Animals> findByIdFixedFarmId(@RequestParam(value = "query",required = false) String query,@RequestParam(value = "query",required = true) String farmid);
    List<Animals> findBymotherid(Animals animal);
    List<Animals> findByfatherid(Animals animal);
}
