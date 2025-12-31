package com.winter25.RSVPmanager25.domain.repository;

import com.winter25.RSVPmanager25.domain.model.entity.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    Optional<UserEntity> findByEmail(String email);
    boolean existsByEmail(String email);


}
