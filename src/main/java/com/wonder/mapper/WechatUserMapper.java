package com.wonder.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wonder.entity.WechatUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author DelLevin
 * @since 2023-05-31 08:43:08
 */
@Mapper
public interface WechatUserMapper extends BaseMapper<WechatUser> {

    int getUseIsExist(String userName);

    String getUsePassword(String userName);
}
