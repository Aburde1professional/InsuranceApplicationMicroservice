package com.synergy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.synergy.domain.Policies;
import com.synergy.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByUserName(String userName);
	List<Policies> getPoliciesByUserName(String userName);

}