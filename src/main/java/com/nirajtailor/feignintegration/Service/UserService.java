package com.nirajtailor.feignintegration.Service;

import com.nirajtailor.feignintegration.Gateway.StudentGatewayService;
import com.nirajtailor.feignintegration.Gateway.UserGatewayService;
import com.nirajtailor.feignintegration.Model.Response;
import com.nirajtailor.feignintegration.Model.Student;
import com.nirajtailor.feignintegration.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private StudentGatewayService studentGatewayService;

    @Autowired
    private UserGatewayService userGatewayService;

    public Response getUsers(Long userId, String name, String mobile) {
        List<User> users = userGatewayService.getUsers(userId, name, mobile);
        return new Response(users, HttpStatus.OK);
    }

    public Response getStudents(Long rollNumber, String name, Double cgpa) {
        List<Student> students = studentGatewayService.getStudents(rollNumber, name, cgpa);
        return new Response(students, HttpStatus.OK);
    }
}
