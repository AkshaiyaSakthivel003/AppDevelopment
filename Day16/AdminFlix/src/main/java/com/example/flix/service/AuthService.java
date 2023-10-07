//package com.example.flix.service;
//
//
//
//import java.util.Optional;
//
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import com.example.flix.response.AuthenticationResponse;
//import com.example.flix.request.AuthenticationRequest;
//import com.example.flix.model.Login;
//import com.example.flix.model.enumerate.Role;
//import com.example.flix.repository.LoginRepository;
//import com.example.flix.request.RegisterRequest;
//import com.example.flix.util.JwtUtil;
//
//import jakarta.transaction.Transactional;
//import lombok.RequiredArgsConstructor;
//
//@Service
//@Transactional
//@RequiredArgsConstructor
//public class AuthService implements AuthServiceInt{
//
//    private final LoginRepository userRepository;
//    private final PasswordEncoder passwordEncoder;
//    private final AuthenticationManager authenticationManager;
//    private final JwtUtil jwtUtil;
//
//    @Override
//    public boolean userRegistration(RegisterRequest request) {
//        Optional<Login> isUserExists = userRepository.findByEmail(request.getEmail());
//        if (!isUserExists.isPresent()) {
//            var user = Login.builder()
//                    .name(request.getName())
//                    .email(request.getEmail())
//                    .password(passwordEncoder.encode(request.getPassword()))
//                    .isEnabled(true)
//                    .role(Role.valueOf(request.getRole().toUpperCase()))
//                    .build();
//            userRepository.save(user);
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    @Override
//    public AuthenticationResponse userAuthentication(AuthenticationRequest request) {
//        authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
//        var user = userRepository.findByEmail(request.getEmail()).orElseThrow();
//        var token = jwtUtil.generateToken(user);
//        return AuthenticationResponse.builder()
//                .token(token)
//                .uid(user.getUid())
//                .build();
//    }
//}
