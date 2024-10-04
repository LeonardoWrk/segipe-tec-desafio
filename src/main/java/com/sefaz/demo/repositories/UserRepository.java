package com.sefaz.demo.repositories;

import org.hibernate.internal.util.collections.ConcurrentReferenceHashMap.Option;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sefaz.demo.domain.user.User;
import java.util.Optional;

//classe repository sao as resposaveis por fazer as query no db
public interface UserRepository extends JpaRepository<User, Long> {
   Optional<User> findUserByDocument(String document);

   Optional<User> findUserById(long id);
}
