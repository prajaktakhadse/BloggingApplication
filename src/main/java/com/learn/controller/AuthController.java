package com.learn.controller;

//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.learn.exception.ApiException;
//import com.learn.payload.JwtAuthRequest;
//import com.learn.payload.JwtAuthResponse;
//import com.learn.security.JwtTokenHelper;
//import com.learn.service.UserService;

//@RestController
//@RequestMapping("/api/v1/auth")
public class AuthController {
  
	
//	@Autowired
//	private JwtTokenHelper jwtTokenHelper;
//
//	@Autowired
//	private UserDetailsService userDetailsService;
//
//	@Autowired
//	private AuthenticationManager authenticationManager;
//
////	@Autowired
////	private UserService userService;
////	
////	@Autowired
////	private ModelMapper mapper;
//	
//	
//	@PostMapping("/login")
//	public ResponseEntity<JwtAuthResponse> createToken(@RequestBody JwtAuthRequest request)throws Exception{
//		
//		this.authenticate(request.getUsername(), request.getPassword());
//		
//		//load userDetails
//		UserDetails userDetails = this.userDetailsService.loadUserByUsername(request.getUsername());
//		//generate token
//		System.out.println(userDetails.getUsername()+ " " + userDetails.getPassword());
//		String token = this.jwtTokenHelper.generateToken(userDetails);
//		
//		JwtAuthResponse response = new JwtAuthResponse();
//		response.setToken(token);
//	
//		return new ResponseEntity<JwtAuthResponse>(response, HttpStatus.OK);
//		
//	}
//	
//	
//	
//	
//	private void authenticate(String username, String password) throws Exception {
//
//		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username,
//				password);
//
//		try {
//
//			this.authenticationManager.authenticate(authenticationToken);
//
//		} catch (BadCredentialsException  e) {
//			System.out.println("Invalid Detials !!");
//			throw new ApiException("Invalid username or password !!");
//		}
//
//	}
}
