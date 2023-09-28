package com.example.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.qos.logback.core.model.Model;

public interface LoginRepository extends JpaRepository<Model, Integer> {

}
