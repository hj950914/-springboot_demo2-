package com.hj.service.impl;

import com.hj.entity.PictureBest;
import com.hj.mapper.PictureBestMapper;
import com.hj.service.PictureBestService;
import com.hj.util.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: hj
 * Date: 2019-05-16 16:41
 * Description: <描述>
 */
@Service
public class PictureBestServiceImpl implements PictureBestService {

    @Resource
    private PictureBestMapper pictureBestMapper;

    /**
     * 从前端获取图片的字节流以及图片的名字,然后将图片保存在本地电脑,图片路径保存到数据库
     *
     * @param bytes
     */
    @Override
    public void addPtotoPath(byte[] bytes, String photoName) {
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        //图片路径保存的地址(这里保存的是本地)
        //String path = "/Users/huangjie/Desktop/pictures/images/" + photoName;
        String path = "/home/www/static/images/" + photoName;//这里保存服务器
        try {
            //图片保存到本地
            fos = new FileOutputStream(path);
            bos = new BufferedOutputStream(fos);
            bos.write(bytes);
            bos.flush();
            //图片路径保存到数据库
            pictureBestMapper.insertPhotoPath(path);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null)
                    fos.close();
                if (bos != null)
                    bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 从数据库中获取所有图片路径
     * 这里获取的路径需要进行截取,因为前端不需要多余的路径
     * /Users/huangjie/Desktop/pictures/images/" + photoName
     * 上面的路径只需要 images/" + photoName
     *
     * @return
     */
    @Override
    public List<PictureBest> getAllPhotoPath() {
        List<PictureBest> list = pictureBestMapper.selectAllPhotoPath();
        //定义一个截取路径的集合
        List<PictureBest> newList = new ArrayList<>();
        for (PictureBest p : list) {
            PictureBest pictureBest = new PictureBest();
            //此处的字符串截取只对对应本地电脑
            //String newPath = StringUtil.sub(p.getPath());
            String newPath = StringUtil.sub1(p.getPath());//远程服务器路径截取
            pictureBest.setPath(newPath);
            pictureBest.setPid(p.getPid());
            //加入list
            newList.add(pictureBest);
        }
        return newList;
    }
}
