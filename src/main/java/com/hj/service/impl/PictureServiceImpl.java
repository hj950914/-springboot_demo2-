package com.hj.service.impl;

import com.hj.entity.Picture;
import com.hj.mapper.PictureMapper;
import com.hj.service.PictureService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.*;
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
        List<Picture> pictures = pictureMapper.selectAllPhoto();
        return pictures;
    }

    /**
     * 此方法只在测试中使用
     */
    @Override
    public void copyAllPtoto() {
        List<Picture> pictures = pictureMapper.selectAllPhoto();
        //将图片继续存储到项目路径下
        for (int i = 0; i < pictures.size(); i++) {
            try {
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(
                        "/Users/huangjie/IdeaProject03/springboot_demo2/src/main/resources/static/images/lmm" + pictures.get(i).getId() + ".jpg"));
                bos.write(pictures.get(i).getPic());
                bos.flush();
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
