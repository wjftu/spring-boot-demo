package jdbc.service;

import jdbc.entity.User;
import jdbc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> findById(Long id){
        return userRepository.findById(id);
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public int insert(String username, Integer age){
        return userRepository.insert(username, age);
    }

    public int update(Long id, String username, Integer age){
        return userRepository.update(id, username, age);
    }

    public int delete(Long id){
        return userRepository.delete(id);
    }
}
