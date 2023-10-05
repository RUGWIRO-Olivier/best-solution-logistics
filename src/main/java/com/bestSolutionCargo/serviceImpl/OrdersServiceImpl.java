package com.bestSolutionCargo.serviceImpl;

import com.bestSolutionCargo.dto.OrdersDto;
import com.bestSolutionCargo.exceptions.ApiRequestException;
import com.bestSolutionCargo.models.Orders;
import com.bestSolutionCargo.repository.OrdersRepo;
import com.bestSolutionCargo.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {


    @Autowired
    OrdersRepo repo;

    @Override
    public Orders createOrder(OrdersDto dto) {
        if (dto == null)
            throw new ApiRequestException("Orders Object is missing");

        Orders model = new Orders();

        model.setQuantity(dto.getQuantity());
        model.setDescription(dto.getDescription());
        model.setDescription(dto.getDescription());
        model.setCreatedBy(dto.getCreatedBy());
        model.setPartNumber(dto.getPartNumber());
        model.setSerialNumber(dto.getSerialNumber());
        model.setRemarks(dto.getRemarks());

        return repo.save(model);
    }

    @Override
    public List<Orders> getOrders() {
        return repo.findAll();
    }

    @Override
    public List<Orders> getPendingOrders() {
        return repo.getPendingOrders();
    }


    @Override
    public Orders getOrder(String id) {
        Orders orders = repo.findById(id).orElseThrow(
                () -> new ApiRequestException("Order with ID " + id + " is not found"));

        orders.getId();
        return orders;
    }

    @Override
    public Orders updateOrder(OrdersDto dto) {
        Orders model= repo.findById(dto.getId())
                .orElseThrow(() -> new ApiRequestException("Orders with given object is not found"));

        model.setQuantity(dto.getQuantity()==null?model.getQuantity():dto.getQuantity());
        model.setDescription(dto.getDescription()==null?model.getDescription():dto.getDescription());
        model.setCreatedBy(dto.getCreatedBy()==null?model.getCreatedBy():dto.getCreatedBy());
        model.setUpdatedBy(dto.getUpdatedBy()==null?model.getUpdatedBy():dto.getUpdatedBy());
        model.setSerialNumber(dto.getSerialNumber()==null?model.getSerialNumber():dto.getSerialNumber());
        model.setPartNumber(dto.getPartNumber()==null?model.getPartNumber():dto.getPartNumber());
        model.setStatus(dto.getStatus()==null?model.getStatus():dto.getStatus());
        model.setRemarks(dto.getRemarks()==null?model.getRemarks():dto.getRemarks());
        return repo.save(model);
    }

    @Override
    public void deleteOrder(String id) {
        repo.deleteById(id);
    }


}
