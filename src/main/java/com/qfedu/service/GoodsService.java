package com.qfedu.service;

import com.qfedu.entity.Goods;

import java.util.List;

public interface GoodsService {
    /**
     * 精选中查询热销商品
     * @return
     */
    List<Goods> selectHotSellingGoods();
}
