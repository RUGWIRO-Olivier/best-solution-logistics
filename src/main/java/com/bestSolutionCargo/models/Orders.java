package com.bestSolutionCargo.models;

import com.bestSolutionCargo.dto.OrdersDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Orders extends BaseEntity{

    private String description, serialNumber, partNumber, remarks, status="Pending";
    private Integer quantity;

    public Orders(String id, String createdBy, String description, String serialNumber, String partNumber, String remarks, String status, Integer quantity) {
        super(id, createdBy);
        this.description = description;
        this.serialNumber = serialNumber;
        this.partNumber = partNumber;
        this.remarks = remarks;
        this.status = status;
        this.quantity = quantity;
    }

    public  static final OrdersDto REFACTOR(Orders orders) {
        return new OrdersDto(orders);
    }

    public static final List<OrdersDto> REFACTOR(List<Orders> ordersList) {
        List<OrdersDto> dto = new ArrayList<>();
        for (Orders orders : ordersList) {
            dto.add(REFACTOR(orders));
        }
        return dto;
    }

}
