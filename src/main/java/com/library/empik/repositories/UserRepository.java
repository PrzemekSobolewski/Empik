package com.library.empik.repositories;

import com.library.empik.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT * FROM user WHERE name = ?1", nativeQuery = true)
    Optional<User> findByName(String name);

    @Query(value = "UPDATE user SET name = ?1, surname =?2 WHERE id = ?3",nativeQuery = true)
    Optional<User> updateUsers(String name, String surname, Long id);

    @Query(value = "UPDATE user_book SET book_id = ?1 WHERE user_id=?2, book_id=?3 )",nativeQuery = true)
    Optional<User> changeBookInUser(Long user_id, Long book_id);


}
