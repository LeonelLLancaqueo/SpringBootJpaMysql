package com.example.empresa.repository;

import com.example.empresa.models.Persona;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public interface PersonaRepository extends JpaRepository<Persona, Integer> {




}
