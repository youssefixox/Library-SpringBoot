package com.example.demo.repository;

import com.example.demo.entity.Dict;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DictRepository extends JpaRepository<Dict, Integer> {
}
