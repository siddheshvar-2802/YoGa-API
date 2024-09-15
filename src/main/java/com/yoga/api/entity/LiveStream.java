package com.yoga.api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "stream")
public class LiveStream {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int liveStreamId;
    private int streamId;
    private String streamUrl;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
//    private Subscription subscriptionId;

    private Boolean isActive;
    private LocalDateTime createdOn;
    private String createdBy;
    private LocalDateTime updatedOn;
    private String updatedBy;
}
