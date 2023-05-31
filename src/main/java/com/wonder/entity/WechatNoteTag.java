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
@TableName("wechat_note_tag")
@ApiModel(value = "WechatNoteTag对象", description = "")
public class WechatNoteTag implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("笔记标签id")
    @TableField("tag_id")
    private Integer tagId;

    @ApiModelProperty("笔记标签")
    @TableField("tag_text")
    private String tagText;


}
