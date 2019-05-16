package com.hj.mapper;

import com.hj.entity.Picture;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Author: hj
 * Date: 2019-05-16 16:36
 * Description: <描述>
 */
@Mapper
public interface PictureMapper {

    /**
     * 添加照片
     */
    public void insertPtoto(Picture picture);

    /**
     * 获取全部照片
     *
     * @return
     */
    public List<Picture> selectAllPhoto();
}
