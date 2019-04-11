package com.zh.program.Controller;

import com.zh.program.Common.enums.ResultCode;
import com.zh.program.Dto.Result;
import com.zh.program.Entrty.Article;
import com.zh.program.Entrty.Invoice;
import com.zh.program.Service.ArticleService;
import com.zh.program.Service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 发票管理
 */
@Controller
@RequestMapping("/invoice")
public class InvoiceController {

    private static final String VALIDATE_CODE = "validateCode";

    @Autowired
    private InvoiceService invoiceService;

    /**
     * 发票录入
     * @return
     */
    @RequestMapping("/insert")
    public String insert(Invoice invoice, HttpServletRequest request, String code){
        String validateCode = request.getSession().getAttribute(VALIDATE_CODE).toString();
        System.out.println(validateCode);
        invoiceService.insertSelective(invoice);
        return "true";
    }


}
