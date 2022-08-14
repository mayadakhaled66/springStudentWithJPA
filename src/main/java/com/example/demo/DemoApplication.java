package com.example.demo;

import com.example.demo.school.SchoolRepository;
import com.example.demo.models.HomeAddress;
import com.example.demo.models.School;
import com.example.demo.models.Student;
import com.example.demo.students.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
@EnableJpaRepositories("com.example.demo")
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner  commandLineRunner(StudentRepository studentRepository, SchoolRepository schoolRepository){return args -> {
		School egy =new School("nile school", "giza", "Egypt");
		School asia = new School("asia school", "asia", "asia");
		Student student = new Student("Mona","Ahmed","mona@gmail.com",false,new  HomeAddress("giza",1,2,"Egypt"),egy);
		Student student2 = new Student("Nada","Ayman","nada@gmail.com",true,new  HomeAddress("giza",121,1,"Egypt"),asia);
		Student student3 = new Student("Mohamed","Ahmed","Mohamed@gmail.com",false,new  HomeAddress("giza",4,42,"Egypt"),egy);
		Set<Student> studentsOfEgypt = new HashSet<Student>();
		studentsOfEgypt.add(student);
		studentsOfEgypt.add(student3);
		Set<Student> studentsOfAsia = new HashSet<Student>();
		studentsOfAsia.add(student2);
		egy.setStudents(studentsOfEgypt);
		asia.setStudents(studentsOfAsia);
		schoolRepository.save(egy);
		schoolRepository.save(asia);
		studentRepository.saveAll(studentsOfEgypt);
		studentRepository.saveAll(studentsOfAsia);

	};}

}
