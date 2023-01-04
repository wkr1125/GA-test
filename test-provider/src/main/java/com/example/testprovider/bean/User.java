package com.example.testprovider.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author wenkr
 * @version V1.0
 * @Package com.example.testprovider.bean
 * @date 2023/1/4 14:30
 * @Copyright ©
 */
@Data
@Entity(name = "t_user")
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "t_name")
    private String name;

    private String userName;


    public User(String name, String userName) {
        this.name = name;
        this.userName = userName;
    }
}
