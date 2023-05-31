package com.wonder.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author DelLevin
 * @since 2023-05-31 11:33:06
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("wechat_user")
@ApiModel(value = "WechatUser对象", description = "")
public class WechatUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("用户id")
    @TableField("user_id")
    private Integer userId;

    @ApiModelProperty("微信用户姓名openid")
    @TableField("user_name")
    private String userName;

    @ApiModelProperty("微信用户密码")
    @TableField("user_password")
    private String userPassword;


}
