package com.example.exceptionhandler.error;

import com.example.exceptionhandler.error.model.ErrorModel;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {

    private List<ErrorModel> errorMessage;
}
