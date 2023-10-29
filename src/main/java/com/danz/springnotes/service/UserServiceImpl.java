package com.danz.springnotes.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.danz.springnotes.dao.UserDao;
import com.danz.springnotes.model.UserNotes;
import com.danz.springnotes.request.RegisterRequest;

@Service("userService")
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserNotes> user = userDao.findByUsername(username);

        if (user.isPresent()) {
            UserNotes u = user.get();
            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(u.getRole().getRoleName().toUpperCase()));
            UserDetails userDetails = org.springframework.security.core.userdetails.User.withUsername(u.getUsername())
                    .authorities(authorities).build();
            return userDetails;
        } else {
            throw new UsernameNotFoundException(username + " not found");
        }
    }

    public String saveUser(RegisterRequest register) {
        UserNotes userNotes = new UserNotes();
        userNotes.setUsername(register.getUsername());
        userNotes.setPassword(passwordEncoder.encode(register.getPassword()));
        userNotes.setRole(register.getRole());
        UserNotes user = userDao.save(userNotes);

        if (user != null) {
            return "Success add user";
        } else {
            return "Failed to save new user";
        }

    }
}
