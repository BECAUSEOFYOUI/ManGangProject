package com.qfedu.mapper;

import com.qfedu.entity.Goods;

import java.util.List;

public interface GoodsMapper {
    List<Goods> selectGoodsByStyleId(Integer id);
}
