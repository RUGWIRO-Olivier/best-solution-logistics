package com.bestSolutionCargo.service;

import com.bestSolutionCargo.dto.SparePartsDto;
import com.bestSolutionCargo.models.SpareParts;

import java.util.List;

public interface SparePartsService {

    SpareParts createSparePart(SparePartsDto dto);
    List<SpareParts> getSpareParts();
    SpareParts getSparePart(String id);
    SpareParts updateSparePart(SparePartsDto dto);
    void deleteSparePart(String id);
}
