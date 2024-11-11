/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

 package flower.store.lab8.user;

 import java.util.Optional;
 
 import org.springframework.data.jpa.repository.Query;
 import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
 
 
 public interface  UserRepository extends  JpaRepositoryImplementation<AppUser, Long> {
 
     @Query("SELECT u FROM AppUser u WHERE u.email = ?1")
     Optional<AppUser> findUserByEmail(String email);
 
 }
 