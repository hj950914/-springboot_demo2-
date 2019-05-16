package com.hj;

import com.hj.entity.Picture;
import com.hj.mapper.PictureMapper;
import com.hj.service.PictureService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootDemo2ApplicationTests {

    @Resource
    private PictureMapper pictureMapper;

    @Autowired
    private PictureService pictureService;

    @Test
    public void contextLoads() {
        byte[] bytes = {'1', '2'};
        Picture picture = new Picture();
        picture.setPic(bytes);
        picture.setDescription("这是一个测试");
        pictureMapper.insertPtoto(picture);

        List<Picture> pictures = pictureMapper.selectAllPhoto();
        System.out.println(pictures);
    }

    /**
     * 添加图片进数据库
     */
    @Test
    public void testAdd() {
        String path = null;
        int i;//表示从第几张图片开始加入
        int j = 2;//表示加入多少
        for (i = 2; i <= j; i++) {
            path = "/Users/huangjie/Desktop/pictures/lmm" + i + ".jpg";
            pictureService.addPtoto(path);
        }
    }

    /**
     * 从数据库中读取全部
     */
    @Test
    public void testRead(){
        List<Picture> allPhoto = pictureService.getAllPhoto();
        System.out.println(allPhoto);
    }

}
