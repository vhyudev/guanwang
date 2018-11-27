package com.hypq.springbootmybatis.service.impl;

import com.hypq.springbootmybatis.dao.NewsDetailMapper;
import com.hypq.springbootmybatis.domain.NewsDetail;
import com.hypq.springbootmybatis.domain.NewsDetailExample;
import com.hypq.springbootmybatis.service.NewsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class NewsServiceImpl implements NewsService {

    @Resource
    NewsDetailMapper ndMapper;
    @Override
    public List<NewsDetail> getall() {

        List<NewsDetail> newsTables = ndMapper.getAll();
        if(newsTables != null && newsTables.size()>0){
            for(int i = 0;i<newsTables.size();i++){
                newsTables.get(i).setUrl("newsDetail.html?id="+newsTables.get(i).getId());
            }
        }

        return newsTables;
    }

    @Override
    public List<NewsDetail> getByType(String type) {
        List<NewsDetail> newsTables = ndMapper.getByType(type);
        if(newsTables != null && newsTables.size()>0){
            for(int i = 0;i<newsTables.size();i++){
                newsTables.get(i).setUrl("newsDetail.html?id="+newsTables.get(i).getId());
            }
        }
        return newsTables;
    }

    @Override
    public int getNewsCount(String type) {
        int count = ndMapper.getNewsCount(type);
        return count;
    }

    @Override
    public int getNewsCount() {
        NewsDetailExample e = new NewsDetailExample();
        int count = ndMapper.countByExample(e);
        return count;
    }

    @Override
    public void addNews(NewsDetail nd) {
        NewsDetail news = ndMapper.getLatestNews();
        if(nd.getId()==null){
            nd.setBeforeArticle(news.getId()+"");
            nd.setNextArticle("");
            nd.setClickcount(0);
            nd.setUrl("/");
            nd.setUploaddate(new Date());
            ndMapper.insert(nd);
            news.setNextArticle(nd.getId()+"");
            System.out.println("news id -----------------------------------------"+nd.getId());
            ndMapper.updateByPrimaryKeyWithBLOBs(news);
            return;
        }
        NewsDetail newsTemp = ndMapper.selectByPrimaryKey(nd.getId());
        newsTemp.setTitle(nd.getTitle());
        newsTemp.setContent(nd.getContent());
        newsTemp.setPublishDate(nd.getPublishDate());
        newsTemp.setArticleType(nd.getArticleType());
        ndMapper.updateByPrimaryKeyWithBLOBs(newsTemp);


    }

    @Override
    public int deleteById(String id) {
       int res =  ndMapper.deleteByPrimaryKey(Integer.valueOf(id));

        return res;
    }

    @Override
    public NewsDetail getNewsById(String id) {
        NewsDetail nd = ndMapper.selectByPrimaryKey(Integer.valueOf(id));
        return nd;
    }

    @Override
    public int updateNews(NewsDetail nd) {
        return ndMapper.updateByPrimaryKeyWithBLOBs(nd);
    }

}
