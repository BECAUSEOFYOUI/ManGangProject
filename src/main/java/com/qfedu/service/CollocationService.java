package com.qfedu.service;

import com.qfedu.entity.Collocation;
import org.springframework.stereotype.Service;

@Service
public interface CollocationService {

    Collocation selectCollocation();
}
