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
 * @since 2023-05-31 08:43:08
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("tag_and_note")
@ApiModel(value = "TagAndNote对象", description = "")
public class TagAndNote implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("标签id")
    @TableField("tagID")
    private Integer tagID;

    @ApiModelProperty("笔记id")
    @TableField("noteID")
    private Integer noteID;


}
