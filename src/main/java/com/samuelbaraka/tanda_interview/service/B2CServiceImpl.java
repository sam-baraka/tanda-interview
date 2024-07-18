package com.samuelbaraka.tanda_interview.service;

import com.samuelbaraka.tanda_interview.model.B2CRequest;
import com.samuelbaraka.tanda_interview.repository.B2CRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class B2CServiceImpl implements B2CService {

    @Autowired
    private B2CRequestRepository repository;

    @Override
    public B2CRequest createB2CRequest(B2CRequest request) {
        request.setCreatedAt(LocalDateTime.now());
        request.setStatus("PENDING");
        return repository.save(request);
    }

    @Override
    public B2CRequest getB2CRequest(String id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("B2C request not found"));
    }

    @Override
    public B2CRequest updateB2CRequest(String id, String status) {
        B2CRequest request = getB2CRequest(id);
        request.setStatus(status);
        request.setUpdatedAt(LocalDateTime.now());
        return repository.save(request);
    }
}