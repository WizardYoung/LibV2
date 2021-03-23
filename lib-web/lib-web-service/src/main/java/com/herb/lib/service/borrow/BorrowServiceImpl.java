package com.herb.lib.service.borrow;

import com.herb.lib.api.service.borrow.BookBorrowService;
import com.herb.lib.dao.mapper.borrow.BookBorrowMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author wuyang
 */
public class BorrowServiceImpl implements BookBorrowService {


    @Autowired
    private BookBorrowMapper bookBorrowMapper;

}
