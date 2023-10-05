package com.bestSolutionCargo.controller;

import com.itextpdf.text.DocumentException;
import com.bestSolutionCargo.dto.SparePartsDto;
import com.bestSolutionCargo.models.SpareParts;
import com.bestSolutionCargo.serviceImpl.SparePartsServiceImpl;
import com.bestSolutionCargo.config.Constants;
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
@RequestMapping(Constants.BasePath + Constants.PackagePath + Constants.SparePartsPath)
public class SparePartsController {

    @Autowired
    SparePartsServiceImpl service;

    @Operation(summary ="Create Spare Part")
    @PostMapping("")
    public ResponseEntity<SparePartsDto> createSparePart(
            @RequestBody SparePartsDto dto) {
        return new ResponseEntity<>(
                SpareParts.REFACTOR(service.createSparePart(dto)),
                HttpStatus.OK);

    }

    @Operation(summary = "Fetch all Spare Parts")
    @GetMapping()
    public List<SparePartsDto> getSpareParts() {
        return SpareParts.REFACTOR(service.getSpareParts());
    }

    @Operation(summary = "Fetch Spare Part By Id")
    @GetMapping("/{id}")
    public SparePartsDto getSparePart(@PathVariable("id") String id) { // String auth = JwtTokenUtil.getUserIdFromToken(accessToken);
        return SpareParts.REFACTOR(service.getSparePart(id));
    }

    @Operation(summary = "Fetch Spare Part By Id")
    @GetMapping("/Details/{id}")
    public ResponseEntity<SparePartsDto> getDetailedSparePart(
            @PathVariable("id") String id) {
        return new ResponseEntity<>(
                SpareParts.REFACTOR(service.getSparePart(id)),
                HttpStatus.OK);

    }

    @Operation(summary = "Update Spare Part")
    @PutMapping("")
    public ResponseEntity<SparePartsDto> updateSparePart(
            @RequestBody SparePartsDto dto) {
        return new ResponseEntity<>(SpareParts.REFACTOR(
                service.updateSparePart(dto)), HttpStatus.OK);
    }

    @Operation(summary = "Delete a Spare Part by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSpareParts(@PathVariable("id") String id) {
        service.deleteSparePart(id);
        return new ResponseEntity<>("Spare Part Deleted", HttpStatus.OK);
    }

    @GetMapping(value = "/report",
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> sparePartsReport() throws DocumentException, MalformedURLException, IOException  {
        List<SpareParts> sparePartsList = (List<SpareParts>) service.getSpareParts();

        ByteArrayInputStream bis = PDFGenerator.sparePartsPDFReport(sparePartsList);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=customers.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }

}
