package com.nirajtailor.feignintegration.Gateway;

import com.nirajtailor.feignintegration.Model.Student;
import com.nirajtailor.feignintegration.Model.User;
import com.nirajtailor.feignintegration.Proxy.UserProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserGatewayService {
    @Autowired
    private UserProxy userProxy;

    public List<User> getUsers(Long userId, String name, String mobile) {
        List<User> users = userProxy.getUsers(userId,name,mobile);
        return users;
    }
}
