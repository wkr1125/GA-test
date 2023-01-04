package com.example.testprovider.mapper;

import com.example.testprovider.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author wenkr
 * @version V1.0
 * @Package com.example.testprovider.mapper
 * @date 2023/1/4 14:40
 * @Copyright ©
 */
public interface JpaUserRepository extends JpaRepository<User, Integer> {
    @Query("from t_user where name=?1")
    List<User> findByName(String name);

    //具名参数
    @Query("from t_user where userName=:userName ")
    List<User> findByUserName(@Param("userName") String userName);

    //写在业务层，懒得加接口了....
    @Transactional
    @Modifying //通知spring data jpa是增删改的操作
    @Query("update t_user set name=:name where id=:id")
    int updateNameById(String name,Integer id);
}
