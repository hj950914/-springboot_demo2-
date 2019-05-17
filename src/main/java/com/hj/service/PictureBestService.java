package com.hj.service;

import com.hj.entity.PictureBest;

import java.util.List;

/**
 * Author: hj
 * Date: 2019-05-16 16:42
 * Description: <描述>
 */
public interface PictureBestService {

    /**
     * 添加图片路径
     */
    public void addPtotoPath(byte[] bytes, String photoName);

    /**
     * 获取所有图片路径
     *
     * @return
     */
    public List<PictureBest> getAllPhotoPath();

}
