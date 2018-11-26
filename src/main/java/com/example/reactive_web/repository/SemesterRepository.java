package com.example.reactive_web.repository;

import com.example.reactive_web.model.Semester;
import org.reactivestreams.Publisher;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * @Auther: changzhaoliang
 * @Date: 2018/11/20 18:21
 * @Description:
 */
public interface SemesterRepository extends ReactiveMongoRepository<Semester,String> {

    @Query("{ id: { $exists: true }}")
    Publisher<Semester> retrieveAllSemesterPaged(final Pageable page);
}
