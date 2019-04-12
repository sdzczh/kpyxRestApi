package com.zh.program.Service;

import com.zh.program.Entrty.Prize;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author: autogeneration
 * @date: 2019-04-11 15:42:24
 **/ 
public interface PrizeService {
    /**
     * 添加
     * 
     * @author: autogeneration
     * @date: 2019-04-11 15:42:24
     **/ 
    int insert(Prize record);

    /**
     * 添加
     * 
     * @author: autogeneration
     * @date: 2019-04-11 15:42:24
     **/ 
    int insertSelective(Prize record);

    /**
     * 更新
     * 
     * @author: autogeneration
     * @date: 2019-04-11 15:42:24
     **/ 
    int updateByPrimaryKey(Prize record);

    /**
     * 更新
     * 
     * @author: autogeneration
     * @date: 2019-04-11 15:42:24
     **/ 
    int updateByPrimaryKeySelective(Prize record);

    /**
     * 删除
     * 
     * @author: autogeneration
     * @date: 2019-04-11 15:42:24
     **/ 
    int deleteByPrimaryKey(Integer id);

    /**
     * 按主键查询
     * 
     * @author: autogeneration
     * @date: 2019-04-11 15:42:24
     **/ 
    Prize selectByPrimaryKey(Integer id);

    /**
     * 条件查询
     * 
     * @author: autogeneration
     * @date: 2019-04-11 15:42:24
     **/ 
    List<Prize> selectAll(Map<Object, Object> param);

    /**
     * 分页查询
     * 
     * @author: autogeneration
     * @date: 2019-04-11 15:42:24
     **/ 
    List<Prize> selectPaging(Map<Object, Object> param);

    /**
     * 统计查询
     * 
     * @author: autogeneration
     * @date: 2019-04-11 15:42:24
     **/ 
    int selectCount(Map<Object, Object> param);

    /**
     * 根据手机号 身份证号 发票编号查询
     * @param map
     * @return
     */
    List<Prize> queryByPhoneIdCardInvoiceId(Map<Object, Object> map);
}