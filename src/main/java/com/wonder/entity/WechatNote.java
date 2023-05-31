package com.wonder.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

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
@TableName("wechat_note")
@ApiModel(value = "WechatNote对象", description = "")
public class WechatNote implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("笔记id")
    @TableField("note_id")
    private Integer noteId;

    @ApiModelProperty("笔记内容")
    @TableField("note_context")
    private String noteContext;

    @ApiModelProperty("记录笔记时间")
    @TableField("note_time")
    private Date noteTime;

    @ApiModelProperty("笔记标签")
    @TableField("note_tag")
    private String noteTag;


}
