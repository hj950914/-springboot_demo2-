package com.hj.mapper;

import com.hj.entity.PictureBest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Author: hj
 * Date: 2019-05-17 16:00
 * Description: <描述>
 */
@Mapper
public interface PictureBestMapper {

    /**
     * 添加图片路径
     */
    public void insertPhotoPath(String path);

    /**
     * 取出所有照片路径
     *
     * @return
     */
    public List<PictureBest> selectAllPhotoPath();
}
