package az.huseyn.usercrudapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "app_users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Enter first name")
    @Size(min = 2, max = 50,message = "First name must be minimum 2 and maximum 50 characters!")
    private String firstName;

    @NotBlank(message = "Enter last name")
    @Size(min = 2, max = 50,message = "Last name must be minimum 2 and maximum 50 characters!")
    private String lastName;

    @Email(message = "Email format is not valid! ",
           regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")
    private String email;


    @NotBlank(message = "Enter phone number!")
    @Pattern(regexp = "^\\+994(50|51|55|70|77|99|10)\\d{7}$" )
    private String phoneNumber;



}
