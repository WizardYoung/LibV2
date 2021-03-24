package com.herb.lib.dao.mapper.borrow;

import com.herb.lib.api.model.borrow.BookBorrowDTO;
import org.apache.ibatis.annotations.Mapper;

/**借书还书接口层
 * @author wuyang
 */
@Mapper
public interface BookBorrowMapper {

    int insert(BookBorrowDTO bookBorrowDTO);

}
