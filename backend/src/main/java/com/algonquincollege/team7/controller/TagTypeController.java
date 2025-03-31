package com.algonquincollege.team7.controller;

import com.algonquincollege.team7.dto.GeneralResponse;
import com.algonquincollege.team7.dto.TagTypeRequest;
import com.algonquincollege.team7.service.TagTypeService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/tag_type")
@CrossOrigin(origins = "http://localhost:8080")
public class TagTypeController {

    @Autowired
    private TagTypeService tagTypeService;

    @PostMapping
    public ResponseEntity registerTagType(@RequestBody @Valid TagTypeRequest data) {
        tagTypeService.registerTagType(data);

        var responseOk = new GeneralResponse("Tag type registered successfully");
        return ResponseEntity.ok(responseOk);
    }

    @Transactional
    @PutMapping
    public ResponseEntity editTagType(@RequestBody @Valid TagTypeRequest data) {

        tagTypeService.editTagType(data);
        var responseOk = new GeneralResponse("Tag type edited successfully");
        return ResponseEntity.ok(responseOk);
    }
}
