package com.qfedu.controller;

import com.qfedu.entity.Designer;
import com.qfedu.service.DesignerService;
import com.qfedu.util.JsonUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Controller
@RequestMapping("/beforeDesigner")
@CrossOrigin(value = "*",maxAge = 3600)
public class BeforeDesignController {

    @Autowired
    DesignerService designerService ;




    //查询点击首页设计者

    @RequestMapping(value = "/listDesigner",method = RequestMethod.GET)

    @ApiOperation(value = "该方法是查询设计者",notes = "通过id查询（需要一个隐藏的id）",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "id",required = true,dataType = "Integer"),

    })
    public void listDesigner(Integer id, HttpServletResponse response){
        Designer designer = designerService.selectDesignerById(id);

        try {
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(JsonUtils.objectToJson(designer));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
