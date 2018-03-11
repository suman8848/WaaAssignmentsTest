package com.example.coffeeshop.repository;

import com.example.coffeeshop.domain.Authorities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthoritiesRepository extends JpaRepository<Authorities,Integer>{


}
