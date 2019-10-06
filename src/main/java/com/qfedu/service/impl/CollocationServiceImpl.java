package com.qfedu.service.impl;

import com.qfedu.entity.Collocation;
import com.qfedu.mapper.CollocationMapper;
import com.qfedu.service.CollocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollocationServiceImpl implements CollocationService {
    @Autowired
    CollocationMapper collocationMap;

    public List<Collocation> selectCollocationList() {
        List<Collocation> collocationList =collocationMap.selectCollocationMax();
        return collocationList;
    }

    public Collocation selectCollocationById(Integer id) {
       Collocation collocation =  collocationMap.selectCollocationById(id);
        return collocation;
    }

    public List<Collocation> selectCollocationAll() {
        List<Collocation> collocationList = collocationMap.selectCollocationAll();
        return collocationList;
    }
}
