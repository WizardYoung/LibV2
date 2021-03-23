package com.herb.lib.api.model.book;



import com.herb.lib.api.model.BaseDTO;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 书籍实体类
 * @author wuyang
 */

@Data
public class BookDTO extends BaseDTO implements Serializable {

    private static final long serialVersionUID = 1740773155051842619L;
    /**
     * 书籍名称
     */
    private String bookName;

    /**
     * 书籍分类ID
     */
    private Integer bookClassId;

    /**
     * 书籍价格
     */
    private BigDecimal bookPrice;


    /**
     * 书籍数量
     */
    private int bookCount;
    /**
     * 书籍出版社
     */
    private String bookPublish;

    /**
     * 书籍作者
     */
    private String bookAuthor;

    /**
     * 书籍照片
     */
    private String bookImg;

    /**
     * 出版日期
     */
    private Date publishDate;

}
