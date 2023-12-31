//package com.example.app.service;
//
//import java.util.Optional;
//
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//import com.example.app.request.RegisterRequest;
//import com.example.app.request.AuthenticationRequest;
//
//import com.example.app.model.User;
//import com.example.app.repository.UserRepository;
//import com.example.app.response.AuthenticationResponse;
//import com.example.app.util.JwtUtil;
//
//import jakarta.transaction.Transactional;
//import lombok.RequiredArgsConstructor;
//
//@Service
//@Transactional
//@RequiredArgsConstructor
//public class AuthService {
//
//    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;
//    private final AuthenticationManager authenticationManager;
//    private final JwtUtil jwtUtil;
//
//    @Override
//    public boolean userRegistration(RegisterRequest request) {
//        Optional<User> isUserExists = userRepository.findByEmail(request.getEmail());
//        if (!isUserExists.isPresent()) {
//            var user = User.builder()
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
//                .build();
//    }
//}
