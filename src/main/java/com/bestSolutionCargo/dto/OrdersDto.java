package com.bestSolutionCargo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.bestSolutionCargo.models.Orders;
import lombok.Data;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class OrdersDto {
    private String id, description, createdBy, updatedBy, serialNumber, partNumber,status, remarks;
    private Integer quantity;
    private Date creationTime, updateTime;

    public OrdersDto(){

    }

    public OrdersDto(String id, String description, String createdBy, String updatedBy, String serialNumber, String partNumber, String remarks, Integer quantity, Date creationTime, Date updateTime) {
        this.id = id;
        this.description = description;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
        this.serialNumber = serialNumber;
        this.partNumber = partNumber;
        this.remarks = remarks;
        this.quantity = quantity;
        this.creationTime = creationTime;
        this.updateTime = updateTime;
    }

    public OrdersDto(Orders orders) {
        this.id = orders.getId();
        this.description = orders.getDescription();
        this.createdBy = orders.getCreatedBy();
        this.updatedBy = orders.getUpdatedBy();
        this.serialNumber=orders.getSerialNumber();
        this.partNumber=orders.getPartNumber();
        this.remarks=orders.getRemarks();
        this.quantity = orders.getQuantity();
        this.creationTime = orders.getCreationTime();
        this.updateTime = orders.getUpdateTime();
        this.status = orders.getStatus();

    }

}
