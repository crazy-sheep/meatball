package com.demo.meatball.po;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
    
    @NotBlank(message = "账号不能为空")
    @ApiModelProperty(value = "账号")
    @Column(nullable = false, unique = true)
    private String account;
    
    @Column(nullable = false, unique = true)
    private String userName;
    
    @NotBlank(message = "密码不能为空")
    @Column
    @ApiModelProperty(value = "密码")
    private String passWord;
    
    @Column
    @ApiModelProperty(value = "手机号")
    private String phoneNumber;
}
