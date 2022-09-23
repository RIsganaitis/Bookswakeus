package codeAcademy.bookswakeus.users;


import codeAcademy.bookswakeus.validation.PhoneNumber;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "users")
public class User {
    @Id
    private String name;
    @PhoneNumber(phoneNumberType = PhoneNumber.PhoneNumberType.FULL)
    private String phoneNumber;
    private String email;
    private String password;

}
