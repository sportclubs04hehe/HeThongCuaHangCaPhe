package appcofffee.UngDungQuanLiCuaHangCoffee.service;

import appcofffee.UngDungQuanLiCuaHangCoffee.model.User;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface UserService {
    ResponseEntity<String> signUp(Map<String, String> requestMap);
}
