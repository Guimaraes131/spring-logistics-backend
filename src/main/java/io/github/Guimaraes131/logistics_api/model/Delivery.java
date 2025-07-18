package io.github.Guimaraes131.logistics_api.model;

import io.github.Guimaraes131.logistics_api.model.enums.Status;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "tb_delivery")
@EntityListeners(AuditingEntityListener.class)
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "tracking_code")
    private String trackingCode;

    @Enumerated(EnumType.STRING)
    private Status status;

    @CreatedDate
    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @Column(name = "delivery_date")
    private LocalDateTime deliveryDate;

    @ManyToOne
    private Recipient recipient;

    @OneToMany(mappedBy = "delivery")
    private List<Product> products;
}
