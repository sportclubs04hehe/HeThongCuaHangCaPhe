package appcofffee.UngDungQuanLiCuaHangCoffee.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import java.io.Serializable;

/** câu truy vấn này tương tự như [SELECT u FROM User u WHERE u.email = 'example@example.com']*/
@NamedQuery(name = "User.findEmailById",query = "select u from User u where u.email=:email")

@Data
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
/** Serializable là một interface đánh dấu rằng một lớp có thể được
 * chuyển đổi thành dạng byte để có thể được lưu trữ hoặc truyền đi qua mạng */
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique = true)
    private Long id;
    @Column(name = "name", length = 255)
    @Pattern(regexp = "[a-zA-Z][a-zA-Z ]+", message = "Tên chứa kí tự cấm!")
    @NotNull(message = "Name không được để trống!")
    private String name;
    @Column(name = "contactNumber")
    @Pattern(regexp = "^\\+(?:[0-9] ?){6,14}[0-9]$", message = "Số điện thoại là bắt buộc")
    @NotNull(message = " Số điện thoại không được để trống!")
    private String contactNumber;
    @Column(name = "email")
    @Email(message = "Email là bắt buộc")
    @NotNull(message = "Email không được để trống!")
    private String email;
    @Column(name = "password")
    @NotNull(message = "Password không được để trống!")
    private String password;
    @Column(name = "status")
    private String status;
    @Column(name = "role")
    private String role;
}
