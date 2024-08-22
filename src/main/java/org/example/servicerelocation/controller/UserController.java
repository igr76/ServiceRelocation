package org.example.servicerelocation.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.constraints.NotBlank;
import org.example.servicerelocation.dto.UserDto;
import org.example.servicerelocation.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/** Контроллер комментариев  */
@RequestMapping("/users")
@RestController
public class UserController {
  private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }



    @Operation(summary = "Получить пользователя")
  @ApiResponses({
          @ApiResponse(responseCode = "200", description = "Успешно", content = @Content(
                  array = @ArraySchema(schema = @Schema(implementation = UserDto.class)))),
          @ApiResponse(responseCode = "204", description = "нет содержимого", content = @Content(schema = @Schema())),
          @ApiResponse(responseCode = "401", description = "неверная авторизация или аутентификация", content = @Content(schema = @Schema())),
          @ApiResponse(responseCode = "403", description = "Доступ запрещен", content = @Content(schema = @Schema())),
          @ApiResponse(responseCode = "404", description = "Не найдено", content = @Content(schema = @Schema()))
  })

  @GetMapping(value = "/{login}")
  public ResponseEntity<UserDto> getUser(@PathVariable(name = "login")
                                           @NotBlank(message = "ad_pk не должен быть пустым") String login/*, Authentication authentication*/) {
   // log.debug("controller Получить пользователя");
    return ResponseEntity.ok(userService.getUser(login));
  }
  @Operation(summary = "Создать пользователя")
  @ApiResponses({
          @ApiResponse(responseCode = "200", description = "Успешно", content = @Content(
                  array = @ArraySchema(schema = @Schema(implementation = UserDto.class)))),
          @ApiResponse(responseCode = "204", description = "нет содержимого", content = @Content(schema = @Schema())),
          @ApiResponse(responseCode = "401", description = "неверная авторизация или аутентификация", content = @Content(schema = @Schema())),
          @ApiResponse(responseCode = "403", description = "Доступ запрещен", content = @Content(schema = @Schema())),
          @ApiResponse(responseCode = "404", description = "Не найдено", content = @Content(schema = @Schema()))
  })
  @PostMapping
  public ResponseEntity<UserDto> greaetUser(
          @RequestBody
          @NotBlank(message = "пользователь не должен быть пустым") UserDto userDto/*, Authentication authentication*/) {
   // log.debug("controller создать пользователя");
    return ResponseEntity.ok(userService.greateUser(userDto));
  }
  @Operation(summary = "Обновить пользователя")
  @ApiResponses({
          @ApiResponse(responseCode = "200", description = "Успешно", content = @Content(
                  array = @ArraySchema(schema = @Schema(implementation = UserDto.class)))),
          @ApiResponse(responseCode = "204", description = "нет содержимого", content = @Content(schema = @Schema())),
          @ApiResponse(responseCode = "401", description = "неверная авторизация или аутентификация", content = @Content(schema = @Schema())),
          @ApiResponse(responseCode = "403", description = "Доступ запрещен", content = @Content(schema = @Schema())),
          @ApiResponse(responseCode = "404", description = "Не найдено", content = @Content(schema = @Schema()))
  })
  @PatchMapping()
  public ResponseEntity<UserDto> updateUser(
          @RequestBody
      @NotBlank(message = "пользователь не должен быть пустым") UserDto userDto/*, Authentication authentication*/) {
  //  log.debug("controller Обновить пользователя");
    return ResponseEntity.ok(userService.updateUser(userDto));
  }
    @Operation(summary = "Удалить пользователя")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Успешно", content = @Content(
                    array = @ArraySchema(schema = @Schema(implementation = UserDto.class)))),
            @ApiResponse(responseCode = "204", description = "нет содержимого", content = @Content(schema = @Schema())),
            @ApiResponse(responseCode = "401", description = "неверная авторизация или аутентификация", content = @Content(schema = @Schema())),
            @ApiResponse(responseCode = "403", description = "Доступ запрещен", content = @Content(schema = @Schema())),
            @ApiResponse(responseCode = "404", description = "Не найдено", content = @Content(schema = @Schema()))
    })
    @DeleteMapping("/{login}")
    public void deleteUser(@PathVariable(name = "login")
                               @NotBlank(message = "логин не должен быть пустым") String login/*, Authentication authentication*/) {
      //  log.debug("controller Удалить пользователя");
         userService.deleteUser(login);
    }




}