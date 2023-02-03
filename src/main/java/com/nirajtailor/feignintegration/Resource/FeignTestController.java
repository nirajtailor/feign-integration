package com.nirajtailor.feignintegration.Resource;

import com.nirajtailor.feignintegration.Model.Response;
import com.nirajtailor.feignintegration.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class FeignTestController {

    @Autowired
    private UserService userService;
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    ResponseEntity<Object> getUsers(
            @RequestParam(value = "userId", required = false) Long userId,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "mobile", required = false) String mobile
    ){
        Response response = userService.getUsers(userId, name, mobile);
        return new ResponseEntity<>(response.getBody(), response.getStatus());
    }

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    ResponseEntity<Object> getStudents(
            @RequestParam(value = "rollNumber", required = false) Long rollNumber,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "cgpa", required = false) Double cgpa
    ){
        Response response = userService.getStudents(rollNumber, name, cgpa);
        return new ResponseEntity<>(response.getBody(), response.getStatus());
    }
}
