package com.qfedu.controller;

import com.qfedu.entity.*;
import com.qfedu.service.*;
import com.qfedu.util.InfoUtils;
import com.qfedu.util.JsonUtils;
import com.qfedu.util.TimeFormatUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@Controller
@RequestMapping("/beforeGoods")
@CrossOrigin(value = "*",maxAge = 3600)
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
    @RequestMapping(value = "/listHomePage",method = RequestMethod.GET)


    @ApiOperation(value = "首页面展示窗口,查询设计者,浏览最高的搭配",notes = "后台传值（designerList)(collocation)",httpMethod = "GET")
    public String listHomePage(Model model){
        List<Designer> designerList = designerService.selectAllDesigner();

        for (Designer designer1 : designerList) {
            designer1.setDesignerImg(InfoUtils.getProperties("IMG_URL") +designer1.getDesignerImg());
        }
        for (Designer designer : designerList) {
            System.out.println("设计师图片"+designer.getDesignerImg());
        }
        model.addAttribute("designerList",designerList);
        List<Collocation> collocationList = collocationService.selectCollocationList();
        for (Collocation collocation : collocationList) {
            collocation.setCollocationImg(InfoUtils.getProperties("IMG_URL")+collocation.getCollocationImg());
        }
        model.addAttribute("collocationList",collocationList);

        return "before/shouye";
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
   /* @RequestMapping(value = "listStyle",method = RequestMethod.POST)
    public String listStyle(Integer id, Model model){
        Style style = styleService.selectStyleById(id);
        List<>

        List<GoodsType> goodsTypeList = goodsTypeService.selectByStyleId(id);

            List<Goods> goodsList = goodsService.selectGoodsByStyleId(style.getId());
        return "";
    }*/
    //精选中的热销
    @RequestMapping(value = "/listHotSelling",method = RequestMethod.POST)

    @ApiOperation(value = "该方法是热销展示",notes = "通过付款人数多少(hotGoodList)",httpMethod = "POST")
    public String listHotSelling(Model model){
        List<Goods> hotGoodsList = goodsService.selectHotSellingGoods();
        model.addAttribute("hGoodsList",hotGoodsList);

        return "before/rexiao";
    }

    /*zuli*/
    @RequestMapping(value = "/classiFication",method = RequestMethod.GET)
    @ApiOperation(value = "该方法通过首页分类A标签跳转至此",notes = "获取后台数据传输至前端页面",httpMethod = "POST")
    public String classiFication(){

        return "before/fenlie";
    }
    @RequestMapping(value = "/classiFicationId",method = RequestMethod.GET)
    //分类页面上1-7ID分别对应各个商品的类型
    //id=10展示的是热门标签对应的商品
    public void classiFication(int id, HttpServletResponse response) {
        GoodsType goodsType = new GoodsType();
        goodsType.setId(id);
        if (id == 0) {
            //热门方法
            List<Goods> goodsList = goodsTypeService.selectByHotGoodsId();
            try {
                response.setContentType("application/json;charset=utf-8");
                response.getWriter().write(JsonUtils.objectToJson(goodsList));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            List<Goods> goodsList = goodsTypeService.selectByGoodsTypeId(goodsType.getId());
            try {

                response.setContentType("application/json;charset=utf-8");
                response.getWriter().write(JsonUtils.objectToJson(goodsList));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @RequestMapping("/topNew")
    public String topNew(){
        return "before/shangxin";
    }
    @RequestMapping("/topNewData")
    public void topNewData(HttpServletResponse response){
        List<Goods> goodsList = goodsTypeService.selectBrandNewGoods();
        response.setContentType("application/json;charset=utf-8");
        try {
            response.getWriter().write(JsonUtils.objectToJson(goodsList));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //分类品牌展示
    @RequestMapping("styleList")
    public void styleList(Integer id,HttpServletResponse response){
       List<Goods> goodsList =  goodsService.selectGoodsByStyleId(id);

    }
}
