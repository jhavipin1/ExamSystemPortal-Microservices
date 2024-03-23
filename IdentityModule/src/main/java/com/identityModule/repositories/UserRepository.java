package com.identityModule.repositories;

import com.identityModule.helpers.RefreshableCRUDRepository;
import com.identityModule.models.UserInfo;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends RefreshableCRUDRepository<UserInfo, Long> {

   public UserInfo findByUsername(String username);
   UserInfo findFirstById(Long id);

}
