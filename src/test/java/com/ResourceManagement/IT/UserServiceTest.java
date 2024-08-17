package com.ResourceManagement.IT;

import com.ResourceManagement.IT.model.User;
import com.ResourceManagement.IT.repository.UserRepository;
import com.ResourceManagement.IT.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    private User testUser;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        testUser = new User();
        testUser.setId(1);
        testUser.setName("said");
        testUser.setUsername("talfana");
        testUser.setEmail("saidtalfana@gmail.com");
        testUser.setPassword("123");
    }

    @Test
    void testDeleteUser() {
        userService.deleteUser(testUser.getId());
        verify(userRepository, times(1)).deleteById(Long.valueOf(testUser.getId()));
    }

    @Test
    void testFindAll() {
        List<User> users = new ArrayList<>();
        users.add(testUser);

        when(userRepository.findAll()).thenReturn(users);

        List<User> result = userService.findAll();
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(testUser, result.get(0));
    }

    @Test
    void testUpdateUser() {
        User updatedUser = new User();
        updatedUser.setId(1);
        updatedUser.setName("youssef");
        updatedUser.setUsername("talfanayoussef");
        updatedUser.setEmail("yousseftalfana@gmail.com");
        updatedUser.setPassword("4321");

        when(userRepository.findById(Long.valueOf(testUser.getId()))).thenReturn(Optional.of(testUser));

        when(userRepository.save(any(User.class))).thenReturn(updatedUser);

        User result = userService.updateUser(updatedUser, testUser.getId());

        assertNotNull(result);
        assertEquals("youssef", result.getName());
        assertEquals("talfanayoussef", result.getUsername());
        assertEquals("yousseftalfana@gmail.com", result.getEmail());
        assertEquals("4321", result.getPassword());
    }
}
