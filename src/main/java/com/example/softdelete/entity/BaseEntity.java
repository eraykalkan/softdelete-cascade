package com.example.softdelete.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
public class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="eklenme_tarihi")
    @CreationTimestamp
    private Date eklenmeTarihi;

    @Column(name="aktif")
    private int aktif=1;

    protected BaseEntity() {
        id=null;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getEklenmeTarihi() {
        return eklenmeTarihi;
    }

    public void setEklenmeTarihi(Date eklenmeTarihi) {
        this.eklenmeTarihi = eklenmeTarihi;
    }

    public int getAktif() {
        return aktif;
    }

    public void setAktif(int aktif) {
        this.aktif = aktif;
    }
}
