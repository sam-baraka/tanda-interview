package com.samuelbaraka.tanda_interview.service;

import com.samuelbaraka.tanda_interview.model.B2CRequest;

public interface B2CService {
    B2CRequest createB2CRequest(B2CRequest request);
    B2CRequest getB2CRequest(String id);
    B2CRequest updateB2CRequest(String id, String status);
}