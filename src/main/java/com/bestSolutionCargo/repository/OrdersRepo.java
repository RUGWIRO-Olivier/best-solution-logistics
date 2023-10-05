package com.bestSolutionCargo.repository;

import com.bestSolutionCargo.models.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrdersRepo extends JpaRepository<Orders,String> {

    @Query(value ="SELECT * from Orders WHERE status='Pending'", nativeQuery = true)
    List<Orders> getPendingOrders();
}
