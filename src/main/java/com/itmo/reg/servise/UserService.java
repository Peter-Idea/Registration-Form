package com.itmo.reg.servise;

import com.itmo.reg.entity.Course;
import com.itmo.reg.entity.Role;
import com.itmo.reg.entity.User;
import com.itmo.reg.repository.CourseRepository;
import com.itmo.reg.repository.RoleRepository;
import com.itmo.reg.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    CourseService courseService;
    @PersistenceContext
    private EntityManager em;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return user;
    }

    public User findUserById(Long userId) {
        Optional<User> userFromDb = userRepository.findById(userId);
        return userFromDb.orElse(new User());
    }

    public List<User> allUsers() {
        return userRepository.findAll();
    }

    public boolean saveUser(User user) {
        User userFromDB = userRepository.findByUsername(user.getUsername());

        if (userFromDB != null) {
            return false;
        }

        user.setRoles(Collections.singleton(new Role(1L, "ROLE_USER")));
        user.setPassword(
                bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return true;
    }

    public boolean setUserCourse(String username, Long courseId) {
        User userFromDB = userRepository.findByUsername(username);


        Course courseFromDB = courseService.findCourseById(courseId);
        userFromDB.getCourses().add(courseFromDB);
        userRepository.save(userFromDB);
        return true;
    }


    public boolean resaveUser(User user) {
        User userFromDB = userRepository.findByUsername(user.getUsername());

        if ((user.getFirstname() != null)
                && (!user.getFirstname().isEmpty())) {
            userFromDB.setFirstname(user.getFirstname());
        }


        if ((user.getMiddlename() != null)
                && (!user.getMiddlename().isEmpty())) {
            userFromDB.setMiddlename(user.getMiddlename());
        }


        if (user.getLastname() != null) {
            userFromDB.setLastname(user.getLastname());
        }


        if ((user.getEmail() != null)
                && (!user.getEmail().isEmpty())) {
            userFromDB.setEmail(user.getEmail());
        }


        if ((user.getPhone() != null)
                && (!user.getPhone().isEmpty())) {
            userFromDB.setPhone(user.getPhone());
        }

        if ((user.getRoles() != null)
                && (!user.getRoles().isEmpty())) {
            userFromDB.setRoles(Collections.singleton(new Role(1L, "ROLE_USER")));
        }

        if ((user.getPassword() != null)
                && (!user.getPassword().isEmpty())) {
            userFromDB.setPassword(
                    bCryptPasswordEncoder.encode(user.getPassword()));
        }

        userRepository.save(userFromDB);
        return true;
    }

    public Set<Course> getUserCourses(String username) {
        User userFromDB = userRepository.findByUsername(username);
        return userFromDB.getCourses();

    }

    public boolean deleteUser(Long userId) {
        if (userRepository.findById(userId).isPresent()) {
            userRepository.deleteById(userId);
            return true;
        }
        return false;
    }

    public List<User> usergtList(Long idMin) {
        return em.createQuery("SELECT u FROM User u WHERE u.id > :paramID"
                , User.class)
                .setParameter("paramId", idMin).getResultList();

    }
}
