package com.bestSolutionCargo.models;

import com.bestSolutionCargo.dto.PackingDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Packing extends BaseEntity{
    private String  serialNumber, partNumber, description, weight, dim, remarks;
    private Integer quantity;

    public Packing(String id, String createdBy, String serialNumber, String partNumber, String description, String weight, String dim, String remarks, Integer quantity) {
        super(id, createdBy);
        this.serialNumber = serialNumber;
        this.partNumber = partNumber;
        this.description = description;
        this.weight = weight;
        this.dim = dim;
        this.remarks = remarks;
        this.quantity = quantity;
    }


    public  static final PackingDto REFACTOR(Packing packing) {
        return new PackingDto(packing);
    }

    public static final List<PackingDto> REFACTOR(List<Packing> packingList) {
        List<PackingDto> dto = new ArrayList<>();
        for (Packing packing : packingList) {
            dto.add(REFACTOR(packing));
        }
        return dto;
    }
}
