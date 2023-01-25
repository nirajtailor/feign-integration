package com.nirajtailor.feignintegration.Gateway;

import com.nirajtailor.feignintegration.Model.Student;
import com.nirajtailor.feignintegration.Proxy.StudentProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentGatewayService {

    @Autowired
    private StudentProxy studentProxy;

    public List<Student> getStudents(Long rollNumber, String name, Double cgpa) {
        List<Student> students = studentProxy.getStudents(rollNumber, name, cgpa);
        return students;
    }
}
