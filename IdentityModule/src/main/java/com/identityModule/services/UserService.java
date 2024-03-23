package com.identityModule.services;

import com.identityModule.dtos.UserRequest;
import com.identityModule.dtos.UserResponse;

import java.util.List;


public interface UserService {

    UserResponse saveUser(UserRequest userRequest);

    UserResponse getUser();

    List<UserResponse> getAllUser();


}
