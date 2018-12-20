package com.example.softdelete.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="universite")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
@SQLDelete(sql = "UPDATE universite SET state = aktif WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "aktif <> 0")
public class Universite extends BaseEntity implements Serializable {

    @Column(name="universite_adi")
    private String universiteAdi;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "universite_bolum",
            joinColumns = @JoinColumn(name = "universite_id"),
            inverseJoinColumns = @JoinColumn(name = "bolum_id")
    )
    private List<Bolum> bolumList = new ArrayList<>();

    public Universite(){

    }

    public Universite(String universiteAdi) {
        this.universiteAdi = universiteAdi;
    }

    public void addBolum(Bolum bolum) {
        bolumList.add(bolum);
        bolum.getUniversiteList().add(this);
    }

    public void removeBolum(Bolum bolum) {
        bolumList.remove(bolum);
        bolum.getUniversiteList().remove(this);
    }

    public String getUniversiteAdi() {
        return universiteAdi;
    }

    public void setUniversiteAdi(String universiteAdi) {
        this.universiteAdi = universiteAdi;
    }

    public List<Bolum> getBolumList() {
        return bolumList;
    }

    public void setBolumList(List<Bolum> bolumList) {
        this.bolumList = bolumList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Universite that = (Universite) o;
        return Objects.equals(universiteAdi, that.universiteAdi) &&
                Objects.equals(bolumList, that.bolumList);
    }

    @Override
    public int hashCode() {

        return Objects.hash(universiteAdi, bolumList);
    }

    @Override
    public String toString() {
        return "Universite{" +
                "universiteAdi='" + universiteAdi + '\'' +
                ", bolumList=" + bolumList +
                '}';
    }
}