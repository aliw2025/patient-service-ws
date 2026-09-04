package exception;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
public class ApiErrorResponse {

    private boolean success;
    private String message;
    private LocalDateTime timestamp;
    private List<FieldErrorResponse> errors;
}