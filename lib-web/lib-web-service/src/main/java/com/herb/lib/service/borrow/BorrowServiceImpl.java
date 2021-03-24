package com.herb.lib.service.borrow;

import com.herb.lib.api.constants.ResultDTO;
import com.herb.lib.api.enums.HttpCode;
import com.herb.lib.api.enums.ValidFlagEnum;
import com.herb.lib.api.model.book.BookDTO;
import com.herb.lib.api.model.borrow.BookBorrowDTO;
import com.herb.lib.api.service.borrow.BookBorrowService;
import com.herb.lib.dao.mapper.book.BookMapper;
import com.herb.lib.dao.mapper.borrow.BookBorrowMapper;
import com.sun.xml.internal.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author wuyang
 */

@Service
public class BorrowServiceImpl implements BookBorrowService {


    @Autowired
    private BookBorrowMapper bookBorrowMapper;

    @Autowired
    private BookMapper bookMapper;

    @Override
    public ResultDTO doBorrow(int bookId, Date startDate, Date endDate, int borrowCount, int userId, String userName, boolean vipFlag) {
        //Step 1: 非法校验
        if (0 >= bookId){
            return new ResultDTO(HttpCode.FAIL.getCode(),"书籍编号不合法");
        }

        //租借起始截止日期
        if(startDate.after(endDate)){
            return new ResultDTO(HttpCode.FAIL.getCode(),"起始时间不能晚于截止时间");
        }

        //Step2:获取书籍
        if(borrowCount <= 0){
            return new ResultDTO(HttpCode.FAIL.getCode(),"借阅数量需要等大于0");
        }

        BookDTO bookDTO = bookMapper.findById(bookId);
        //2.1 书籍存在性校验
        if (null == bookDTO){
            return new ResultDTO(HttpCode.EXCEPTION.getCode(),"书籍不存在");
        }
        //2.2 数量是否足够校验
        int bookCount = bookDTO.getBookCount();
        if (bookCount <= 0){
            //TODO 在查找书籍的时候，如果返回的书籍数量为0，前端直接禁用租借按钮，同时加一个效果，当前书籍已经租借光。
            return new ResultDTO(HttpCode.EXCEPTION.getCode(),"当前书籍已经被借光啦，哈哈哈");
        }

        if(borrowCount > bookCount){
            return new ResultDTO(HttpCode.EXCEPTION.getCode(),"借阅数量超过了已有数量");
        }

        //Step 3:真正的借书操作
        int result = doInsertBookBorrowRecord(bookId,bookDTO,borrowCount,startDate,endDate,userId,userName,vipFlag);
        if(result <= 0){
            return new ResultDTO(HttpCode.EXCEPTION.getCode(),"借书失败");
        }

        //Step 4: 减少书籍数量
        bookDTO.setBookCount(bookCount - borrowCount);
        bookDTO.setUpdateDate(new Date());
        //TODO 以下update方法不是我们想要的
        bookMapper.update(bookDTO);

        return new ResultDTO(HttpCode.SUCCESS.getCode(),"借书成功");

    }

    private int doInsertBookBorrowRecord(int bookId, BookDTO bookDTO, int borrowCount, Date startDate, Date endDate, int userId, String userName, boolean vipFlag) {
        BookBorrowDTO bookBorrowDTO = new BookBorrowDTO();
        bookBorrowDTO.setBookId(bookId);
        bookBorrowDTO.setBookName(bookDTO.getBookName());

        bookBorrowDTO.setBorrowCount(borrowCount);
        bookBorrowDTO.setBookId(bookId);
        bookBorrowDTO.setStartDate(startDate);
        bookBorrowDTO.setEndDate(endDate);

        bookBorrowDTO.setUserId(userId);
        bookBorrowDTO.setUserName(userName);

        //设置书籍价格
        BigDecimal bookPrice = bookDTO.getBookPrice();
        long day = (endDate.getTime() - startDate.getTime()) / (24 * 60 * 60 * 1000);
        long totalPrice = bookPrice.intValue() * day;

        bookBorrowDTO.setPrice(new BigDecimal(totalPrice));
        bookBorrowDTO.setTradeFee(new BigDecimal(totalPrice));


        if (vipFlag){
            bookBorrowDTO.setTradeFee(new BigDecimal(0));
        }
        bookBorrowDTO.setCreateDate(new Date());
        bookBorrowDTO.setValidFlag(ValidFlagEnum.ENABLE);

        //新增
        int result = bookBorrowMapper.insert(bookBorrowDTO);

        return result;
    }


}
