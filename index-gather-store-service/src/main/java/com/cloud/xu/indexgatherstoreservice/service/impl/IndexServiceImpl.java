package com.cloud.xu.indexgatherstoreservice.service.impl;

import com.cloud.xu.indexgatherstoreservice.pojo.Index;
import com.cloud.xu.indexgatherstoreservice.service.IndexService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class IndexServiceImpl implements IndexService {
    private List<Index> indexes;

    /**
     * 专门用于将获得json数据或转换成对应的对象数据
     */
    @Autowired
    RestTemplate restTemplate;

    @Override
    @HystrixCommand(fallbackMethod = "thirdPartNotConnected")
    public List<Index> fetchIndexesFromThirdPart() {
        List<Map> temp= restTemplate.getForObject("http://127.0.0.1:8090/indexes/codes.json",List.class);
        return map2Index(temp);
    }

    public List<Index> thirdPartNotConnected(){
        Index index= new Index();
        index.setCode("000000");
        index.setName("无效指数代码");
        return Collections.singletonList(index);
    }

    /**
     * 获取的数据是
     */
    private List<Index> map2Index(List<Map> temp) {
        List<Index> indexes = new ArrayList<>();
        for (Map map : temp) {
            String code = map.get("code").toString();
            String name = map.get("name").toString();
            Index index= new Index();
            index.setCode(code);
            index.setName(name);
            indexes.add(index);
        }
        return indexes;
    }
}
