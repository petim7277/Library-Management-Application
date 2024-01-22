package com.Elibrary.demo.Dtos.Response;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
@Data
 @AllArgsConstructor
public class ApiResponse  {
    private boolean isSuccessful;
    private Object data;
    private String message;

    public ApiResponse(boolean isSuccessful, LibrarianLoginResponse librarian, String message) {
        this.isSuccessful = isSuccessful;
        this.message     = message;

    }

   






}
