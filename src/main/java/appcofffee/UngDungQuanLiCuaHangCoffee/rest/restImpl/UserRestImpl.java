package appcofffee.UngDungQuanLiCuaHangCoffee.rest.restImpl;

import appcofffee.UngDungQuanLiCuaHangCoffee.constents.CafeConstants;
import appcofffee.UngDungQuanLiCuaHangCoffee.model.User;
import appcofffee.UngDungQuanLiCuaHangCoffee.rest.UserRest;
import appcofffee.UngDungQuanLiCuaHangCoffee.service.UserService;
import appcofffee.UngDungQuanLiCuaHangCoffee.utils.CafeUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.Map;

@Controller
@RequiredArgsConstructor
public class UserRestImpl implements UserRest {

    @Autowired
    private final UserService userService;

    @Override
    public ResponseEntity<String> signUp(Map<String, String> requestMap) {
        try{
            return userService.signUp(requestMap);
        }catch (Exception exception){
            /** in ra thông tin chi tiết về một exception (ngoại lệ) trên đầu ra chuẩn */
            exception.printStackTrace();
        }
        return CafeUtils.getResponseEntity(CafeConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
