package com.murilojavasolucoes.smartestoque.common.core;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public class DefaultService<MODEL, ID> {

  private JpaRepository<MODEL, ID> repository;

  public DefaultService(JpaRepository<MODEL, ID> repository) {
    this.repository = repository;
  }

  @Transactional
  public MODEL save(MODEL parkingSpotModel) {
    return repository.save(parkingSpotModel);
  }

  public Page<MODEL> findAll(Pageable pageable) {
    return repository.findAll(pageable);
  }

  public Optional<MODEL> findById(ID id) {
    return repository.findById(id);
  }

  @Transactional
  public void delete(MODEL model) {
    repository.delete(model);
  }
}
