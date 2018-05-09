package forbeatdev.userrestapi.controller;
/**Using this fjr managing requests. Minimal style*/
import forbeatdev.userrestapi.util.OuterRequest;
import forbeatdev.userrestapi.util.StatusAnswer;
import forbeatdev.userrestapi.model.User;
import forbeatdev.userrestapi.util.UserStatus;
import forbeatdev.userrestapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    /**Create a new user*/
    @PostMapping("/user")
    public Long addUser(@Valid @RequestBody User user){
        OuterRequest.sendRequest();
        return userRepository.save(user).getId();
    }

    /**There must be verification of existence*/
    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUser(@PathVariable(value = "id") Long id){
        OuterRequest.sendRequest();
        return ResponseEntity.ok(userRepository.getOne(id));
    }
    /**Change user status*/
    @PutMapping("/user/{id}/{status}")
    public ResponseEntity<StatusAnswer> changeStatus(
            @PathVariable(value = "id") Long id,
            @PathVariable(value = "status") String newStatus){

        UserStatus status  = UserStatus.valueOf(newStatus);
        StatusAnswer answer = new StatusAnswer();
        answer.setNewStatus(status);
        answer.setOldStatus(status.getAnother());

        try{
            OuterRequest.sendRequest();
           User user =  userRepository.getOne(id);
           answer.setId(user.getId());
           user.setStatus(status);
           userRepository.saveAndFlush(user);
            answer.setSuccess("All done");

        }
        catch (Exception e){
            e.printStackTrace();
            answer.setSuccess("Something went wrong");
        }

        return ResponseEntity.ok(answer);
    }
}
