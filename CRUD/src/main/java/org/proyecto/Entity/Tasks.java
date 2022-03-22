package org.proyecto.Entity;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import javax.persistence.*;
import java.sql.Date;
import java.io.Serializable;
import java.util.Set;
@Entity
public class Tasks extends PanacheEntity {

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "UserId", insertable = false, updatable = false)
    public User user;

    @Column(unique = true) 
    public Long userid;

    public String description;

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}