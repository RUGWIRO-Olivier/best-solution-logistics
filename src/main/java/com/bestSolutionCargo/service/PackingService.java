package com.bestSolutionCargo.service;

import com.bestSolutionCargo.dto.PackingDto;
import com.bestSolutionCargo.models.Packing;

import java.util.List;

public interface PackingService {

    Packing createPacking(PackingDto dto);
    List<Packing> getPackings();
    Packing getPacking(String id);
    Packing updatePacking(PackingDto dto);
    void deletePacking(String id);

}
