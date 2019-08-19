package com.mjq.es.repository;

import com.mjq.es.document.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Created by majingqiang on 2018/11/10.
 */
public interface UserRepository extends ElasticsearchRepository<User, String> {
}
