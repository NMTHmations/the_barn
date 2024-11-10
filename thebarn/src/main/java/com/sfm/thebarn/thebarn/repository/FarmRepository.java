package com.sfm.thebarn.thebarn.repository;

import com.sfm.thebarn.thebarn.model.Farms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FarmRepository extends JpaRepository<Farms, String> {
}
