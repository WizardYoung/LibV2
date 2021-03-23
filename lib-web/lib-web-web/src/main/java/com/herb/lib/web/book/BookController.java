package com.herb.lib.web.book;

import com.herb.lib.api.constants.ResultDTO;
import com.herb.lib.api.enums.HttpCode;
import com.herb.lib.api.model.book.BookDTO;
import com.herb.lib.api.service.book.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BookService bookService;


    /**
     * 根据名称查找信息
     * @param bookDTO 分类名
     * @return
     */
    @RequestMapping("/findListByName")
    public ResultDTO findListByName(@RequestBody BookDTO bookDTO){

        try{
            return bookService.findListByName(bookDTO.getBookName());
        }catch (Exception e){
            logger.error("系统异常：" + e);
            return new ResultDTO(HttpCode.EXCEPTION.getCode(),"出现异常");
        }
    }

    /**
     *根据ID查找数据
     * @param bookDTO 数据主键
     * @return
     */
    @RequestMapping("/findById")
    public ResultDTO findById(@RequestBody BookDTO bookDTO){
        try{
            return bookService.findById(bookDTO.getId());
        }catch (Exception e){
            logger.error("系统异常：" + e);
            return new ResultDTO(HttpCode.EXCEPTION.getCode(),"出现异常");
        }
    }

    /**
     * 插入数据
     * @param bookDTO 插入的对象
     * @return
     */
    @RequestMapping("/insert")
    public ResultDTO insert(@RequestBody BookDTO bookDTO){
        try{
            return bookService.insert(bookDTO);
        }catch (Exception e){
            logger.error("系统异常：" + e);
            return new ResultDTO(HttpCode.EXCEPTION.getCode(),"出现异常");
        }
    }

    @RequestMapping("/update")
    public ResultDTO update(BookDTO bookDTO){
        try{
            return bookService.update(bookDTO);
        }catch (Exception e){
            logger.error("系统异常：" + e);
            return new ResultDTO(HttpCode.EXCEPTION.getCode(),"出现异常");
        }
    }

    @RequestMapping("/delete")
    public ResultDTO delete(@RequestBody BookDTO bookDTO){
        try{
            return bookService.delete(bookDTO.getId());
        }catch (Exception e){
            logger.error("系统异常：" + e);
            return new ResultDTO(HttpCode.EXCEPTION.getCode(),"出现异常");
        }
    }


}
