package com.mobiauto.entites;

import com.mobiauto.entites.enums.Cargo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_usuario")
public class Usuario implements UserDetails, Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true)
    private String email;

    private String senha;

    @ManyToOne//varios usuarios tem uma revenda
    @JoinColumn(name = "revenda_id")
    private Revenda revenda;

    // Mapeamento do cargo para a tabela tb_usuario_cargo
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "tb_usuario_cargo", joinColumns = @JoinColumn(name = "usuario_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "cargo")
    private Set<Cargo> cargo = new HashSet<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return cargo.stream()
                .map(cargo -> new SimpleGrantedAuthority("ROLE_" + cargo.name()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return senha;
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
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
