package com.mindex.challenge.controller;

import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.service.CompensationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
public class CompensationController {

    @Autowired
    private CompensationService compensationService;

    @PostMapping(value = "/compensation", consumes = "application/json")
    public ResponseEntity<?> create(
            @Valid
            @RequestBody Compensation newCompensation) throws URISyntaxException {
        newCompensation.setEmployee("987987987");
        newCompensation = compensationService.create(newCompensation);

        HttpHeaders responseHeaders = new HttpHeaders();
        URI newCompensationURI = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newCompensation.getEmployee())
                .toUri();
        responseHeaders.setLocation(newCompensationURI);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @GetMapping(value = "/compensation/{id}", produces = "application/json")
    public ResponseEntity<?> read(@PathVariable String id) {
        Compensation comp = compensationService.read(id);

        return new ResponseEntity<>(comp, HttpStatus.OK);
    }
}
