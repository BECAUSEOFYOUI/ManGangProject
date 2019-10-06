package com.qfedu.service;

import com.qfedu.entity.Collocation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CollocationService {


    List<Collocation> selectCollocationList();

    Collocation selectCollocationById(Integer id);

    List<Collocation> selectCollocationAll();
}
