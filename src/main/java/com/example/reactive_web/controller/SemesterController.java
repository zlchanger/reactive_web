package com.example.reactive_web.controller;

import com.example.reactive_web.model.Semester;
import com.example.reactive_web.repository.SemesterRepository;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.net.URI;

/**
 * @Auther: changzhaoliang
 * @Date: 2018/11/20 18:16
 * @Description:
 */
@RestController
@RequestMapping("/api/test/semester")
public class SemesterController {

    private final MediaType mediaType = MediaType.APPLICATION_JSON_UTF8;
    @Autowired
    private SemesterRepository semesterRepository;

    @GetMapping
    public Publisher<Semester> index(final @RequestParam(name = "p",defaultValue = "1") int p,
                                     final @RequestParam(name = "s",defaultValue = "10") int s){
        return semesterRepository.retrieveAllSemesterPaged(PageRequest.of(p-1, s));
    }
    @PostMapping
    public Publisher<ResponseEntity<Semester>> create(@Valid @RequestBody Semester semester){
        return semesterRepository.save(semester)
                .map(p -> ResponseEntity.created(URI.create("/api/test/semester/" + p.getId()))
                        .contentType(mediaType)
                        .build());
    }

    @PutMapping("/{id}")
    public Publisher<ResponseEntity<Semester>> update(@PathVariable String id,@RequestBody Semester semester){
        return semesterRepository.findById(id)
                .map( p -> {
                    p.setAcademicYear(semester.getAcademicYear());
                    p.setStartDate(semester.getStartDate());
                    p.setEndDate(semester.getEndDate());
                    p.setSemesterType(semester.getSemesterType());
                    return p;
                })
                .flatMap(semesterRepository::save)
                .map(updatedSemester -> ResponseEntity.ok().contentType(mediaType).body(updatedSemester))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/{id}")
    public Publisher<ResponseEntity<Semester>> show(@PathVariable String id){
        return semesterRepository.findById(id)
                .map(semester -> new ResponseEntity<Semester>(semester, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<Semester>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public Publisher<ResponseEntity<Void>> delete(@PathVariable String id){
        return semesterRepository.findById(id)
                .flatMap(p -> {
                    p.setStatus((byte)0);
                    return semesterRepository.save(p);
                }).then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    public static void main(String[] arg){
        Flux<Integer> ints = Flux.range(1, 4);
//                .map(i -> {
//                    if (i <= 3) return i;
//                    throw new RuntimeException("Got to 4");
//                });
        ints.subscribe(i -> System.out.println(i),
                error -> System.err.println("Error: " + error), //错误信号和完成信号都是终端事件，彼此排斥（你永远不会同时获得）。
                () -> System.out.println("Done"),
                s -> s.request(10));
    }
}
