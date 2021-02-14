package com.southwind.controller;

import com.southwind.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

@RestController
@RequestMapping("/rest")
public class RestHandler {
    //调用其他服务提供者的方法
    @Autowired
    private RestTemplate restTemplate;


    //Get请求交互
    @GetMapping("/findAll")
    public Collection<Student> findAll(){
        //从其他请求中获取数据("地址",自己要返回的class类型)
        //将.getForEntity的返回值修改为我自己的返回值（默认返回为ResponseEntity）.getBody()返回的类型变为自己要返回的class类型
        return restTemplate.getForEntity("http://localhost:8010/student/findAll",Collection.class).getBody();
    }

    @GetMapping("/findAll2")
    public Collection<Student> findAll2(){
        //.getForObject这个本身返回的就是给的什么数据类型，就返回的什么类型，不需要getBody
        return restTemplate.getForObject("http://localhost:8010/student/findAll",Collection.class);
    }

    //传递rest风格参数
    @GetMapping("/findById/{id}")
    public Student findById(@PathVariable("id")long id){
        return restTemplate.getForEntity("http://localhost:8010/student/findById/{id}",Student.class,id).getBody();
    }

    @GetMapping("/findById2/{id}")
    public Student findById2(@PathVariable("id")long id){
        return restTemplate.getForObject("http://localhost:8010/student/findById/{id}",Student.class,id);
    }

    //Post请求交互
    @PostMapping("/save")
    public void save(@RequestBody Student student){
        //因为这个不需要返回值,所以这个ForEntity也没有使用.getBody，post提交参数
        restTemplate.postForEntity("http://localhost:8010/student/save",student,null);
    }

    @PostMapping("/save2")
    public void save2(@RequestBody Student student){
        //因为这个不需要返回值，post提交参数
        //这个需要给返回值，就算不需要返回值也要给
        restTemplate.postForObject("http://localhost:8010/student/save",student,Integer.class);
    }

    //put请求交互
    @PutMapping("/update")
    public void update(@RequestBody Student student){
        restTemplate.put("http://localhost:8010/student/update",student);
    }

    //delete请求交互
    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id")long id){
        restTemplate.delete("http://localhost:8010/student/deleteById/{id}",id);
    }

}
