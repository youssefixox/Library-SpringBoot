package com.example.demo.repository;

import com.example.demo.entity.Emprunt;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmpruntRepository extends JpaRepository<Emprunt, Integer> {
}
