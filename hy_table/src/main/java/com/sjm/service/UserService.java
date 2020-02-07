package com.sjm.service;

import com.sjm.pojo.User;
import com.sjm.vo.PageResult;

import java.util.List;

public interface UserService {

    PageResult<User> queryUserList(Integer page, Integer rows, String sortBy, boolean desc, String key);

    void saveUser(User user);

    User queryById(Long id);

    void updateUser(User user);

    void deleteById(Long id);

}
