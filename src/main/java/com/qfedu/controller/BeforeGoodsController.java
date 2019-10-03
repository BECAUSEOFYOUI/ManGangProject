package com.qfedu.controller;

import com.qfedu.entity.Designer;
import com.qfedu.entity.Goods;
import com.qfedu.entity.GoodsType;
import com.qfedu.entity.Style;
import com.qfedu.service.DesignerService;
import com.qfedu.service.GoodsService;
import com.qfedu.service.GoodsTypeService;
import com.qfedu.service.StyleService;
import com.qfedu.service.impl.DesignerServiceImpl;
import com.qfedu.service.impl.GoodTypeServiceImpl;
import com.qfedu.service.impl.GoodsServiceImpl;
import com.qfedu.service.impl.StyleServiceImpl;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;

@RequestMapping("/beforeGoods")
public class BeforeGoodsController {

    GoodsService goodsService = new GoodsServiceImpl();
    GoodsTypeService goodsTypeService = new GoodTypeServiceImpl();
    StyleService styleService = new StyleServiceImpl();
    DesignerService designerService = new DesignerServiceImpl();

    @RequestMapping("/listHomePage")
    public String listHomePage(){
        List<Designer> designerList = designerService.seletAllDesigner();
        return "before/shouye";
    }
    //查询首页设计者
   @RequestMapping("/listDesigner")
    public String listDesigner(Integer id){
        Designer designer = designerService.selectDesignerById(id);

        return"";
   }
   //通过最底部精选
    @RequestMapping("/listChoiceNess")
    public String listChoiceNess(){

        return "before/jingxuan";
    }
    //精选中搭配展示
    @RequestMapping("/listCollocation")
    public String listCollocation(){
        Style style = styleService.selectAllStyle();


        return "before/dapei";
    }
    @RequestMapping("listStyle")
    public String listStyle(Integer id, Model model){
        /*Style style = styleService.selectStyleById(id);
        List<>

        *//*List<GoodsType> goodsTypeList = goodsTypeService.selectByStyleId(id);*//*

            List<Goods> goodsList = goodsService.selectGoodsByStyleId(style.getId());
*/


        return "";
    }
    //精选中的热销
    public String listHotSelling(Model model){
        List<Goods> hotGoodsList = goodsService.selectHotSellingGoods();
        model.addAttribute("hGoodsList",hotGoodsList);

        return "before/rexiao";
    }
}
