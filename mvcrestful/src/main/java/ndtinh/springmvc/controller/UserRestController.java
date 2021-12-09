package ndtinh.springmvc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ndtinh.springmvc.model.User;

@RestController
public class UserRestController {
  public static HashMap<Integer, User> mapUser = new HashMap<Integer, User>();

  
  /* ---------------- GET ALL USER ------------------------ */
  @GetMapping("/users")
  public ResponseEntity<List<User>> getAllUser() {
    List<User> listUser = new ArrayList<User>(mapUser.values());
    return new ResponseEntity<List<User>>(listUser, HttpStatus.OK);
  }
  
  /* ---------------- GET USER BY ID ------------------------ */
  @GetMapping("/users/{id}")
  public ResponseEntity<Object> getUserById(@PathVariable int id) {
    User user = mapUser.get(id);
    if (user != null) {
      return new ResponseEntity<Object>(user, HttpStatus.OK);
    }
    return new ResponseEntity<Object>("Not Found User", HttpStatus.NO_CONTENT);
  }
  
  /* ---------------- CREATE NEW USER ------------------------ */
  @PostMapping("/users")
  public ResponseEntity<String> createUser(@RequestBody User user) {
    if (mapUser.containsKey(user.getId())) {
      return new ResponseEntity<String>("User Already Exist!", HttpStatus.CONFLICT);
    }
    mapUser.put(user.getId(), user);
    return new ResponseEntity<String>("Created!", HttpStatus.CREATED);
  }
  
  /* ---------------- DELETE USER ------------------------ */
  @DeleteMapping("/users/{id}")
  public ResponseEntity<String> deleteUserById(@PathVariable int id) {
    User user = mapUser.get(id);
    if (user == null) {
      return new ResponseEntity<String>("Not Found User", HttpStatus.OK);
    }
    
    mapUser.remove(id);
    return new ResponseEntity<String>("Deleted!", HttpStatus.OK);
  }
  
  /* ---------------- UPDATE USER ------------------------ */
  @PutMapping("/users")
  public ResponseEntity<String> updateUser(@RequestBody User user) {
    User oldUser = mapUser.get(user.getId());
    if (oldUser == null) {
      return new ResponseEntity<String>("Not Found User", HttpStatus.NO_CONTENT);
    }
    
    // replace old user by new user.
    mapUser.put(user.getId(), user);
    return new ResponseEntity<String>("Updated!", HttpStatus.OK);
  }
}