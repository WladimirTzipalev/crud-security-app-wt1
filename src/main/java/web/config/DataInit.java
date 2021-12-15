package web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import web.model.Role;
import web.model.User;
import web.service.RoleService;
import web.service.UserService;
import javax.annotation.PostConstruct;

@Component
public class DataInit {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @PostConstruct
    private void init() {
        Role role1 = new Role("ADMIN");
        Role role2 = new Role("USER");
        roleService.saveRole(role1);
        roleService.saveRole(role2);

        User user0 = new User();
        user0.setEmail("admin@gmail.com");
        user0.setPassword("admin");
        user0.setName("Admin");
        user0.setSurname("Adminov");
        user0.setAge((byte) 33);
        user0.addRole(role1);

        User user1 = new User();
        user1.setEmail("user@gmail.com");
        user1.setPassword("user");
        user1.setName("User");
        user1.setSurname("Userov");
        user1.setAge((byte) 33);
        user1.addRole(role2);

        User user2 = new User();
        user2.setEmail("moderator@gmail.com");
        user2.setPassword("moderator");
        user2.setName("Moderator");
        user2.setSurname("Moderatorov");
        user2.setAge((byte) 33);
        user2.addRole(role1);
        user2.addRole(role2);

        userService.save(user0);
        userService.save(user1);
        userService.save(user2);
    }
}
