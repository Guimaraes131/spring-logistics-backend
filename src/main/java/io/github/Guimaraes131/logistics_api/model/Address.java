package io.github.Guimaraes131.logistics_api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "tb_address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String street;
    private String number;
    private String complement;
    private String neighbourhood;
    private String city;
    private String state;

    @Column(name = "postal_code")
    private String postalCode;
}
