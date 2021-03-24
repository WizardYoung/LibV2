package com.herb.lib.api.model.borrow;

import com.herb.lib.api.model.BaseDTO;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author wuyang
 */
@Data
public class BookBorrowDTO extends BaseDTO {

    /**
     * 用户ID
     */
    private int userId;

    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 书籍ID
     */
    private int bookId;

    /**
     * 书籍姓名
     */
    private String bookName;

    /**
     * 借阅数量
     */
    private int borrowCount;

    /**
     * 借书时间
     */
    private Date startDate;

    /**
     * 还书时间
     */
    private Date endDate;

    /**
     * 借书费用
     */
    private BigDecimal price;


    /**
     * 借书实际费用
     */
    private BigDecimal tradeFee;
}
