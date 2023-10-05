package com.bestSolutionCargo.controller;

import com.itextpdf.text.DocumentException;
import com.bestSolutionCargo.config.Constants;
import com.bestSolutionCargo.dto.OrdersDto;
import com.bestSolutionCargo.models.Orders;
import com.bestSolutionCargo.serviceImpl.OrdersServiceImpl;
import com.bestSolutionCargo.util.PDFGenerator;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

@CrossOrigin(Constants.AllowedCrossOrigins)
@RestController
@RequestMapping(Constants.BasePath + Constants.PackagePath + Constants.OrdersPath)
public class OrdersController {


    @Autowired
    OrdersServiceImpl service;

    @Operation(summary ="Create Order")
    @PostMapping("")
    public ResponseEntity<OrdersDto> createOrder(
            @RequestBody OrdersDto dto) {
        return new ResponseEntity<>(
                Orders.REFACTOR(service.createOrder(dto)),
                HttpStatus.OK);

    }

    @Operation(summary = "Fetch all Orders")
    @GetMapping()
    public List<OrdersDto> getOrders() {
        return Orders.REFACTOR(service.getOrders());
    }

    @Operation(summary = "Fetch all Pending Orders")
    @GetMapping("/pending")
    public List<OrdersDto> getPendingOrders() {
        return Orders.REFACTOR(service.getPendingOrders());
    }

    @Operation(summary = "Fetch Order By Id")
    @GetMapping("/{id}")
    public OrdersDto getOrder(@PathVariable("id") String id) {
        return Orders.REFACTOR(service.getOrder(id));
    }

    @Operation(summary = "Fetch Order By Id")
    @GetMapping("/Details/{id}")
    public ResponseEntity<OrdersDto> getDetailedOrder(
            @PathVariable("id") String id) {
        return new ResponseEntity<>(
                Orders.REFACTOR(service.getOrder(id)),
                HttpStatus.OK);

    }

    @Operation(summary = "Update Order")
    @PutMapping("")
    public ResponseEntity<OrdersDto> updateOrder(
            @RequestBody OrdersDto dto) {
        return new ResponseEntity<>(Orders.REFACTOR(
                service.updateOrder(dto)), HttpStatus.OK);
    }

    @Operation(summary = "Delete Order by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable("id") String id) {
        service.deleteOrder(id);
        return new ResponseEntity<>("Order Deleted", HttpStatus.OK);
    }

    @GetMapping(value = "/report",
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> ordersReport() throws DocumentException, MalformedURLException, IOException {
        List<Orders> ordersList = (List<Orders>) service.getOrders();

        ByteArrayInputStream bis = PDFGenerator.ordersPDFReport(ordersList);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=spareparts.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }

    @GetMapping(value = "/pending-report",
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> pendingOrdersReport() throws DocumentException, MalformedURLException, IOException {
        List<Orders> ordersList = (List<Orders>) service.getPendingOrders();

        ByteArrayInputStream bis = PDFGenerator.pendingOrdersPDFReport(ordersList);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=pending-orders.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }


}
