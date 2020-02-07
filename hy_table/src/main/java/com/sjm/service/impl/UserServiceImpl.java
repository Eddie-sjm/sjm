package com.sjm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sjm.mapper.UserMapper;
import com.sjm.pojo.User;
import com.sjm.service.UserService;
import com.sjm.utlis.MD5Utils;
import com.sjm.vo.PageResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public PageResult<User> queryUserList(Integer page, Integer rows, String sortBy, boolean desc, String key) {
        PageHelper.startPage(page,rows);

        Example example = new Example(User.class);
        if(StringUtils.isNotBlank(key)){
            Example.Criteria criteria = example.createCriteria();
            criteria.andLike("phone","%"+key+"%");
        }
        example.setOrderByClause(sortBy + " " + (desc?"desc":"asc"));
        List<User> users = userMapper.selectByExample(example);

        PageInfo<User> info = new PageInfo<>(users);

        PageResult<User> result = new PageResult<>();

        result.setItems(info.getList());
        result.setTotal(info.getTotal());
        result.setTotalPage(info.getPages());
        return result;
    }

    @Override
    public void saveUser(User user) {
        System.out.println(user);
        String newPass = MD5Utils.md5(user.getPassword(), user.getUsername(), 1024);
        user.setPassword(newPass);
        userMapper.insert(user);
    }

    @Override
    public User queryById(Long id) {
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }

    @Override
    public void updateUser(User user) {
        String newPass = MD5Utils.md5(user.getPassword(), user.getUsername(), 1024);
        user.setPassword(newPass);
        userMapper.updateByPrimaryKey(user);
    }

    @Override
    public void deleteById(Long id) {
        int i = userMapper.deleteByPrimaryKey(id);
    }


}
