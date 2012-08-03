package za.co.trf.recurly.sample.domain;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(table = "user")
public class User implements UserDetails, CredentialsContainer {

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "email")
    private String email;

    @Size(max = 100)
    @Column(name = "password")
    private String password;

    @Column(name = "account_code")
    private String accountCode;

    @NotNull
    @Enumerated(EnumType.ORDINAL)
    private UserRole role;

    public User() {
    }

    public User(String name, UserRole role, String email, String password) {
        this.name = name;
        this.role = role;
        this.email = email;
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.unmodifiableCollection(Collections.singleton(new SimpleGrantedAuthority(role.name())));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return password != null;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public void eraseCredentials() {
        password = null;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof User && this.getUsername().equals(((User) o).getUsername());
    }

    @Override
    public int hashCode() {
        return this.getUsername().hashCode() * 31;
    }

}
