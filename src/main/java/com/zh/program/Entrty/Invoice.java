package com.zh.program.Entrty;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "invoice")
@Data
public class Invoice implements Serializable {
    private static final long serialVersionUID = 6508180329170221172L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String invoiceCode;

    private String invoiceId;

    private String phone;

    private String idCardNum;

    private BigDecimal amount;

    private Byte state;

    private Date createDate;

    private Date createTime;

    private Date updateTime;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append(", id=").append(id);
        sb.append(", invoiceCode=").append(invoiceCode);
        sb.append(", invoiceId=").append(invoiceId);
        sb.append(", phone=").append(phone);
        sb.append(", idCardNum=").append(idCardNum);
        sb.append(", amount=").append(amount);
        sb.append(", state=").append(state);
        sb.append(", createDate=").append(createDate);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}