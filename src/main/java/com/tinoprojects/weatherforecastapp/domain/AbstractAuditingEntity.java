package com.tinoprojects.weatherforecastapp.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public abstract class AbstractAuditingEntity {
    private String createdBy;
    private LocalDateTime createdDate;
    private String lastModifiedBy;
    private LocalDateTime lastModifiedDate;
}
