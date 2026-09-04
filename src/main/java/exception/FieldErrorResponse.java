package exception;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class FieldErrorResponse {

    private String field;
    private String message;
}