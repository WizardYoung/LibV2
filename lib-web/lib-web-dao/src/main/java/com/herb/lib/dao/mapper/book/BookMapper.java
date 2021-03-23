package com.herb.lib.dao.mapper.book;

import com.herb.lib.api.model.book.BookClassDTO;
import com.herb.lib.api.model.book.BookDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookMapper {


    /**
     * 根据名称模糊查询全部分类信息
     * @param name 分类名称
     * @return 匹配的数据集
     */
    List<BookDTO> findListByName(String name);

    BookDTO findById(int id);

    /**
     *
     * @param entity 实体类(不包含ID)
     * @return 影响行数
     */
    int insert(BookDTO entity);

    /**
     * 更新
     * @param entity 实体类(包含ID)
     * @return 影响行数
     */
    int update(BookDTO entity);

    /**
     * 删除
     * @param id 数据主键
     * @return 影响行数
     */

    int delete(int id);

    /**
     *
     * @param i
     * @return
     */

}
