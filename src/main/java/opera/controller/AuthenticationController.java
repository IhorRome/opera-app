package opera.controller;

import java.util.Set;
import javax.validation.Valid;
import opera.dto.request.UserRequestDto;
import opera.dto.response.UserResponseDto;
import opera.model.Role;
import opera.model.User;
import opera.service.AuthenticationService;
import opera.service.RoleService;
import opera.service.UserService;
import opera.service.mapper.UserMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private final AuthenticationService authService;
    private final UserMapper userMapper;
    private final RoleService roleService;
    private final UserService userService;

    public AuthenticationController(AuthenticationService authService,
                                    UserMapper userMapper,
                                    RoleService roleService,
                                    UserService userService) {
        this.authService = authService;
        this.userMapper = userMapper;
        this.roleService = roleService;
        this.userService = userService;
    }

    @PostMapping("/register")
    public UserResponseDto register(@RequestBody @Valid UserRequestDto requestDto) {
        User user = authService.register(requestDto.getEmail(), requestDto.getPassword());
        return userMapper.mapToDto(user);
    }

    @GetMapping("/inject")
    public void inject() {
        Role adminRole = new Role();
        adminRole.setRoleName("ADMIN");
        roleService.add(adminRole);
        Role userRole = new Role();
        userRole.setRoleName("USER");
        roleService.add(userRole);
        User user = new User();
        user.setEmail("admin@i.ua");
        user.setPassword("admin123");
        user.setRoles(Set.of(adminRole));
        userService.add(user);
    }
}
