package appcofffee.UngDungQuanLiCuaHangCoffee.repo;

import appcofffee.UngDungQuanLiCuaHangCoffee.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/** của thầy file này đại diện nào dao, của mình cấu trúc thay là repo */
@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    User findEmailById(@Param("email") String email);
}
