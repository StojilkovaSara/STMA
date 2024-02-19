package com.example.task.service;

import com.example.task.entity.StudentEntity;
import com.example.task.entity.TaskEntity;
import com.example.task.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentService implements UserDetailsService {

    private final StudentRepository studentRepository;
    private final PasswordEncoder passwordEncoder;

    public void registerNewStudent(String firstName, String lastName, String username, String password) throws Exception {
        if (studentRepository.findByUsername(username).isPresent()) {
            throw new Exception("Username already exists");
        }
        StudentEntity student = studentRepository.save(new StudentEntity(username, firstName, lastName, passwordEncoder.encode(password)));
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<StudentEntity> user = studentRepository.findByUsername(username);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException(username);
        }

        List<GrantedAuthority> authorities = new ArrayList<>();

        authorities.add(new SimpleGrantedAuthority("USER"));

        return new User(user.get().getUsername(), user.get().getPassword(), authorities);
    }
}
