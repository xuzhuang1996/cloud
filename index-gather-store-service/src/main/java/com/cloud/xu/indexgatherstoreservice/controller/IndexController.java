package com.cloud.xu.indexgatherstoreservice.controller;

import com.cloud.xu.indexgatherstoreservice.pojo.Index;
import com.cloud.xu.indexgatherstoreservice.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * RestController就是后面为了返回实体，而不是字符串。如果返回字符串则不会找到对应的视图。这里是默认视图
 */
@RestController
public class IndexController {
    @Autowired
    IndexService indexService;

    @GetMapping("/getCodes")
    public List<Index> get() throws Exception {
        return indexService.fetchIndexesFromThirdPart();
    }
}
