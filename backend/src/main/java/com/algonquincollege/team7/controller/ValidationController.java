package com.algonquincollege.team7.controller;

import com.algonquincollege.team7.dto.GeneralResponse;
import com.algonquincollege.team7.dto.ValidationRequest;
import com.algonquincollege.team7.service.ValidationService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/project/validation")
@CrossOrigin(origins = "http://localhost:8080")
public class ValidationController {

    @Autowired
    private ValidationService validationService;

    @PostMapping
    public ResponseEntity registerValidation(@RequestBody @Valid ValidationRequest data) {
        validationService.registerValidation(data);

        var responseOk = new GeneralResponse("Validation registered successfully");
        return ResponseEntity.ok(responseOk);
    }

    @Transactional
    @PutMapping
    public ResponseEntity editValidation(@RequestBody @Valid ValidationRequest data) {

        validationService.editValidation(data);
        var responseOk = new GeneralResponse("Validation edited successfully");
        return ResponseEntity.ok(responseOk);
    }
}
