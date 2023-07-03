package com.synergy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.synergy.domain.User;

@Repository
public interface UserPolicyRepository extends JpaRepository<User, Long> {

}