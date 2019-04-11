package com.zh.program.Entrty;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "report")
@Data
public class Report implements Serializable {
    private static final long serialVersionUID = -6626578301596915003L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String phone;

    private String beReportedCompanyName;

    private String beReportedName;

    private String beReportedAddress;

    private String economicNature;

    private String proveInformation;

    private String content;

    private String imgUrl;

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
        sb.append(", name=").append(name);
        sb.append(", phone=").append(phone);
        sb.append(", beReportedCompanyName=").append(beReportedCompanyName);
        sb.append(", beReportedName=").append(beReportedName);
        sb.append(", beReportedAddress=").append(beReportedAddress);
        sb.append(", economicNature=").append(economicNature);
        sb.append(", proveInformation=").append(proveInformation);
        sb.append(", content=").append(content);
        sb.append(", imgUrl=").append(imgUrl);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}