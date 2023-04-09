package com.learn;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.learn.config.AppConstants;
import com.learn.entities.Role;
import com.learn.repository.RoleRepo;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class BloggingApplication implements CommandLineRunner{

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private RoleRepo roleRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(BloggingApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
				System.out.println(this.passwordEncoder.encode("abcdef"));
				
//				try {
//					Role role= new Role();
//					role.setRoleId(AppConstants.ADMIN_USER);
//					role.setRoleName("ROLE_ADMIN");
//					
//					Role role1= new Role();
//					role1.setRoleId(AppConstants.NORMAL_USER);
//					role1.setRoleName("ROLE_NORMAL");
//					
//					List<Role> list=List.of(role,role1);
//					
//					List<Role> roles = this.roleRepo.saveAll(list);
//					
//					roles.forEach(r-> {
//						System.out.println(r.getRoleName());
//					});
//				} catch (Exception e) {
//					// TODO: handle exception
//					e.printStackTrace();
//				}
		
	}
}
