package com.wonder.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wonder.entity.UserAndNote;
import com.wonder.mapper.UserAndNoteMapper;
import com.wonder.service.UserAndNoteService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author DelLevin
 * @since 2023-05-31 11:33:06
 */
@Service
public class UserAndNoteServiceImpl extends ServiceImpl<UserAndNoteMapper, UserAndNote> implements UserAndNoteService {

}
