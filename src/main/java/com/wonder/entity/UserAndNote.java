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
@TableName("user_and_note")
@ApiModel(value = "UserAndNote对象", description = "")
public class UserAndNote implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("用户id")
    @TableField("userID")
    private Integer userID;

    @ApiModelProperty("笔记id")
    @TableField("noteID")
    private Integer noteID;


}
