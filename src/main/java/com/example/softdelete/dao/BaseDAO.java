package com.example.softdelete.dao;

import com.example.softdelete.entity.BaseEntity;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

public interface BaseDAO<T extends BaseEntity> {
}
