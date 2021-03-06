package com.zh.program.Dao;

import com.zh.program.Entrty.Prize;
import java.util.List;
import java.util.Map;

public interface PrizeMapper {
    int insert(Prize record);

    int insertSelective(Prize record);

    int updateByPrimaryKey(Prize record);

    int updateByPrimaryKeySelective(Prize record);

    int deleteByPrimaryKey(Integer id);

    Prize selectByPrimaryKey(Integer id);

    List<Prize> selectAll(Map<Object, Object> param);

    List<Prize> selectPaging(Map<Object, Object> param);

    int selectCount(Map<Object, Object> param);

    List<Map<String, Object>> queryByPhoneIdCardInvoiceId(Map<Object, Object> map);

    List<Map<String, Object>> selectList(Map<Object, Object> map);

    List<Map<String, Object>> getNumberList(Map<Object, Object> map);
}