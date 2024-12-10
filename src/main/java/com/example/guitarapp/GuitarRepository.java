package com.example.guitarapp;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GuitarRepository extends JpaRepository<Guitar, Long> {
}