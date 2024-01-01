package com.example.adu_connect.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.adu_connect.repository.UserRepository;
import com.example.adu_connect.services.UserService;
import com.example.adu_connect.entities.User;


//@RestController -> Bu sınıfın HTTP isteklerine yanıt veren bir REST denetleyicisi olduğunu gösterir. 
//REST denetleyicisi, istemcilere JSON veya XML gibi veri formatlarında yanıt veren HTTP API'lerini uygulamak 
//için kullanılır.
@RestController
//@RequestMapping("/users") -> Bu anotasyon, bu denetleyicinin hangi URL yolunu ele alacağını belirtir.
@RequestMapping("/users")
public class UserController {
	
	
	//UserRepository bağımlılığın dışarıdan enjekte edilmesini sağlar.
	private UserService userService ;
	
	
	//	userRepository Kullanıcı verilerini saklamak ve işlemek için kullanılacak UserRepository bağımlılığı.
	public UserController(UserService userService) {
		this.userService=userService;
	}
	
	//Spring Framework tarafından sağlanan bir HTTP isteği eşlemesini işaretleyen bir anotasyondur.
	//Sadece HTTP GET isteğinin gerçekleşebilmesini sağlar.
	@GetMapping
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	//PostMapping : -> HTTP POST isteği ile eşleşen bu işlemi tanımlar
	//RequestBody : -> İstemciden gelen verilerin(json formatinda olabilir mesela) User newUser parametresine dönüşmesini
	//sağlar. User newUser parametresi, istemciden gelen verileri temsil eden bir kullanıcı nesnesini temsil eder.	
	@PostMapping
	public User createUser(@RequestBody User newUser) {
		return userService.saveOneUser(newUser);
	}
	
	@GetMapping("/{userId}")
	public User getOneUser(@PathVariable Long userId){
		//custom exception
		return userService.getOneUserById(userId);
	}
		

	
	@PutMapping("/{userId}")
	public User updateOneUser(@PathVariable Long userId , @RequestBody User newUser){
//"Optional," bir Java sınıfıdır ve bir değerin mevcut olup olmadığını temsil etmek için kullanılır
			return userService.updateOneUser(userId,newUser);
		
	}
	
		@DeleteMapping("/{userId}")
		public void  deleteOneUser(@PathVariable Long userId){
			userService.deleteOneUser(userId);
			
		}
		
	
	

}
