package kanimstv.rest_controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kanimstv.configuration.security.jwt.JwtUtils;
import kanimstv.configuration.security.services.MemberDetailsImpl;
import kanimstv.dao.entities.MemberIncubatorEntity;
import kanimstv.dao.entities.RolePermissionEntity;
import kanimstv.dao.repositories.MemberIncubatorRepository;
import kanimstv.dao.repositories.RolePermissionRepository;
import kanimstv.payload.response.JwtResponse;
import kanimstv.payload.response.MessageResponse;
import kanimstv.playload.request.LoginRequest;
import kanimstv.playload.request.SignupRequest;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthService {

    @Autowired
    AuthenticationManager authenticationManager;
    
    @Autowired
    MemberIncubatorRepository memberRepository;
    
    @Autowired
    RolePermissionRepository rolePermissionRepository;
    
    @Autowired
    PasswordEncoder encoder;
    
    @Autowired
    JwtUtils jwtUtils;
    
    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
	
	Authentication authentication = authenticationManager.authenticate(
		new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
	
	SecurityContextHolder.getContext().setAuthentication(authentication);
	
	String jwt = jwtUtils.generateJwtToken(authentication);

	MemberDetailsImpl memberDetails = (MemberDetailsImpl) authentication.getPrincipal();		
	
	List<String> roles = memberDetails.getAuthorities().stream()
		.map(item -> item.getAuthority())
		.collect(Collectors.toList());
	
	return ResponseEntity.ok(new JwtResponse(jwt, 
		memberDetails.getId(), 
		memberDetails.getPseudonyme(), 
		memberDetails.getEmail(), 
		roles));
    }
    
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
	if (memberRepository.existsByPseudonyme(signUpRequest.getPseudonyme())) {
	    return ResponseEntity
		    .badRequest()
		    .body(new MessageResponse("Error: Pseudonyme is already taken!"));
	}
	if (memberRepository.existsByEmail(signUpRequest.getEmail())) {
	    return ResponseEntity
		    .badRequest()
		    .body(new MessageResponse("Error: Email is already in use!"));
	}

	// Create new user's account
	MemberIncubatorEntity member = new MemberIncubatorEntity(
		signUpRequest.getPseudonyme(),
		signUpRequest.getEmail(),
		"0123456789",
		false,
		encoder.encode(signUpRequest.getPassword()));
	Set<String> strRoles = signUpRequest.getRole();
	Set<RolePermissionEntity> roles = new HashSet<>();
	if (strRoles == null) {
	    RolePermissionEntity userRole = rolePermissionRepository.findByName("ROLE_VISU")
		    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
	    roles.add(userRole);
	} else {
	    strRoles.forEach(role -> {
		switch (role) {
		case "admin":
		    RolePermissionEntity adminRole = rolePermissionRepository.findByName("ROLE_ADMIN")
		    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		    roles.add(adminRole);
		    break;
		case "rh":
		    RolePermissionEntity modRole = rolePermissionRepository.findByName("ROLE_RH")
		    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		    roles.add(modRole);
		    break;
		default:
		    RolePermissionEntity userRole = rolePermissionRepository.findByName("ROLE_VISU")
		    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		    roles.add(userRole);
		}
	    });
	}
	member.setRolesPermission(roles);
	memberRepository.save(member);
	return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
}
