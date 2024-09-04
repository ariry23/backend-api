package com.backend.api.service;

import org.springframework.stereotype.Service;

@Service
public abstract class BasePageService {
    public abstract int getTotalPages();
}
