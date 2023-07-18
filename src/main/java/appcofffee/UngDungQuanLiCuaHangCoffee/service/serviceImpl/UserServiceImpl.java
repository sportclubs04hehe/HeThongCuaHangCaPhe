package appcofffee.UngDungQuanLiCuaHangCoffee.service.serviceImpl;

import appcofffee.UngDungQuanLiCuaHangCoffee.constents.CafeConstants;
import appcofffee.UngDungQuanLiCuaHangCoffee.model.User;
import appcofffee.UngDungQuanLiCuaHangCoffee.repo.UserRepo;
import appcofffee.UngDungQuanLiCuaHangCoffee.service.UserService;
import appcofffee.UngDungQuanLiCuaHangCoffee.utils.CafeUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserRepo userRepo;
    @Override
    public ResponseEntity<String> signUp(Map<String, String> requestMap) {
        log.info("Bên trong signUp {}", requestMap);
       try{
           User user = userRepo.findEmailById(requestMap.get("email"));
           if(Objects.isNull(user)){
               userRepo.save(getUserFromMap(requestMap));
               return CafeUtils.getResponseEntity("Đăng kí thành công", HttpStatus.OK);
           }else{
               return CafeUtils.getResponseEntity("Email này đã tồn tại", HttpStatus.BAD_REQUEST);
           }
       }catch (Exception exception){
           /** in ra thông tin chi tiết về một exception (ngoại lệ) trên đầu ra chuẩn */
           exception.printStackTrace();
       }
       return CafeUtils.getResponseEntity(CafeConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private User getUserFromMap(Map<String, String> requestMap){
        User user = new User();
        /** xét giá trị user bằng giá trị trả về của requestMap*/
        user.setName(requestMap.get("name"));
        user.setContactNumber(requestMap.get("contactNumber"));
        user.setEmail(requestMap.get("email"));
        user.setPassword(requestMap.get("password"));
        return user;
    }

}
