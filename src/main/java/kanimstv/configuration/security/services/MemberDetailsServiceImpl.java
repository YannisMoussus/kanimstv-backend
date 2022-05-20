package kanimstv.configuration.security.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kanimstv.dao.entities.MemberIncubatorEntity;
import kanimstv.dao.repositories.MemberIncubatorRepository;

@Service
public class MemberDetailsServiceImpl implements UserDetailsService {
	@Autowired
	MemberIncubatorRepository memberRepository;
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		MemberIncubatorEntity member = memberRepository.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with email: " + email));
		return MemberDetailsImpl.build(member);
	}
}