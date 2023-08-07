package com.tinoprojects.weatherforecastapp.service;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public abstract class AbstractAuditingEntity {
    private String createdBy;
    private LocalDateTime createdDate;
    private String lastModifiedBy;
    private LocalDateTime lastModifiedDate;
}
