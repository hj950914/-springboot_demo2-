package com.hj.service.impl;

import com.hj.entity.Picture;
import com.hj.mapper.PictureMapper;
import com.hj.service.PictureService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

/**
 * Author: hj
 * Date: 2019-05-16 16:41
 * Description: <描述>
 */
@Service
public class PictureServiceImpl implements PictureService {

    @Resource
    private PictureMapper pictureMapper;

    @Override
    public void addPtoto(String path) {
        Picture picture = new Picture();
        //读取本地图片加入数据库
        // /Users/huangjie/Desktop/pictures/test1.jpg
        try {
            FileInputStream fis = new FileInputStream(path);
            BufferedInputStream bis = new BufferedInputStream(fis);
            byte[] b = new byte[fis.available()];
            bis.read(b);
            picture.setPic(b);
            picture.setDescription("本地图片测试");
            pictureMapper.insertPtoto(picture);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    public List<Picture> getAllPhoto() {
        return pictureMapper.selectAllPhoto();
    }
}
