package com.ResourceManagement.IT.model;

import com.ResourceManagement.IT.enums.Role;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "person_type") // The column in the database table
//@JsonTypeInfo(
//        use = JsonTypeInfo.Id.NAME,
//        include = JsonTypeInfo.As.PROPERTY,
//        property = "person_type" // The JSON property name that will be used to determine the type
//)
//@JsonSubTypes({
//        @JsonSubTypes.Type(value = User.class, name = "USER"),
//        @JsonSubTypes.Type(value = Admin.class, name = "ADMIN"),
//        @JsonSubTypes.Type(value = Technician.class, name = "TECHNICIAN")
//})
public class Person implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String username;
    private String password;
    private String email;

//    @Enumerated(EnumType.STRING)
//    @ElementCollection(targetClass = Role.class)
//    @CollectionTable(name = "person_roles", joinColumns = @JoinColumn(name = "person_id"))
//    @Column(name = "roles")
//    private Set<Role> roles;

    @Enumerated(EnumType.STRING)
    private Role roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        System.out.println("////////////////////////////");
        System.out.println("////////::rolee"+roles);

        return List.of(new SimpleGrantedAuthority("ROLE_" + roles));
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
