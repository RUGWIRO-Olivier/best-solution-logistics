package com.bestSolutionCargo.service;

import com.bestSolutionCargo.dto.OrdersDto;
import com.bestSolutionCargo.models.Orders;

import java.util.List;

public interface OrdersService {
    Orders createOrder(OrdersDto dto);
    List<Orders> getOrders();
    List<Orders> getPendingOrders();
    Orders getOrder(String id);
    Orders updateOrder(OrdersDto dto);
    void deleteOrder(String id);
}
