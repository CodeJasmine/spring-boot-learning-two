package com.soft1851.springboot.mybatisplus.service.impl;

import com.soft1851.springboot.mybatisplus.entity.Article;
import com.soft1851.springboot.mybatisplus.mapper.ArticleMapper;
import com.soft1851.springboot.mybatisplus.service.ArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhent
 * @since 2020-04-16
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

}
