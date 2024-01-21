package com.wff.ms.directory.exceptions;

import com.wff.ms.directory.models.dto.exception.CommonExceptionDto;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import java.util.Objects;
import javax.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

/**
 * Централизованный обработчик ошибок
 *
 * @author Orlov
 * @since 01.2024
 */
@Slf4j
@RestControllerAdvice
public class ControllerExceptionHandler {

  /**
   * Обработка исключений возникающих при отсутствии искомых сущностей в бд
   *
   * @param ex исключение {@link NotFoundException}
   * @return экземпляр описания ошибки {@link CommonExceptionDto}
   */
  @ExceptionHandler(NotFoundException.class)
  @ApiResponse(responseCode = "404", useReturnTypeSchema = true, description = "Объект не найден")
  ResponseEntity<CommonExceptionDto> notFoundExceptionHandler(NotFoundException ex) {
    return createResponse(HttpStatus.NOT_FOUND, ex.getMessage());
  }

  /**
   * Обработка исключений возникающих при попытке создания сущностей, которые уже имеются в бд
   *
   * @param ex исключение {@link AlreadyExistException}
   * @return экземпляр описания ошибки {@link CommonExceptionDto}
   */
  @ExceptionHandler(AlreadyExistException.class)
  @ApiResponse(responseCode = "409", useReturnTypeSchema = true, description = "Возник конфликт")
  ResponseEntity<CommonExceptionDto> notFoundExceptionHandler(AlreadyExistException ex) {
    return createResponse(HttpStatus.CONFLICT, ex.getMessage());
  }

  /**
   * Обработка исключений возникающая в попытке отправки запроса к сервису с недостающими
   * параметрами
   *
   * @param exp исключение {@link MethodArgumentTypeMismatchException}
   * @return экземпляр описания ошибки {@link CommonExceptionDto}
   */
  @ExceptionHandler(MethodArgumentTypeMismatchException.class)
  @ApiResponse(
      responseCode = "400",
      useReturnTypeSchema = true,
      description = "Валидация не пройдена")
  ResponseEntity<CommonExceptionDto> validationHandler(MethodArgumentTypeMismatchException exp) {
    return createResponse(HttpStatus.BAD_REQUEST, Objects.requireNonNull(exp.getMessage()));
  }

  /**
   * Обработка исключений возникающая в попытке отправки запроса к сервису с телом запроса не
   * прошедшим валидацию на допустимость значения
   *
   * @param ex исключение {@link ConstraintViolationException}
   * @return экземпляр описания ошибки {@link CommonExceptionDto}
   */
  @ExceptionHandler(ConstraintViolationException.class)
  ResponseEntity<CommonExceptionDto> validationHandler(ConstraintViolationException ex) {
    return createResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
  }

  /**
   * Обработка исключений возникающая в попытке отправки запроса к сервису с недопустимыми
   * параметрами запроса
   *
   * @param ex исключение {@link MethodArgumentNotValidException}
   * @return экземпляр описания ошибки {@link CommonExceptionDto}
   */
  @ExceptionHandler(MethodArgumentNotValidException.class)
  ResponseEntity<CommonExceptionDto> handlerValidation(MethodArgumentNotValidException ex) {
    Iterable<String> validationErrors =
        ex.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).toList();
    String message = String.join(System.lineSeparator(), validationErrors);
    return createResponse(HttpStatus.BAD_REQUEST, message);
  }

  /**
   * Обработка исключений возникающая в попытке отправки запроса к сервису с неуказанным параметром
   *
   * @param ex исключение {@link MissingServletRequestParameterException}
   * @return экземпляр описания ошибки {@link CommonExceptionDto}
   */
  @ExceptionHandler(MissingServletRequestParameterException.class)
  ResponseEntity<CommonExceptionDto> handlerValidation(MissingServletRequestParameterException ex) {
    var message = String.format("Missing required request parameter: %s", (ex.getMessage()));
    return createResponse(HttpStatus.BAD_REQUEST, message);
  }

  private ResponseEntity<CommonExceptionDto> createResponse(HttpStatus httpStatus, String message) {
    log.warn(message);
    CommonExceptionDto exceptionDto =
        CommonExceptionDto.builder().status(httpStatus).message(message).build();
    return new ResponseEntity<>(exceptionDto, httpStatus);
  }
}
