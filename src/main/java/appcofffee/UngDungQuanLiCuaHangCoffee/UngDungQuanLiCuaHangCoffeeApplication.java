package appcofffee.UngDungQuanLiCuaHangCoffee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping(path = "/")
public class UngDungQuanLiCuaHangCoffeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(UngDungQuanLiCuaHangCoffeeApplication.class, args);
	}

	@GetMapping("hi")
	public List<String> hello(){
		return List.of("Xin Chao","hello","Ni Hao");
	}


}
