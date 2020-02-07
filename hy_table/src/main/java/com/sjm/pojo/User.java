package com.sjm.pojo;

import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "tb_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String phone;

    private String username;

    @Ignore
    private String password;

    private String email;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "recommend_phone")
    private String recommendPhone;

    private Boolean isvip;
}
