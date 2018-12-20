package com.example.softdelete.service;


import com.example.softdelete.entity.PersonelGorev;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public interface PersonelGorevService {
    PersonelGorev kaydet(PersonelGorev personelGorev);
}
