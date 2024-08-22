package org.example.servicerelocation.entity;


import jakarta.persistence.*;
import org.example.servicerelocation.dto.Role;

import java.util.Objects;

/**     * Сущность пользователя     */
@Entity
@Table(name = "users")
public class UserEntity {
    public UserEntity(Integer id, String name, String email, String password, Role role) {
        this.id = id;
        Name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public UserEntity() {
    }

    /** id пользователя     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    /** Имя пользователя     */
    @Column(name = "name")
    private String Name;

    /**     * почта пользователя     */
    @Column(name = "email")
    private String email;

    /**     * пароль пользователя     */
    @Column(name = "password")
    private String password;

    /**     * роль пользователя     */
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(Name, that.Name) && Objects.equals(email, that.email) && Objects.equals(password, that.password) && role == that.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, Name, email, password, role);
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
