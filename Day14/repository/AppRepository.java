package com.example.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.app.model.App;

public interface AppRepository extends JpaRepository<App,Long> {
}