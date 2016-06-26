package edu.whu.irlab.model;

import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class User implements Serializable{
    private Integer id;

    private String username;

    private String password;

    private String salt;

    private Boolean locked;

    private Set<Role> roles;

    private Set<String> rolesStr;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @NotBlank(message = "{user.username.notBlank}")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    // @NotBlank(message = "{user.password.notBlank}")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<String> getRolesStr() {
        Set<String> rolesStr = null;
        if (roles != null && roles.size()>0){
            rolesStr = new HashSet<>();
            for (Role role: roles){
                rolesStr.add(role.getRole());
            }
        }
        return rolesStr;
    }

}