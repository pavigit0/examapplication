package com.online.exam.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.online.exam.dao.CandidateDAO;
import com.online.exam.entity.Candidate;


@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private CandidateDAO cDAO;
	
//	@Autowired
//	private JwtTokenUtil jwtTokenUtil;
	
//	@Autowired
//	private AuthenticationManager authenticationManager;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
		Candidate c= cDAO.findByEmail(username);
		if (c == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(c.geteMail(), c.getPassword(),
				getAuthority(c));
	}
	private Set getAuthority(Candidate user) {
        Set authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + "CANDIDATE"));
        return authorities;
  
	}
	
//	public JwtResponse createJwtToken(JwtRequest jwtRequest) throws Exception {
//        String userName = jwtRequest.getUsername();
//        String userPassword = jwtRequest.getPassword();
//        authenticate(userName, userPassword);
//
//        UserDetails userDetails = loadUserByUsername(userName);
//        String newGeneratedToken = jwtTokenUtil.generateToken(userDetails);
//
//        return new JwtResponse(newGeneratedToken);
//  }
//	private void authenticate(String userName, String userPassword) throws Exception {
//        try {
//               authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, userPassword));
//        } catch (DisabledException e) {
//               throw new Exception("USER_DISABLED", e);
//        } catch (BadCredentialsException e) {
//               throw new Exception("INVALID_CREDENTIALS", e);
//        }
//  }


}
