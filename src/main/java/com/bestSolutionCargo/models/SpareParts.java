package com.bestSolutionCargo.models;

import com.bestSolutionCargo.dto.SparePartsDto;
import lombok.Data;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class SpareParts extends BaseEntity{
    private String name, serialNumber, partNumber, description, doq, observation;
    private Integer quantity;

    public SpareParts(){

    }

    public SpareParts(String id, String createdBy,  String name, String serialNumber, String partNumber, String description, String doq, String observation, Integer quantity) {
        super(id, createdBy);
        this.name = name;
        this.serialNumber = serialNumber;
        this.partNumber = partNumber;
        this.description = description;
        this.doq = doq;
        this.observation = observation;
        this.quantity = quantity;
    }


    public  static final SparePartsDto REFACTOR(SpareParts spareParts) {
        return new SparePartsDto(spareParts);
    }

    public static final List<SparePartsDto> REFACTOR(List<SpareParts> sparePartsList) {
        List<SparePartsDto> dto = new ArrayList<>();
        for (SpareParts spareParts : sparePartsList) {
            dto.add(REFACTOR(spareParts));
        }
        return dto;
    }
}
