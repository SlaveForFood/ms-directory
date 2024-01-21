package com.wff.ms.directory.models.dto.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
@Schema(description = "Стандартное описание возникших исключений при обработке запросов")
public class CommonExceptionDto {

  @JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss")
  @Schema(description = "Время возникновения ошибки", example = "12-01-2023 03:00:00")
  private final LocalDateTime timestamp = LocalDateTime.now();

  @Schema(description = "Статус ошибки", example = "BAD_REQUEST")
  private HttpStatus status;

  @Schema(description = "Описание возникшей ошибки")
  private String message;
}
