package com.nirajtailor.feignintegration.Proxy;

import com.nirajtailor.feignintegration.Model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "user-service", url = "localhost:8011/user")
public interface UserProxy {
    @RequestMapping(value = "/getUsers",
            method = RequestMethod.GET)
    public List<User> getUsers(
            @RequestParam(value = "id", required = false) Long userId,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "mobile", required = false) String mobile
    );
}
