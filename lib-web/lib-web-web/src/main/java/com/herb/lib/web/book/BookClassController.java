package com.herb.lib.web.book;

import com.herb.lib.api.constants.ResultDTO;
import com.herb.lib.api.enums.HttpCode;
import com.herb.lib.api.model.book.BookClassDTO;
import com.herb.lib.api.service.book.BookClassService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 书籍分类访问
 */
@RestController
@RequestMapping("/bookClass")
public class BookClassController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BookClassService bookClassService;

    /**
     * 根据名称查找信息
     * @param bookClassDTO 分类名
     * @return
     */
    @RequestMapping("/findListByName")
    public ResultDTO findListByName(@RequestBody BookClassDTO bookClassDTO){

        try{
            return bookClassService.findListByName(bookClassDTO.getName());
        }catch (Exception e){
            logger.error("系统异常：" + e);
            return new ResultDTO(HttpCode.EXCEPTION.getCode(),"出现异常");
        }
    }

    /**
     *根据ID查找数据
     * @param bookClassDTO 数据主键
     * @return
     */
    @RequestMapping("/findById")
    public ResultDTO findById(@RequestBody BookClassDTO bookClassDTO){
        try{
            return bookClassService.findById(bookClassDTO.getId());
        }catch (Exception e){
            logger.error("系统异常：" + e);
            return new ResultDTO(HttpCode.EXCEPTION.getCode(),"出现异常");
        }
    }

    /**
     * 插入数据
     * @param bookClassDTO 插入的对象
     * @return
     */
    @RequestMapping("/insert")
    public ResultDTO insert(BookClassDTO bookClassDTO){
        try{
            return bookClassService.insert(bookClassDTO);
        }catch (Exception e){
            logger.error("系统异常：" + e);
            return new ResultDTO(HttpCode.EXCEPTION.getCode(),"出现异常");
        }
    }

    @RequestMapping("/update")
    public ResultDTO update(BookClassDTO bookClassDTO){
        try{
            return bookClassService.update(bookClassDTO);
        }catch (Exception e){
            logger.error("系统异常：" + e);
            return new ResultDTO(HttpCode.EXCEPTION.getCode(),"出现异常");
        }
    }

    @RequestMapping("/delete")
    public ResultDTO delete(@RequestBody BookClassDTO bookClassDTO){
        try{
            return bookClassService.delete(bookClassDTO.getId());
        }catch (Exception e){
            logger.error("系统异常：" + e);
            return new ResultDTO(HttpCode.EXCEPTION.getCode(),"出现异常");
        }
    }
}
