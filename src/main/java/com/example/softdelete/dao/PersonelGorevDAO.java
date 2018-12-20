package com.example.softdelete.dao;

import com.example.softdelete.entity.Personel;
import com.example.softdelete.entity.PersonelGorev;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonelGorevDAO extends CrudRepository<PersonelGorev,Long>,BaseDAO<PersonelGorev>{
}
