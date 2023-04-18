package studio.hcmc.egov.spring.boot.mvc;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ErrorResponse {
    public static class User {
        @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "USER_NOT_FOUND")
        public static class NotFound extends RuntimeException {}
    }
}
