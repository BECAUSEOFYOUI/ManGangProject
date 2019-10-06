package com.qfedu.service;

import com.qfedu.entity.Goods;

import java.util.List;

public interface GoodsTypeService {

    List<Goods> selectByGoodsTypeId(int id);

    List<Goods> selectByHotGoodsId();

    List<Goods> selectBrandNewGoods();
}
