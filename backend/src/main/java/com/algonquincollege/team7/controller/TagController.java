package com.algonquincollege.team7.controller;

import com.algonquincollege.team7.dto.GeneralResponse;
import com.algonquincollege.team7.dto.TagRequest;
import com.algonquincollege.team7.service.TagService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/project/tag")
@CrossOrigin(origins = "http://localhost:8080")
public class TagController {

    @Autowired
    private TagService tagService;

    @PostMapping
    public ResponseEntity registerTag(@RequestBody @Valid TagRequest data) {
        tagService.registerTag(data);

        var responseOk = new GeneralResponse("Tag registered successfully");
        return ResponseEntity.ok(responseOk);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GeneralResponse> deleteTag(@PathVariable Long id) {
        tagService.deleteTag(id);

        var responseOk = new GeneralResponse("Tag deleted successfully");
        return ResponseEntity.ok(responseOk);
    }
}
