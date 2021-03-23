package com.herb.lib.api.model;


import lombok.Data;

import java.util.Date;

/**
 * 实体类父类
 * @author wuyang
 */

@Data
public class BaseDTO {
    /**
     * 数据ID
     */
    private int id;


    /**
     * 临时字段1
     */
    private String tmp1;

    /**
     * 临时字段2
     */
    private String tmp2;

    /**
     * 出版日期
     */
    private Date createDate;

    /**
     * 最后一次更新时间
     */
    private Date updateDate;

    /**
     * 出有效标记版
     */
    private String validFlag;

}
