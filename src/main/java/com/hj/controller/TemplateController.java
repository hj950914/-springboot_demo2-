package com.hj.controller;

import com.hj.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;


/**
 * Author: hj
 * Date: 2019-05-16 13:12
 * Description: <描述>
 */
@Controller
//@RestController方法返回值都返回给浏览器
//@RequestMapping(produces = APPLICATION_JSON_UTF8_VALUE)设置返回给浏览器的数据格式
public class TemplateController {

    @Autowired
    private PictureService pictureService;

    @GetMapping("/index")
    public String test1(Model model) {
        List<String> list = new ArrayList<>();
        //List<Picture> allPhoto = pictureService.getAllPhoto();
        for (int i = 94; i <= 106; i++) {
            String s = "images/lmm" + i + ".jpg";
            list.add(s);
        }
        System.out.println("*******************" + list);
        model.addAttribute("list", list);
        System.out.println("---------------TemplateControllers");
        return "index";
    }

    //测试人员使用
    @GetMapping("/add1")
    public void test2() {
        String path = null;
        int i;//表示从第几张图片开始加入
        int j = 14;//表示加入多少
        for (i = 1; i <= j; i++) {
            path = "/Users/huangjie/Desktop/pictures/lmm" + i + ".jpg";
            pictureService.addPtoto(path);
        }
    }

    //测试人员使用
    @GetMapping("/add2")
    public void test3() {
        pictureService.copyAllPtoto();
    }
}
