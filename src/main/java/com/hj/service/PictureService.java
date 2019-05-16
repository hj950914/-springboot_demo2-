package com.hj.service;

import com.hj.entity.Picture;

import java.util.List;

/**
 * Author: hj
 * Date: 2019-05-16 16:42
 * Description: <描述>
 */
public interface PictureService {

    /**
     * 添加照片
     */
    public void addPtoto(String path);

    /**
     * 获取全部照片
     *
     * @return
     */
    public List<Picture> getAllPhoto();
}
