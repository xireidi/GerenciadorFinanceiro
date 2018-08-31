package br.com.xireidi.gerenciador.config.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.xireidi.gerenciador.models.Pessoa;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AppUserDetails implements UserDetails {
    private static final long serialVersionUID = -2700888391180407668L;
    private Pessoa user;

    public AppUserDetails(Pessoa user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        final List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        
        authorities.add(new SimpleGrantedAuthority("USUARIO"));
        
        return authorities;
    }

    public String getName() {
        return this.user.getNome();
    }

    public Long getID() {
        return Long.valueOf((String) this.user.getId());
    }

    @Override
    public String getPassword() {
        return this.user.getSenha();
    }

    @Override
    public String getUsername() {
        return this.user.getEmail();
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
        return this.user.getAtiva();
    }

    public Pessoa getUser() {
        return this.user;
    }

}