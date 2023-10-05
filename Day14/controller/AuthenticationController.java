//package com.example.app.controller;
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.app.response.AuthenticationResponse;
//import com.example.app.service.AuthService;
//import com.example.app.constant.Api;
//import com.example.app.request.RegisterRequest;
//
//import io.swagger.v3.oas.annotations.tags.Tag;
//import lombok.RequiredArgsConstructor;
//
//@RestController
//@RequestMapping(Api.AUTH)
//@RequiredArgsConstructor
//@Tag(name = "Authentication")
//public class AuthenticationController {
//
//    private final AuthService authService;
//
//    @PostMapping("/register")
//    public ResponseEntity<String> register(@RequestBody RegisterRequest request) {
//        boolean isRegistered = authService.userRegistration(request);
//        return isRegistered ? ResponseEntity.ok("User registered successfully")
//                : ResponseEntity.badRequest().body("Sommething went wrong!");
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
//        return ResponseEntity.ok(authService.userAuthentication(request));
//    }
//}
