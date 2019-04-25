package com.zh.program.Service;

import com.zh.program.Entrty.Invoice;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author: autogeneration
 * @date: 2019-04-11 15:41:37
 **/ 
public interface InvoiceService {
    /**
     * 添加
     * 
     * @author: autogeneration
     * @date: 2019-04-11 15:41:37
     **/ 
    int insert(Invoice record);

    /**
     * 添加
     * 
     * @author: autogeneration
     * @date: 2019-04-11 15:41:37
     **/ 
    int insertSelective(Invoice record);

    /**
     * 更新
     * 
     * @author: autogeneration
     * @date: 2019-04-11 15:41:37
     **/ 
    int updateByPrimaryKey(Invoice record);

    /**
     * 更新
     * 
     * @author: autogeneration
     * @date: 2019-04-11 15:41:37
     **/ 
    int updateByPrimaryKeySelective(Invoice record);

    /**
     * 删除
     * 
     * @author: autogeneration
     * @date: 2019-04-11 15:41:37
     **/ 
    int deleteByPrimaryKey(Integer id);

    /**
     * 按主键查询
     *
     * @param id 主键
     * @author: autogeneration
     * @return 对象
     * @date: 2019-04-11 15:41:37
     **/ 
    Invoice selectByPrimaryKey(Integer id);

    /**
     * 条件查询
     * 
     * @author: autogeneration
     * @date: 2019-04-11 15:41:37
     **/ 
    List<Invoice> selectAll(Map<Object, Object> param);

    /**
     * 分页查询
     * 
     * @author: autogeneration
     * @date: 2019-04-11 15:41:37
     **/ 
    List<Invoice> selectPaging(Map<Object, Object> param);

    /**
     * 统计查询
     * 
     * @author: autogeneration
     * @date: 2019-04-11 15:41:37
     **/ 
    int selectCount(Map<Object, Object> param);

    /**
    *@Description:  发票录入
    *@Param: [data]
    *@return: java.lang.String
    *@Author: zhaohe
    *@date: 2019-04-25
    */
    String insertData(String data);

    /**
    *@Description: 根据期数修改发票状态
    *@Param: [number] 期数
    *@return: void
    *@Author: zhaohe
    *@date: 2019-04-25
    */
    void updateByNumber(Integer number);
}