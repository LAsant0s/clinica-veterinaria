package com.assis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assis.domain.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Integer> {

}
