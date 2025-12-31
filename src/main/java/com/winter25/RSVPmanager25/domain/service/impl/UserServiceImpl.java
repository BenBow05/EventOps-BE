package com.winter25.RSVPmanager25.domain.service.impl;

import com.winter25.RSVPmanager25.domain.model.dto.UserDto;
import com.winter25.RSVPmanager25.domain.model.entity.UserEntity;
import com.winter25.RSVPmanager25.domain.repository.UserRepository;
import com.winter25.RSVPmanager25.domain.service.UserService;
import com.winter25.RSVPmanager25.exception.PermissionDeniedException;
import com.winter25.RSVPmanager25.exception.ResourceNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<UserDto> getAllUsers(Collection<GrantedAuthority> authorities)
            throws PermissionDeniedException {

        if (authorities.stream().anyMatch(authority -> authority.getAuthority().equals("EMPLOYEE"))) {
            throw new PermissionDeniedException("Permission denied");
        }

        List<UserEntity> userEntities = userRepository.findAll();

        return userEntities.stream()
                .map(this::mapUser)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto getSelf(String email) throws ResourceNotFoundException {
        Optional<UserEntity> user = userRepository.findByEmail(email);
        if (user.isEmpty()) throw new ResourceNotFoundException("User not found");

        return mapUser(user.get());
    }

    @Override
    public UserDto getUser(Integer id, Collection<GrantedAuthority> authorities)
            throws PermissionDeniedException, ResourceNotFoundException {

        if (authorities.stream().anyMatch(authority -> authority.getAuthority().equals("EMPLOYEE"))) {
            throw new PermissionDeniedException("Permission denied");
        }

        Optional<UserEntity> user = userRepository.findById(id);
        if (user.isEmpty()) throw new ResourceNotFoundException("User not found");

        return mapUser(user.get());
    }

    @Override
    public UserDto getUser(String email, Collection<GrantedAuthority> authorities)
            throws PermissionDeniedException, ResourceNotFoundException {

        if (authorities.stream().anyMatch(authority -> authority.getAuthority().equals("EMPLOYEE"))) {
            throw new PermissionDeniedException("Permission denied");
        }

        Optional<UserEntity> user = userRepository.findByEmail(email);
        if (user.isEmpty()) throw new ResourceNotFoundException("User not found");

        return mapUser(user.get());
    }

    private UserDto mapUser(UserEntity userEntity) {
        return modelMapper.map(userEntity, UserDto.class);
    }

}
