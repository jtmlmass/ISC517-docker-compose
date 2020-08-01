package com.pucmm.composerprogram.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table
public class User implements Serializable {
    @Id
    private String username;
    private String password;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Rol> roles;
    private boolean active;

    public boolean isAdmin() {
        boolean isAdmin = false;
        for(Rol rol : this.roles) {
            if (rol.getRole().equals("ROLE_ADMIN")) {
                isAdmin = true;
                break;
            }
        }
        return isAdmin;
    }
}
