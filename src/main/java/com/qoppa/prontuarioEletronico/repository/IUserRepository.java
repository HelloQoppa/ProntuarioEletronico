package com.qoppa.prontuarioEletronico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.qoppa.prontuarioEletronico.models.Users;


public interface IUserRepository extends JpaRepository<Users, Long> {


    UserDetails findByLogin(String login);

}
