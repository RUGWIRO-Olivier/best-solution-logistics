package com.bestSolutionCargo.serviceImpl;

import com.bestSolutionCargo.dto.SparePartsDto;
import com.bestSolutionCargo.exceptions.ApiRequestException;
import com.bestSolutionCargo.models.SpareParts;
import com.bestSolutionCargo.repository.SparePartsRepo;
import com.bestSolutionCargo.service.SparePartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SparePartsServiceImpl implements SparePartsService {

    @Autowired
    SparePartsRepo repo;

    @Override
    public SpareParts createSparePart(SparePartsDto dto) {
        if (dto == null)
            throw new ApiRequestException("Spare Parts Object is missing");

        SpareParts model = new SpareParts();

        model.setName(dto.getName());
        model.setSerialNumber(dto.getSerialNumber());
        model.setPartNumber(dto.getPartNumber());
        model.setDoq(dto.getDoq());
        model.setQuantity(dto.getQuantity());
        model.setObservation(dto.getObservation());
        model.setDescription(dto.getDescription());
        model.setCreatedBy(dto.getCreatedBy());

        return repo.save(model);
    }

    @Override
    public List<SpareParts> getSpareParts() {
        return repo.findAll();
    }

    @Override
    public SpareParts getSparePart(String id) {
        SpareParts spareParts = repo.findById(id).orElseThrow(
                () -> new ApiRequestException("Spare Part with ID " + id + " is not found"));

        spareParts.getId();
        return spareParts;
    }

    @Override
    public SpareParts updateSparePart(SparePartsDto dto) {
        SpareParts model= repo.findById(dto.getId())
                .orElseThrow(() -> new ApiRequestException("Spare Part with given object is not found"));

        model.setName(dto.getName()==null?model.getName():dto.getName());
        model.setSerialNumber(dto.getSerialNumber()==null?model.getSerialNumber():dto.getSerialNumber());
        model.setPartNumber(dto.getPartNumber()==null?model.getPartNumber():dto.getPartNumber());
        model.setDoq(dto.getDoq()==null?model.getDoq():dto.getDoq());
        model.setQuantity(dto.getQuantity()==null?model.getQuantity():dto.getQuantity());
        model.setObservation(dto.getObservation()==null?model.getObservation():dto.getObservation());
        model.setDescription(dto.getDescription()==null?model.getDescription():dto.getDescription());
        model.setCreatedBy(dto.getCreatedBy()==null?model.getCreatedBy():dto.getCreatedBy());
        model.setUpdatedBy(dto.getUpdatedBy()==null?model.getUpdatedBy():dto.getUpdatedBy());
        return repo.save(model);
    }

    @Override
    public void deleteSparePart(String id) {
        repo.deleteById(id);
    }
}
