package com.shabab.rhythm.foodservice.demo.repositories;


import com.shabab.rhythm.foodservice.demo.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface RoleRepository extends JpaRepository<Role, Long>{
}
