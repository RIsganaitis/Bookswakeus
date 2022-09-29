package codeAcademy.bookswakeus.users;

import org.springframework.data.jpa.repository.JpaRepository;

interface UserRepo extends JpaRepository<User, String> {
}
