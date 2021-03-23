package com.herb.lib.api.model.book;


import com.herb.lib.api.model.BaseDTO;
import lombok.Data;

import java.io.Serializable;

/**
 * 书籍分类信息表实体类
 * @author wuyang
 */
@Data
public class BookClassDTO extends BaseDTO implements Serializable {


    private static final long serialVersionUID = 6388571251266099182L;
    /**
     * 分类的名称
     */
    private String name;
}
