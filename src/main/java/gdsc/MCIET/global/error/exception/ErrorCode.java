package gdsc.MCIET.global.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    //Not_Found
    USER_NOT_FOUND(HttpStatus.NOT_FOUND.value(), "GLOBAL-404-1", "User Not Found."),
    CUISINE_NOT_FOUND(HttpStatus.NOT_FOUND.value(),"GLOBAL-404-1", "Cuisine Not Found.");

    private int status;
    private String code;
    private String reason;
}
