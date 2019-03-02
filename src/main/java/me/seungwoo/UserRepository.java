package me.seungwoo;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Leo.
 * User: sonseungwoo
 * Date: 2019-03-01
 * Time: 21:47
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
