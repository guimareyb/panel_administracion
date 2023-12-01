package com.panel_administracion.controller;

import com.panel_administracion.domain.content.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/content")
public class ContentController {

    @Autowired
    private ContentRepository contentRepository;

    @PostMapping
    public ResponseEntity<DataContentResponse> insertContent(@Valid @RequestBody DataContentInsert dataContentInsert, UriComponentsBuilder uriComponentsBuilder){
        Content content = contentRepository.save(new Content(dataContentInsert));
        DataContentResponse dataContentResponse = new DataContentResponse(content);
        URI url = uriComponentsBuilder.path("/content/{id}").buildAndExpand(content.getId()).toUri();
        return ResponseEntity.created(url).body(dataContentResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataContentResponse> responseDataContent(@PathVariable Long id){
        Content content = contentRepository.getReferenceById(id);
        return ResponseEntity.ok(new DataContentResponse(content));
    }

    @GetMapping
    public ResponseEntity<Page<DataContentResponse>> listContents(@PageableDefault(size = 3, sort = "id")Pageable pageable){
        return ResponseEntity.ok(contentRepository.findByFlagTrue(pageable).map(DataContentResponse::new));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DataContentResponse> updateContent (@RequestBody @Valid DataContentUpdate dataContentUpdate){
        Content content = contentRepository.getReferenceById(dataContentUpdate.id());
        content.updateDataContent((dataContentUpdate));
        DataContentResponse dataContentResponse = new DataContentResponse(content);
        return ResponseEntity.ok(dataContentResponse);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deleteContent(@PathVariable Long id){
        Content content = contentRepository.getReferenceById(id);
        content.deactivateContent();
        return ResponseEntity.noContent().build();
    }


}
