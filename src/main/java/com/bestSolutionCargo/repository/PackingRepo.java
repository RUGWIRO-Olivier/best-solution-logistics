package com.bestSolutionCargo.repository;

import com.bestSolutionCargo.models.Packing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PackingRepo extends JpaRepository<Packing, String> {
}
