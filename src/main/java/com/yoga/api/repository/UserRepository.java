package com.yoga.api.repository;

import com.yoga.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByIsActive(boolean b);

    User findByIsActiveAndPhoneNo(boolean b, String phoneNo);

    User findByIsActiveAndEmailId(boolean b, String emailId);
}
