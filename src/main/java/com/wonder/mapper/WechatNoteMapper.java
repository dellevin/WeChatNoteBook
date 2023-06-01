package com.wonder.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wonder.entity.WechatNote;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author DelLevin
 * @since 2023-05-31 11:33:06
 */
@Mapper
public interface WechatNoteMapper extends BaseMapper<WechatNote> {
    int getNoteID(String noteContext);

}
