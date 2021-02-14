package com.southwind.feign;

import com.southwind.entity.Student;
import com.southwind.feign.impl.FeignError;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

//声明作用目标在此接口上，value：指明要访问的服务名称(注册中心的名字)
//fallback出现问题时访问，这个必须是继承了它的实现类
@FeignClient(value = "provider",fallback = FeignError.class)
public interface FeignProviderClient {
    //value：要访问的服务中接口的名称
    @GetMapping("/student/findAll")
    public Collection<Student> findAll();

    @GetMapping("/student/index")
    public String index();

}
