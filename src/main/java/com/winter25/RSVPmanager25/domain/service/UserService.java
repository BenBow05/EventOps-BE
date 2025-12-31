package com.winter25.RSVPmanager25.domain.service;

import com.winter25.RSVPmanager25.domain.model.dto.UserDto;
import com.winter25.RSVPmanager25.exception.PermissionDeniedException;
import com.winter25.RSVPmanager25.exception.ResourceNotFoundException;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;

public interface UserService {

    List<UserDto> getAllUsers(Collection<GrantedAuthority> authorities)
            throws PermissionDeniedException;

    UserDto getSelf(String email) throws ResourceNotFoundException;

    UserDto getUser(Integer id, Collection<GrantedAuthority> authorities)
            throws PermissionDeniedException, ResourceNotFoundException;

    UserDto getUser(String email, Collection<GrantedAuthority> authorities)
            throws PermissionDeniedException, ResourceNotFoundException;

}
