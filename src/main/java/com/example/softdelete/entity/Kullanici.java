package com.example.softdelete.entity;

import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name="kullanici")
@SQLDelete(sql = "UPDATE kullanici SET aktif = 0 WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "aktif <> 0")
public class Kullanici extends BaseEntity{

    @Column(name="user_name")
    private String username;

    @Column(name="last_name")
    private String lastname;

    public Kullanici() {

    }

    public Kullanici(String username, String lastname) {
        this.username = username;
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kullanici user = (Kullanici) o;
        return Objects.equals(username, user.username) &&
                Objects.equals(lastname, user.lastname);
    }

    @Override
    public int hashCode() {

        return Objects.hash(username, lastname);
    }

    @Override
    public String toString() {
        return "Kullanici{" +
                "username='" + username + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
