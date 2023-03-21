package gdsc.MCIET.domain.user.presentation;

import gdsc.MCIET.domain.user.presentation.dto.UserInfoDto;
import gdsc.MCIET.domain.user.service.UserService;
import gdsc.MCIET.global.security.service.GoogleService;
import gdsc.MCIET.global.successResponse.ResponseMessage;
import gdsc.MCIET.global.successResponse.StatusCode;
import gdsc.MCIET.global.successResponse.SuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    private final GoogleService googleService;

    @PostMapping("/signIn")
    public ResponseEntity signIn(@RequestParam String idTokenString, HttpServletResponse response){

        UserInfoDto userInfo = googleService.getUserInfo(idTokenString);
        String email = userService.signIn(userInfo, response);

        return SuccessResponse.successtoResponseEntity(StatusCode.OK, email, ResponseMessage.SIGN_IN);
    }

    @PostMapping("/signIn2")
    public ResponseEntity signIn2(@RequestParam String email, HttpServletResponse response){
        String result = userService.signIn2(email, response);
        return SuccessResponse.successtoResponseEntity(StatusCode.OK, email, ResponseMessage.SIGN_IN);
    }
}
