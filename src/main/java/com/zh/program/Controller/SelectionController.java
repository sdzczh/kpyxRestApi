package com.zh.program.Controller;

import com.zh.program.Common.enums.ResultCode;
import com.zh.program.Common.utils.StrUtils;
import com.zh.program.Dto.Result;
import com.zh.program.Entrty.Banner;
import com.zh.program.Entrty.Selection;
import com.zh.program.Service.BannerService;
import com.zh.program.Service.SelectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Struct;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/selection")
public class SelectionController {
    @Autowired
    private SelectionService selectionService;

    /**
     * 获取被选中的人列表
     * number 期数
     * @return
     */
    @ResponseBody
    @RequestMapping("/list")
    public String getAll(String number){
        if(number == null){
            return Result.toResult(ResultCode.PARAM_IS_BLANK);
        }
        Map<Object, Object> map = new HashMap<>();
        map.put("number", number);
        List<Map<String, Object>> list = selectionService.selectList(map);
        return Result.toResult(ResultCode.SUCCESS, list);
    }

    /**
     * 获取获选人名单
     * @return
     */
    @ResponseBody
    @RequestMapping("/getSelectList")
    public String getSelectList(Integer number){
        if(number == null){
            return Result.toResult(ResultCode.PARAM_IS_BLANK);
        }
        Map<Object, Object> map = new HashMap<>();
        Map<Object, Object> data = new HashMap<>();
        map.put("number", number);
        try {
            List<Map<String, Object>> list = selectionService.selectList(map);
            List<String> linkedList = new LinkedList<>();
            for(Map<String, Object> result : list){
                linkedList.add(result.get("invoice_id").toString());
            }
            data.put("list", linkedList);
            data.put("count", list.size());
        } catch (Exception e) {
            e.printStackTrace();
            return Result.toResult(ResultCode.SYSTEM_INNER_ERROR);
        }
        return Result.toResult(ResultCode.SUCCESS, data);
    }
}
