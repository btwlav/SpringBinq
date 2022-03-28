package com.spring.first.repos;

import com.spring.first.entity.Group;
import com.spring.first.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface GroupRepo extends CrudRepository<Group, Integer> {
    Group findById(int id);
    Group findByNameContaining(String name);
}
