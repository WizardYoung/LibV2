package com.herb.lib.service.book;

import com.herb.lib.api.constants.ResultDTO;
import com.herb.lib.api.enums.HttpCode;
import com.herb.lib.api.model.book.BookClassDTO;
import com.herb.lib.api.service.book.BookClassService;
import com.herb.lib.dao.mapper.book.BookClassMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class BookClassServiceImpl implements BookClassService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BookClassMapper bookClassMapper;


    @Override
    public ResultDTO findListByName(String name) {

        logger.info("入参：" + name);

        //非空判断
        if (StringUtils.isEmpty(name)){
            return new ResultDTO(HttpCode.FAIL.getCode(),"搜索关键字不能为空");
        }

        //业务查找
        List<BookClassDTO> list = bookClassMapper.findListByName(name);
        if (CollectionUtils.isEmpty(list)){
            return new ResultDTO(HttpCode.FAIL.getCode(),"暂无对应分类");
        }

        logger.info("出参：" + list);
        return new ResultDTO(HttpCode.SUCCESS.getCode(),"查询成功",list);
    }

    @Override
    public ResultDTO insert(BookClassDTO entity) {

        logger.info("入参：" + entity);
        //非空判断
        if(StringUtils.isEmpty(entity.getName())){
            return new ResultDTO(HttpCode.FAIL.getCode(),"分类名称不能为空");
        }
        int influenceNumber = bookClassMapper.insert(entity);
        if (influenceNumber <= 0){
            return new ResultDTO(HttpCode.FAIL.getCode(),"新增失败");
        }
        return new ResultDTO(HttpCode.FAIL.getCode(),"新增成功");
    }

    @Override
    public ResultDTO update(BookClassDTO entity) {
        logger.info("入参：" + entity);
        if(StringUtils.isEmpty(entity.getId())){
            return new ResultDTO(HttpCode.FAIL.getCode(),"分类名称不能为空");
        }
        int influenceNumber = bookClassMapper.update(entity);
        if (influenceNumber <= 0){
            return new ResultDTO(HttpCode.FAIL.getCode(),"更新失败");
        }
        return new ResultDTO(HttpCode.FAIL.getCode(),"更新成功");
    }

    @Override
    public ResultDTO delete(int id) {

        logger.info("入参：" + id);
        if(0 == id){
            return new ResultDTO(HttpCode.FAIL.getCode(),"分类名称不能为空");
        }
        int influenceNumber = bookClassMapper.delete(id);
        if (influenceNumber <= 0){
            return new ResultDTO(HttpCode.FAIL.getCode(),"删除失败");
        }
        logger.info("出参：" + id);
        return new ResultDTO(HttpCode.FAIL.getCode(),"删除成功");
    }

    @Override
    public ResultDTO findById(int id) {
        logger.info("入参：" + id);
        if (0 == id){
            return new ResultDTO(HttpCode.FAIL.getCode(),"数据ID不能为空");
        }
        BookClassDTO bookClassDTO = bookClassMapper.findById(id);
        if (null == bookClassDTO){
            return new ResultDTO(HttpCode.FAIL.getCode(),"暂无此类数据");
        }

        logger.info("出参：" + bookClassDTO);
        return new ResultDTO(HttpCode.SUCCESS.getCode(),"寻找成功",bookClassDTO);
    }


}
