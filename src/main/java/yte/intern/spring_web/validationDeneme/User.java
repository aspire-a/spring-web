package yte.intern.spring_web.validationDeneme;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class User {

    @NotBlank(message = "Name cannot be blank")
    String name;

    @NotBlank(message = "Surname cannot be blank")
    String surname;

    @Max(value = 100, message = "Age cannot be n-bigger than 100")
    @Min(value = 12, message = "Age cannot be smaller than 12")
    Integer age;

    @Email
    String email;

    @PastOrPresent()
    LocalDate birthDay;

    @NotBlank(message = "Username cannot be blank")
    String username;

    @Size(max = 251, message = "Adres cannot be longer than 250 character")
    @NotBlank(message = "Adres cannot be empty")
    String adres;

    @NotBlank(message = "TC Cannot be blank")
    String tc;

    @AssertTrue(message = "Lütfen Doğru TC Girin")
    public boolean isTCValid() {
        return tc.length() == 11;
    }

    @AssertTrue
    public boolean isUsernameValid() {
        return !username.equals("admin");
    }

}
