package org.proyecto.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import javax.persistence.*;
import java.sql.Date;
import java.io.Serializable;
import io.quarkus.security.jpa.*;

@Entity
public class User extends PanacheEntity {

    @Column(unique = true) 
    public String username;

    @Password
    public String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}