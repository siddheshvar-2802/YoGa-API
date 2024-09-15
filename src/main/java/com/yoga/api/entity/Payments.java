package com.yoga.api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "payments")
public class Payments {

    @Id
    @Column(name = "paymentId", updatable = false, nullable = false)
    private String paymentId;
    private String paymentType;
    private String status;
    private double amount;
    private String transactionId;

    private Boolean isActive;
    private LocalDateTime createdOn;
    private String createdBy;
    private LocalDateTime updatedOn;
    private String updatedBy;

    @PrePersist
    public void prePersist() {
        if (paymentId == null) {
            paymentId = UUID.randomUUID().toString();
        }
        if (createdOn == null) {
            createdOn = LocalDateTime.now();
        }
    }
}
