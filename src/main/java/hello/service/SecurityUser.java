package hello.service;

import hello.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by skyADMIN on 16/2/1.
 */
public class SecurityUser extends User implements UserDetails {
    public SecurityUser(User user){
        if (user != null){
            this.setMail(user.getMail());
            this.setPassword(user.getPassword());

        }
    }

    @Override
    public String getUsername() {
        return super.getMail();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("user");
        authorities.add(authority);
        return authorities;
    }

    public String getPassword(){
        return super.getPassword();
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
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
