package com.hj.controller;

import com.hj.entity.PictureBest;
import com.hj.service.PictureBestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * Author: hj
 * Date: 2019-05-17 16:41
 * Description: <描述>
 */
@Controller
public class PictureBestController {

    @Autowired
    private PictureBestService pictureBestService;


    /**
     * 获取数据库里面的图片
     *
     * @param model
     * @return
     */
    @GetMapping("/love")
    public String test1(Model model) {
        List<PictureBest> allPhotoPath = pictureBestService.getAllPhotoPath();
        model.addAttribute("allPhotoPath", allPhotoPath);
        System.out.println("*********************PictureBestController**************");
        return "index2";
    }

    /**
     * 进入图片上传页面
     */
    @RequestMapping("/add")
    public String test2(@RequestParam("file") MultipartFile[] files) {
        if (files[0] != null) {
            try {
                byte[] bytes = files[0].getBytes();
                pictureBestService.addPtotoPath(bytes, files[0].getOriginalFilename());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "success";
    }

    /**
     * 图片提交
     */
    @RequestMapping("/enter")
    public String test2() {
        return "success";
    }

}
