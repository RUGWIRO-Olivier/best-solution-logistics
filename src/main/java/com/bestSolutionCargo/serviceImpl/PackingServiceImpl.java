package com.bestSolutionCargo.serviceImpl;

import com.bestSolutionCargo.dto.PackingDto;
import com.bestSolutionCargo.exceptions.ApiRequestException;
import com.bestSolutionCargo.models.Packing;
import com.bestSolutionCargo.repository.PackingRepo;
import com.bestSolutionCargo.service.PackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PackingServiceImpl implements PackingService {


    @Autowired
    PackingRepo repo;

    @Override
    public Packing createPacking(PackingDto dto) {
        if (dto == null)
            throw new ApiRequestException("Packing Object is missing");

        Packing model = new Packing();

        model.setSerialNumber(dto.getSerialNumber());
        model.setPartNumber(dto.getPartNumber());
        model.setDim(dto.getDim());
        model.setQuantity(dto.getQuantity());
        model.setRemarks(dto.getRemarks());
        model.setDescription(dto.getDescription());
        model.setCreatedBy(dto.getCreatedBy());
        model.setWeight(dto.getWeight());

        return repo.save(model);
    }

    @Override
    public List<Packing> getPackings() {
        return repo.findAll();
    }

    @Override
    public Packing getPacking(String id) {
        Packing packing = repo.findById(id).orElseThrow(
                () -> new ApiRequestException("Packing with ID " + id + " is not found"));

        packing.getId();
        return packing;
    }

    @Override
    public Packing updatePacking(PackingDto dto) {
        Packing model= repo.findById(dto.getId())
                .orElseThrow(() -> new ApiRequestException("Packing with given object is not found"));

        model.setSerialNumber(dto.getSerialNumber()==null?model.getSerialNumber():dto.getSerialNumber());
        model.setPartNumber(dto.getPartNumber()==null?model.getPartNumber():dto.getPartNumber());
        model.setQuantity(dto.getQuantity()==null?model.getQuantity():dto.getQuantity());
        model.setRemarks(dto.getRemarks()==null?model.getRemarks():dto.getRemarks());
        model.setDescription(dto.getDescription()==null?model.getDescription():dto.getDescription());
        model.setCreatedBy(dto.getCreatedBy()==null?model.getCreatedBy():dto.getCreatedBy());
        model.setUpdatedBy(dto.getUpdatedBy()==null?model.getUpdatedBy():dto.getUpdatedBy());
        model.setDim(dto.getDim()==null?model.getDim():dto.getDim());
        model.setWeight(dto.getWeight()==null?model.getWeight():dto.getWeight());


        return repo.save(model);
    }

    @Override
    public void deletePacking(String id) {
        repo.deleteById(id);
    }

}
