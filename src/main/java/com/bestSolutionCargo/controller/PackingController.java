package com.bestSolutionCargo.controller;

import com.itextpdf.text.DocumentException;
import com.bestSolutionCargo.config.Constants;
import com.bestSolutionCargo.dto.PackingDto;
import com.bestSolutionCargo.models.Packing;
import com.bestSolutionCargo.serviceImpl.PackingServiceImpl;
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
@RequestMapping(Constants.BasePath + Constants.PackagePath + Constants.PackingPath)
public class PackingController {


    @Autowired
    PackingServiceImpl service;

    @Operation(summary ="Create Packing")
    @PostMapping("")
    public ResponseEntity<PackingDto> createPacking(
            @RequestBody PackingDto dto) {
        return new ResponseEntity<>(
                Packing.REFACTOR(service.createPacking(dto)),
                HttpStatus.OK);

    }

    @Operation(summary = "Fetch all Packings")
    @GetMapping()
    public List<PackingDto> getPackings() {
        return Packing.REFACTOR(service.getPackings());
    }

    @Operation(summary = "Fetch Packing By Id")
    @GetMapping("/{id}")
    public PackingDto getPacking(@PathVariable("id") String id) {
        return Packing.REFACTOR(service.getPacking(id));
    }

    @Operation(summary = "Fetch Packing By Id")
    @GetMapping("/Details/{id}")
    public ResponseEntity<PackingDto> getDetailedPacking(
            @PathVariable("id") String id) {
        return new ResponseEntity<>(
                Packing.REFACTOR(service.getPacking(id)),
                HttpStatus.OK);

    }

    @Operation(summary = "Update Packing")
    @PutMapping("")
    public ResponseEntity<PackingDto> updatePacking(
            @RequestBody PackingDto dto) {
        return new ResponseEntity<>(Packing.REFACTOR(
                service.updatePacking(dto)), HttpStatus.OK);
    }

    @Operation(summary = "Delete Packing by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePacking(@PathVariable("id") String id) {
        service.deletePacking(id);
        return new ResponseEntity<>("Packing Deleted", HttpStatus.OK);
    }

    @GetMapping(value = "/report",
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> packingReport() throws DocumentException, MalformedURLException, IOException {
        List<Packing> packingList = (List<Packing>) service.getPackings();

        ByteArrayInputStream bis = PDFGenerator.packingListPDFReport(packingList);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=customers.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }

}
