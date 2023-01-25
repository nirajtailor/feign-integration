package com.nirajtailor.feignintegration.Proxy;

import com.nirajtailor.feignintegration.Model.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "student-proxy", url = "localhost:8009")
public interface StudentProxy {

    @RequestMapping(value = "student/getAll", method = RequestMethod.GET)
    public List<Student> getStudents(
            @RequestParam(value = "rollNumber", required = false) Long rollNumber,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "cgpa", required = false) Double cgpa
    );

}
