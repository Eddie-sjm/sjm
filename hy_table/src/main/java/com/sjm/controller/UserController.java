package com.sjm.controller;

import com.sjm.pojo.User;
import com.sjm.service.UserService;
import com.sjm.vo.PageResult;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Configuration
@RestController
@RequestMapping("/api/item")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "查询全部信息",notes = "作用是：......")
    @ApiImplicitParams({@ApiImplicitParam(name = "page",value = "初始页",required = true,dataType = "Integer"),
                        @ApiImplicitParam(name = "size",value = "每页条数",required = true,dataType = "Integer")
    })
    @GetMapping("/userList/page")
    public ResponseEntity<PageResult<User>> queryUserList(@RequestParam(value = "page",defaultValue = "1")Integer page
                                                         ,@RequestParam(value = "rows",defaultValue = "5")Integer rows
                                                         ,@RequestParam(value = "sortBy",required = false)String sortBy
                                                         ,@RequestParam(value = "desc",defaultValue = "false")boolean desc
                                                         ,@RequestParam(value = "key",required = false)String key){
        log.warn("查看用户列表的日志信息");
        PageResult<User> userList = userService.queryUserList(page,rows,sortBy,desc,key);
        return ResponseEntity.ok(userList);
    }

    @PostMapping("/addOrUpdateUser")
    public ResponseEntity<Void> saveBrand(User user){
        log.warn("新增用户的日志信息");
        this.userService.saveUser(user);
        return ResponseEntity.ok(null);
    }

    @GetMapping("/queryUserId/{id}")
    public ResponseEntity<User> queryById(@PathVariable("id") Long id){
        log.warn("通过ID查看用户信息的日志信息");
        User user = userService.queryById(id);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/addOrUpdateUser")
    public ResponseEntity<Void> updataBrand(User user){
        log.warn("修改用户的日志信息");
        this.userService.updateUser(user);
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/deleteByUserId/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id){
        log.warn("通过ID删除用户信息的日志信息");
        userService.deleteById(id);
        return ResponseEntity.ok(null);
    }
}
