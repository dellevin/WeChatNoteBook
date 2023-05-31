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
 * @since 2023-05-31 08:43:08
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

    @ApiModelProperty("笔记保存的时间")
    @TableField("note_time")
    private Date noteTime;

    @ApiModelProperty("笔记内容")
    @TableField("note_content")
    private String noteContent;


}
