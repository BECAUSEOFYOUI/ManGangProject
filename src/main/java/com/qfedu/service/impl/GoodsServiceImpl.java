package com.qfedu.service.impl;

import com.qfedu.entity.Goods;
import com.qfedu.mapper.GoodsMapper;
import com.qfedu.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    GoodsMapper goodsMapper;
    public List<Goods> selectHotSellingGoods() {
        return null;
    }

    public List<Goods> selectGoodsByStyleId(Integer id) {
        List<Goods> goodsList = goodsMapper.selectGoodsByStyleId(id);
        return goodsList;
    }
}
