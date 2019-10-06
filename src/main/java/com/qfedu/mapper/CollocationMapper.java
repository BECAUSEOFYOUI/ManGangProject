package com.qfedu.mapper;

import com.qfedu.entity.Collocation;

import java.util.List;

public interface CollocationMapper {
    List<Collocation> selectCollocationMax();

    Collocation selectCollocationById(Integer id);

    List<Collocation> selectCollocationAll();
}
