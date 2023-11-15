package com.example.lab4.Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "tea")
public class Tea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer price;

    @Override
    public String toString() {
        return "Tea{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", price=" + price +
            '}';
    }
}
