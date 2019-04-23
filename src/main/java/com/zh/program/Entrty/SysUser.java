package com.zh.program.Entrty;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Table(name = "sys_user")
@Entity
public class SysUser implements Serializable {
    private static final long serialVersionUID = 8042810026561469390L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String avatar;

    private String account;

    private String password;

    private String salt;

    private String name;

    private Date birthday;

    private Integer sex;

    private String email;

    private String phone;

    private String roleid;

    private Integer deptid;

    private Integer status;

    private Date createtime;

    private Integer version;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append(", id=").append(id);
        sb.append(", avatar=").append(avatar);
        sb.append(", account=").append(account);
        sb.append(", password=").append(password);
        sb.append(", salt=").append(salt);
        sb.append(", name=").append(name);
        sb.append(", birthday=").append(birthday);
        sb.append(", sex=").append(sex);
        sb.append(", email=").append(email);
        sb.append(", phone=").append(phone);
        sb.append(", roleid=").append(roleid);
        sb.append(", deptid=").append(deptid);
        sb.append(", status=").append(status);
        sb.append(", createtime=").append(createtime);
        sb.append(", version=").append(version);
        sb.append("]");
        return sb.toString();
    }
}