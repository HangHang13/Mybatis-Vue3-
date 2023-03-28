package com.example.mybatis.mapper;

import com.example.mybatis.dto.req.UserRequest;
import com.example.mybatis.dto.res.UserResponse;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PostUserMapper {


    void save(UserRequest params);

    UserResponse findByUserEmail(String userEmail);

}
