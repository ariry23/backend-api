package com.backend.api.service;

import org.springframework.stereotype.Service;

@Service
public abstract class PageServiceTemplate {
    public abstract int getTotalPages();
}
