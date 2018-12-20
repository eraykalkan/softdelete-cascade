package com.example.softdelete.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.stereotype.Controller;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="personel_gorev")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
@SQLDelete(sql = "UPDATE personel_gorev SET aktif = 0 WHERE id = ?", check = ResultCheckStyle.COUNT)
//@Where(clause = "aktif <> 0")
public class PersonelGorev extends BaseEntity implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "personel_id")
    private Personel personel;

    @Column(name="gorev_adi")
    private String gorevAdi;

    public PersonelGorev() {

    }

    public PersonelGorev(Personel personel, String gorevAdi) {
        this.personel = personel;
        this.gorevAdi = gorevAdi;
    }

    public String getGorevAdi() {
        return gorevAdi;
    }

    public void setGorevAdi(String gorevAdi) {
        this.gorevAdi = gorevAdi;
    }

    public Personel getPersonel() {
        return personel;
    }

    public void setPersonel(Personel personel) {
        this.personel = personel;
    }

    @PreRemove
    public void delete() {
        this.setAktif(0);
    }
}
