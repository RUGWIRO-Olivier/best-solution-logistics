package com.bestSolutionCargo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.bestSolutionCargo.models.Packing;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
public class PackingDto {
    private String id, serialNumber, partNumber, description, dim, weight, remarks, createdBy, updatedBy;
    private Integer quantity;
    private Date creationTime, updateTime;

    public PackingDto(String id, String serialNumber, String partNumber, String description, String dim, String weight, String remarks, String createdBy, String updatedBy, Integer quantity, Date creationTime, Date updateTime) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.partNumber = partNumber;
        this.description = description;
        this.dim = dim;
        this.weight = weight;
        this.remarks = remarks;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
        this.quantity = quantity;
        this.creationTime = creationTime;
        this.updateTime = updateTime;
    }

    public PackingDto(Packing packing) {
        this.id = packing.getId();
        this.serialNumber = packing.getSerialNumber();
        this.partNumber = packing.getPartNumber();
        this.description = packing.getDescription();
        this.dim = packing.getDim();
        this.weight = packing.getWeight();
        this.remarks = packing.getRemarks();
        this.createdBy = packing.getCreatedBy();
        this.updatedBy = packing.getUpdatedBy();
        this.quantity = packing.getQuantity();
        this.creationTime = packing.getCreationTime();
        this.updateTime = packing.getUpdateTime();
    }

}
