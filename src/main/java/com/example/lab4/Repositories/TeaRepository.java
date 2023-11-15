package com.example.lab4.Repositories;

import com.example.lab4.Models.Tea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeaRepository extends JpaRepository<Tea, Long> {
}
