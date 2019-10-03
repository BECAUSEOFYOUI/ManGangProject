package com.qfedu.controller;

import com.qfedu.entity.*;
import com.qfedu.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;
@Controller
@RequestMapping("/beforeGoods")

@Api(value = "前端商品展示",tags = "类型的选择：比如穿搭,精选,分类")
public class BeforeGoodsController {
    @Autowired
    GoodsService goodsService;
    @Autowired
    GoodsTypeService goodsTypeService ;
    @Autowired
    StyleService styleService;
    @Autowired
    DesignerService designerService ;
    @Autowired
    CollocationService collocationService;
    @RequestMapping(value = "/listHomePage",method = RequestMethod.POST)

    @ResponseBody
    @ApiOperation(value = "首页面展示窗口,查询设计者,浏览最高的搭配",notes = "后台传值（designerList)(collocation)",httpMethod = "POST")
    public String listHomePage(Model model){
        List<Designer> designerList = designerService.seletAllDesigner();
        model.addAttribute("designerList",designerList);
        //查询阅读最高的搭配
        Collocation collocation = collocationService.selectCollocation();
        model.addAttribute("collocation",collocation);
        return "before/shouye";
    }
    //查询点击首页设计者

   @RequestMapping(value = "/listDesigner",method = RequestMethod.POST)
   @ResponseBody
   @ApiOperation(value = "该方法是查询设计者",notes = "通过id查询（需要一个隐藏的id）",httpMethod = "POST")
   @ApiImplicitParams({
           @ApiImplicitParam(name = "id",value = "id",required = true,dataType = "Integer"),

   })
    public String listDesigner(Integer id){
        Designer designer = designerService.selectDesignerById(id);

        return"";
   }
   //从首页点击穿搭
    @RequestMapping(value = "/listWireAndRide",method = RequestMethod.POST)
    @ApiOperation(value = "该方法通过首页按钮穿搭页面展示内容",notes = "后台传值()",httpMethod = "POST")

    public String listWireAndRide(){
        //通过阅读量多少查询所有穿搭类型
        return "";
    }
   //通过最底部精选

    @RequestMapping(value = "/listChoiceNess",method = RequestMethod.POST)
    @ApiOperation(value = "该方法通过首页底部精选按钮，需要在精选页面展示内容",notes = "后台传值()",httpMethod = "POST")
    public String listChoiceNess(){

        return "before/jingxuan";
    }
    //精选中搭配展示
    @RequestMapping(value = "/listCollocation",method = RequestMethod.POST)
    @ApiOperation(value = "该方法是精选中搭配",notes = "后台传值()",httpMethod = "POST")
    public String listCollocation(){
        Style style = styleService.selectAllStyle();


        return "before/dapei";
    }
    @RequestMapping(value = "listStyle",method = RequestMethod.POST)
    public String listStyle(Integer id, Model model){
        /*Style style = styleService.selectStyleById(id);
        List<>

        *//*List<GoodsType> goodsTypeList = goodsTypeService.selectByStyleId(id);*//*

            List<Goods> goodsList = goodsService.selectGoodsByStyleId(style.getId());
*/


        return "";
    }
    //精选中的热销
    @RequestMapping(value = "/listHotSelling",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "该方法是热销展示",notes = "通过付款人数多少(hotGoodList)",httpMethod = "POST")

    public String listHotSelling(Model model){
        List<Goods> hotGoodsList = goodsService.selectHotSellingGoods();
        model.addAttribute("hGoodsList",hotGoodsList);

        return "before/rexiao";
    }
}
