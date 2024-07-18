package com.samuelbaraka.tanda_interview.repository;

import com.samuelbaraka.tanda_interview.model.B2CRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface B2CRequestRepository extends MongoRepository<B2CRequest, String> {
}