package com.murilojavasolucoes.smartestoque.common.core;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public abstract class DefaultController<MODEL, ID, DTO> {

  private DefaultService<MODEL, ID> service;

  public DefaultController(DefaultService<MODEL, ID> service) {
    this.service = service;
  }

  @GetMapping
  public ResponseEntity<Page<MODEL>> getAll(
      @PageableDefault(page = 0, size = 10, sort = "id", direction = Direction.ASC) Pageable pageable) {
    return ResponseEntity.status(HttpStatus.OK).body(this.service.findAll(pageable));
  }

  @PostMapping
  public ResponseEntity<Object> save(@RequestBody DTO dto) {
    var model = buildModel(dto);
    return ResponseEntity.status(HttpStatus.CREATED).body(service.save(model));
  }

  @GetMapping("/{id}")
  public ResponseEntity<Object> getOneParkingSpot(@PathVariable(value = "id") ID id) {
    Optional<MODEL> modelOptional = service.findById(id);
    if (!modelOptional.isPresent()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entity not found.");
    }
    return ResponseEntity.status(HttpStatus.OK).body(modelOptional.get());
  }

  @PutMapping("/{id}")
  public ResponseEntity<Object> updateParkingSpot(@PathVariable(value = "id") ID id,
      @RequestBody DTO dto) {
    Optional<MODEL> modelOptional = service.findById(id);
    if (modelOptional.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entity not found.");
    }
    MODEL model = modelOptional.get();
    BeanUtils.copyProperties(model, dto);
    return ResponseEntity.status(HttpStatus.OK).body(service.save(model));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Object> delete(@PathVariable(value = "id") ID id) {
    Optional<MODEL> modelOptional = service.findById(id);
    if (modelOptional.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entity not found.");
    }
    service.delete(modelOptional.get());
    return ResponseEntity.status(HttpStatus.OK).body("Entity deleted.");
  }

  public MODEL buildModel(DTO dto) {
    MODEL model = createModel();
    BeanUtils.copyProperties(dto, model);
    return model;
  }

  public abstract MODEL createModel();
}
