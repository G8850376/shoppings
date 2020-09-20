package com.repository;


import com.pojo.Commodity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ComRepository extends ElasticsearchRepository<Commodity,Integer> {


     public List<Commodity> findByNameLike(String name);

}


