package com.qfedu.mapper;

import com.qfedu.entity.Goods;
import com.qfedu.entity.User;

import java.util.List;

public interface GoodsTypeMapper {

    List<Goods> selectByGoodsTypeId(int id);

    List<Goods> selectByHotGoodsId();

    List<Goods> selectBrandNewGoods();
}
