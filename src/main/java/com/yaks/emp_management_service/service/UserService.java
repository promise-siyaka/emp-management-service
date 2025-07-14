package com.yaks.emp_management_service.service;

import com.yaks.emp_management_service.dtos.CustomUserDetails;
import com.yaks.emp_management_service.entities.Users;
import com.yaks.emp_management_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return CustomUserDetails.builder().password(user.getPassword()).username(username).role(user.getRole()).build();
    }

    public Long getUserId(){
        Users user = userRepository.findByUsername(getCurrentUserIdFromContext())
                .orElseThrow(() -> new RuntimeException("User not found"));
        return  user.getId();
    }

    public String getCurrentUserIdFromContext() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof UserDetails userDetails) {
            if (userDetails instanceof CustomUserDetails) {
                return userDetails.getUsername();
            }
        }
        return "";
    }
}
