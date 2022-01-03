package mk.ukim.finki.lab.service.impl;

import mk.ukim.finki.lab.model.User;
import mk.ukim.finki.lab.model.exceptions.*;
import mk.ukim.finki.lab.repository.jpa.UserRepository;
import mk.ukim.finki.lab.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User login(String username, String password) {
        if (username==null || username.isEmpty() || password==null || password.isEmpty()) {
            throw new InvalidArgumentsException();
        }
        return this.userRepository.findByUsernameAndPassword(username, password)
                .orElseThrow(()->new InvalidUserCredentialsException());
    }

    @Override
    public User register(String username, String password, String repeatPassword, String name, String surname, String dateOfBirth) {

        if (username==null || username.isEmpty()  || password==null || password.isEmpty())
            throw new InvalidUsernameOrPasswordException();
        if (!password.equals(repeatPassword))
            throw new PasswordsDoNotMatchException();
        if(this.userRepository.findByUsername(username).isPresent())
            throw new UsernameAlreadyExistsException(username);
        User user = new User(username,password,name, surname, dateOfBirth);
        return userRepository.save(user);

    }
}
