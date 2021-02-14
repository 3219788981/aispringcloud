package com.southwind.feign;

import com.southwind.entity.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

//声明作用目标在此接口上，value：指明要访问的服务名称(注册中心的名字)
@FeignClient(value = "provider")
public interface FeignProviderClient {
    //value：要访问的服务中接口的名称
    @GetMapping("/student/findAll")
    public Collection<Student> findAll();

    @GetMapping("/student/index")
    public String index();

}
