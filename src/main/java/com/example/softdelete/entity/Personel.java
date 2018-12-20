package com.example.softdelete.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="personel")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
@SQLDelete(sql = "UPDATE personel SET aktif = 0 WHERE id = ?", check = ResultCheckStyle.COUNT)
//@Where(clause = "aktif <> 0")
public class Personel extends BaseEntity implements Serializable {

    @Column(name="ad")
    private String ad;

    @OneToMany(
            mappedBy = "personel",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<PersonelGorev> personelGorevList=new HashSet<>();

    public Personel() {

    }


    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public Set<PersonelGorev> getPersonelGorevList() {
        return personelGorevList;
    }

    public void setPersonelGorevList(Set<PersonelGorev> personelGorevList) {
        this.personelGorevList = personelGorevList;
    }

    public void addGorev(PersonelGorev personelGorev) {
        personelGorevList.add(personelGorev);
        personelGorev.setPersonel(this);
    }

    public void removeGorev(PersonelGorev personelGorev) {
        personelGorevList.remove(personelGorev);
        personelGorev.setPersonel(null);
    }

    @PreRemove
    public void delete() {
        this.setAktif(0);
    }

}
