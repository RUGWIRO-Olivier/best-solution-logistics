package com.bestSolutionCargo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.bestSolutionCargo.models.SpareParts;
import lombok.Data;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class SparePartsDto {
    private String id,name, serialNumber, partNumber, description, doq, observation, createdBy, updatedBy;
    private Integer quantity;
    private Date creationTime, updateTime;

    public SparePartsDto(){}

    public SparePartsDto(String id, String name, String serialNumber, String partNumber, String description, String doq, String observation, String createdBy, String updatedBy, Integer quantity, Date creationTime, Date updateTime ) {
        this.id = id;
        this.name = name;
        this.serialNumber = serialNumber;
        this.partNumber = partNumber;
        this.description = description;
        this.doq = doq;
        this.observation = observation;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
        this.quantity = quantity;
        this.creationTime=creationTime;
        this.updateTime=updateTime;
    }

    public SparePartsDto(SpareParts spareParts) {
        this.id = spareParts.getId();
        this.name = spareParts.getName();
        this.serialNumber = spareParts.getSerialNumber();
        this.partNumber = spareParts.getPartNumber();
        this.description = spareParts.getDescription();
        this.doq = spareParts.getDoq();
        this.observation = spareParts.getObservation();
        this.createdBy = spareParts.getCreatedBy();
        this.updatedBy=spareParts.getUpdatedBy();
        this.quantity = spareParts.getQuantity();
        this.creationTime=spareParts.getCreationTime();
        this.updateTime=spareParts.getUpdateTime();
    }
}
