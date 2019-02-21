package com.choway.springboot.elasticsearch;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDao extends ElasticsearchRepository<Student, Long> {
}
