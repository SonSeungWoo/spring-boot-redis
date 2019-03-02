package me.seungwoo;

import lombok.Data;

/**
 * Created by Leo.
 * User: sonseungwoo
 * Date: 2019-03-01
 * Time: 21:44
 */
@Data
public class UserDto {

    private Long id;

    private String userName;

    private String password;

    private String email;
}
