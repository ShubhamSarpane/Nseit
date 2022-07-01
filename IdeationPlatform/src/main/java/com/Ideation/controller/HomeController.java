package com.Ideation.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.Ideation.entity.User;
import com.Ideation.helper.Message;
import com.Ideation.dao.UserRepository;





@Controller
public class HomeController {
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	UserRepository userRepository;

	// for home page
	@RequestMapping("/")
	public String home(Model model) {

		model.addAttribute("title", "Home - IdeationPlatform");

		return "home";
	}

	/* ------------------------------------------------------------------------------------- */

	// for SignUp page
	
	  @RequestMapping("/signup")
	  public String signup(Model model) {
	  
	  model.addAttribute("title", "Register - Ideation Platform"); 
		/* model.addAttribute("user",new User()); */
	  
	  return "signup"; 
	  }
	  
	  
	  
	 
	  // this handler for do registration
		
		  @RequestMapping(value = "/do_register", method = RequestMethod.POST)
		  public String registerUser(@ModelAttribute("user") User user,
		  @RequestParam(value = "agreement", defaultValue = "false") boolean agreement,
		  Model model, HttpSession session) {
		  
		  try {
				/*
				 * final UserEntity customer = userRepository.findByEmail(email); if (customer
				 * == null) { throw new UsernameNotFoundException(email); }
				 */
			  
			
			  
			  user.setRole("ROLE_USER");
			  user.setEnabled(true);
			  user.setPassword(passwordEncoder.encode(user.getPassword()));
	
			  User result =this.userRepository.save(user);
				/* user.setPassword(passwordEncoder.encode(user.getPassword())); */
			  
			  // for success msg
				
				  session.setAttribute("message",new Message("Successfully register!!", "success" ));
				 
		  
			} catch (Exception e) {
				/* System.out.println("ERROR"+e.getMessage()); */
				e.printStackTrace();
				
				 // for error msg
					
					  session.setAttribute("message",new Message("This Email Already used!!", "danger" ));
					 
				
				 return "signup"; 
				
				/* System.out.println(e); */ 
				}
		  
		  return "redirect:signin";
		  }
		 
      /* ------------------------------------------------------------------------------------- */

		  
			// handle for custom login
			
			@GetMapping("/signin")
			public String customLogin(Model model) {
				model.addAttribute("title","Login Page");
				return "login";
				
				
			}
			
		  
		
}
