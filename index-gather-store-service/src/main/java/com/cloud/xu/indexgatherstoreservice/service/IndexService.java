package com.cloud.xu.indexgatherstoreservice.service;


import com.cloud.xu.indexgatherstoreservice.pojo.Index;

import java.util.List;

/**
 * @author xuzhuang
 */
public interface IndexService {
    /**
     * 获取指数的code与name
     **/
    List<Index> fetchIndexesFromThirdPart();
}
