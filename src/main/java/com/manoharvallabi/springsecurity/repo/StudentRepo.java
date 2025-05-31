package com.manoharvallabi.springsecurity.repo;

import com.manoharvallabi.springsecurity.model.Student;
import com.manoharvallabi.springsecurity.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Users, Integer> {

}
