package com.cloud.xu.indexgatherstoreservice.service.impl;

import com.cloud.xu.indexgatherstoreservice.pojo.Index;
import com.cloud.xu.indexgatherstoreservice.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class IndexServiceImpl implements IndexService {
    private List<Index> indexes;

    /**
     * 专门用于将获得json数据或转换成对应的对象数据
     */
    @Autowired
    RestTemplate restTemplate;

    @Override
    public List<Index> fetchIndexesFromThirdPart() {
        List<Map> temp= restTemplate.getForObject("http://127.0.0.1:8090/indexes/codes.json",List.class);
        return map2Index(temp);
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
