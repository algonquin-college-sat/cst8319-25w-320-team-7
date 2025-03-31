package com.algonquincollege.team7.controller;

import com.algonquincollege.team7.dto.GeneralResponse;
import com.algonquincollege.team7.dto.TagListResponse;
import com.algonquincollege.team7.dto.TagValueRequest;
import com.algonquincollege.team7.service.TagValueService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/tag_value")
@CrossOrigin(origins = "http://localhost:8080")
public class TagValueController {

    @Autowired
    private TagValueService tagValueService;

    @PostMapping
    public ResponseEntity registerTagValue(@RequestBody @Valid TagValueRequest data) {
        tagValueService.registerTagValue(data);

        var responseOk = new GeneralResponse("Tag value registered successfully");
        return ResponseEntity.ok(responseOk);
    }

    @Transactional
    @PutMapping
    public ResponseEntity editTagValue(@RequestBody @Valid TagValueRequest data) {

        tagValueService.editTagValue(data);
        var responseOk = new GeneralResponse("Tag Value edited successfully");
        return ResponseEntity.ok(responseOk);
    }

    @GetMapping
    public List<TagListResponse> getTagList() {
        return tagValueService.getTagList();
    }
}
