package com.example.coffeeshop.service;

import com.example.coffeeshop.domain.Authorities;
import com.example.coffeeshop.repository.AuthoritiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AuthorityService {

    @Autowired
    private AuthoritiesRepository authoritiesRepository;

    public Authorities saveAuthorities(Authorities authorities){
        return authoritiesRepository.save(authorities);
    }

    public Authorities getAuthorityById(int id){
        return authoritiesRepository.findOne(id);
    }

    public void removeAuthority(Authorities authorities){
        authoritiesRepository.delete(authorities);
    }
}
