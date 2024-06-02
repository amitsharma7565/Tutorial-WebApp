package com.tut.serviceImpl;


import java.util.Collection;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import com.tut.model.Register;
import com.tut.repo.RegisterRepo;

@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private RegisterRepo userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Register user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        if (user.isAccountLocked()) {
            throw new LockedException("User account is locked");
        }
        return user;
    }

    private Collection<? extends GrantedAuthority> getAuthorities(Register user) {
        // Assuming roles or authorities are managed, else return an empty list
        return Collections.emptyList();
    }
}

