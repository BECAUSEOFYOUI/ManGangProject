package com.qfedu.service.impl;

import com.qfedu.entity.Goods;
import com.qfedu.mapper.GoodsTypeMapper;
import com.qfedu.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodTypeServiceImpl implements GoodsTypeService {
    @Autowired
    GoodsTypeMapper goodsTypeMapper;
    public List<Goods> selectByGoodsTypeId(int id) {
        return goodsTypeMapper.selectByGoodsTypeId(id);
    }

    public List<Goods> selectByHotGoodsId() {
        return goodsTypeMapper.selectByHotGoodsId();
    }

    public List<Goods> selectBrandNewGoods() {
        List<Goods> goodsList = goodsTypeMapper.selectBrandNewGoods();
        return goodsList;
    }
}
