package io.github.Guimaraes131.logistics_api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "tb_product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;
    private String description;
    private Double weight;
    private Integer quantity;

    @ManyToOne
    private Delivery delivery;
}
