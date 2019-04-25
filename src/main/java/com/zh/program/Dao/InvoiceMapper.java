package com.zh.program.Dao;

import com.zh.program.Entrty.Invoice;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface InvoiceMapper {
    int insert(Invoice record);

    int insertSelective(Invoice record);

    int updateByPrimaryKey(Invoice record);

    int updateByPrimaryKeySelective(Invoice record);

    int deleteByPrimaryKey(Integer id);

    Invoice selectByPrimaryKey(Integer id);

    List<Invoice> selectAll(Map<Object, Object> param);

    List<Invoice> selectPaging(Map<Object, Object> param);

    int selectCount(Map<Object, Object> param);

    void updateByNumber(@Param("id") Integer number);
}