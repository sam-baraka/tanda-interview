package com.samuelbaraka.tanda_interview.model;
import lombok.Data;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Setter
@Document(collection = "b2c_requests")
public class B2CRequest {
    @Id
    private String id;
    private String phoneNumber;
    private BigDecimal amount;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}