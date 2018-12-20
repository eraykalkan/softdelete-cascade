package com.example.softdelete.service;

import com.example.softdelete.dao.PersonelGorevDAO;
import com.example.softdelete.entity.PersonelGorev;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class PersonelGorevServiceImpl implements PersonelGorevService {

    @Autowired
    private PersonelGorevDAO personelGorevDAO;

    @Override
    public PersonelGorev kaydet(PersonelGorev personelGorev) {
        return personelGorevDAO.save(personelGorev);
    }
}
