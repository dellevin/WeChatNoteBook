package com.wonder.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wonder.entity.WechatUser;
import com.wonder.mapper.WechatUserMapper;
import com.wonder.service.WechatUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author DelLevin
 * @since 2023-05-31 08:43:08
 */
@Service
public class WechatUserServiceImpl extends ServiceImpl<WechatUserMapper, WechatUser> implements WechatUserService {

}
