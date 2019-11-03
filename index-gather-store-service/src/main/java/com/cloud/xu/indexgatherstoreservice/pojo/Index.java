package com.cloud.xu.indexgatherstoreservice.pojo;


import java.io.Serializable;

/**
 * @author xuzhuang
 * 指数类，用于指数里的名称和代码。
 */
public class Index implements Serializable {
    /*
     * 用于版本控制。即如果持久化后，即使Index变化，对应的属性还能保存
     */
    private static final long serialVersionUID = 1L;
    /*
     * json文件对应的指数股的code以及name
     */
    String code;
    String name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
