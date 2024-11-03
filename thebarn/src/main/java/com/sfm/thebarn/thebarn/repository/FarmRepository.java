package com.sfm.thebarn.thebarn.repository;

import com.sfm.thebarn.thebarn.model.Farms;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FarmRepository extends JpaRepository<Farms, String> {
}
