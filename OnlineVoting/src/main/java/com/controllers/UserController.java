package com.controllers;

import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dao.PartyDao;
import com.dao.PartyRepository;
import com.dao.UserDao;
import com.dao.UserRepository;
import com.exceptiom.ResourceNotFoundException;
import com.model.Party;
import com.model.User;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    @Autowired
    private UserDao userdao;
    
    @Autowired
    private PartyDao partydao;
    
    @Autowired
    private PartyRepository pRepository;
    
    @Autowired
    private UserRepository uRepository;
    
    @GetMapping("/alluser")
    public List<User> getUser(){
    	return userdao.displayUser();
    }
    @PostMapping("/registeruser")
    public ResponseEntity<String> registerUser(@Valid @RequestBody User user) {
    	userdao.registerUser(user);
        return ResponseEntity.ok("User Registered Successfully");
    }
    
    @GetMapping("/findByVotingCardNumber/{userVotingCardNumber}")
    public List<User> getUserByVotingCardNumber(@PathVariable String userVotingCardNumber) {
        return userdao.getUserByVotingCardNumber(userVotingCardNumber);
    }
    
    @GetMapping("/findByUserId/{userId}")
    public User getUserByVotingCardNumber(@PathVariable Long userId) {
        return uRepository.findById(userId).get();
    }

    @GetMapping("/findByMobileNumber/{userMobileNumber}")
    public List<User> getUserByMobileNumber(@PathVariable String userMobileNumber) {
        return userdao.getUserByMobileNumber(userMobileNumber);
    }

    @GetMapping("/findByUserName/{userName}")
    public List<User> getUserByUserName(@PathVariable String userName) {
        return userdao.getUserByUserName(userName);
    }
    
    
     @DeleteMapping("/deleteuser/{id}")
		public ResponseEntity<Boolean> deleteUser(@PathVariable("id") long userId) {
    	 userdao.deleteByUserId(userId);
			boolean flag = true;
			return new ResponseEntity<Boolean>(flag, HttpStatus.OK);
		}
  
    @GetMapping("/findByRole/{userRole}")
    public List<User> getUserByRole(@PathVariable String userRole) {
        return userdao.getUserByRole(userRole);
    }
    
//    @GetMapping("/adminlogin/{userEmail}/{userPassword}")
//    public User loginUserByEmail(User user) {
//        return this.userService.loginUserByEmail(user.getUserEmail(), user.getUserPassword()).orElseThrow(()
//        -> new ResourceNotFoundException("User", "Email and Password", user.getUserEmail() + " and password " + user.getUserPassword()));
//    }

    @GetMapping("/voterlogin/{userVotingCardNumber}/{userPassword}")
    public User loginUserByVotingCardNumber(User user) {
        return this.userdao.loginUserByVotingCardNumber(user.getUserVotingCardNumber(), user.getUserPassword())
        .orElseThrow(() -> new ResourceNotFoundException("User", "Voting Card Number and Password", user.getUserVotingCardNumber() + " and password " + user.getUserPassword()));
    }
    
    @PostMapping("/addvote/{partyId}/{userId}")
    public ResponseEntity<HashMap<String, String>> addCandidate(@PathVariable Long partyId, @PathVariable Long userId) {
    	Party p = pRepository.findById(partyId).get();
    	User u = uRepository.findById(userId).get();
    	String voteStatus = "";
    	if (p != null && u != null) {
    		if (u.getStatus() == null) {
    			p.setVotes(p.getVotes() + 1);
    			u.setStatus("voted");
    			pRepository.save(p);
    			uRepository.save(u);
    			voteStatus = "Vote Added";
    		} else  {
    			voteStatus = "Vote Already Added";
    		}
    	}
    	HashMap h = new HashMap<String, String>();
    	h.put("vote", voteStatus);
    	return ResponseEntity.ok(h);
    }
    
    @PostMapping("/activateUser")
    public ResponseEntity<String> activateUser(@Valid @RequestBody User user) {
        user.setActivateAccount(true);
        uRepository.save(user);
        return ResponseEntity.ok("User Activated Successfully");
    }
    
    @PostMapping("/activateUser2/{userId}")
    public ResponseEntity<String> activateUser2(@PathVariable Long userId) {
    	User u = uRepository.findById(userId).get();
    	if (u != null) {
    		u.setActivateAccount(true);
    		 uRepository.save(u);
    		 return ResponseEntity.ok("User Activated Successfully");
    	}
    	 return ResponseEntity.ok("User Not Found");
       
    }
    
    @PostMapping("/loginByCardNumber")
    public ResponseEntity<User> loginByCardNumber(@RequestBody User user) {
        User u = userdao.loginUserByVotingCardNumber(user.getUserVotingCardNumber(), user.getUserPassword()).get();
        return ResponseEntity.ok(u);
    }
    
    @PostMapping("/loginByEmail")
    public ResponseEntity<User> loginUserByEmail(@RequestBody User user) {
        User u = userdao.loginUserByEmail(user.getUserEmail(), user.getUserPassword()).get();
        return ResponseEntity.ok(u);
    }
    
    @GetMapping("/getUserById/{userId}")
    public  ResponseEntity<User>  getUserById(@PathVariable Long userId){
    	User u = uRepository.findById(userId).get();
    	return ResponseEntity.ok(u);
    }
    
    @PutMapping("/updateUser")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        User u = uRepository.findById(user.getUserId()).get();
        u.setUserAddress(user.getUserAddress());
        u.setUserMobileNumber(user.getUserMobileNumber());
        u.setUserDateOfBirth(user.getUserDateOfBirth());
        u.setUserEmail(user.getUserEmail());
        u.setUserName(user.getUserName());
        uRepository.save(u);
        return ResponseEntity.ok(u);
    }
    
}