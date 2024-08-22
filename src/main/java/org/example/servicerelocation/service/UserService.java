package org.example.servicerelocation.service;


import org.example.servicerelocation.dto.UserDto;
import org.example.servicerelocation.entity.UserEntity;

/** Сервис пользователей*/
public interface UserService {
    /** Получить данные пользователя*/
    UserDto getUser(String login/*, Authentication authentication*/);
    /** Обновить данные пользователя*/
    UserDto updateUser(UserDto newUserDto/*, Authentication authentication*/);
    /** Удалить данные пользователя*/
    void deleteUser(String login/*, Authentication authentication*/);
    /** Создать пользователя*/
    UserDto greateUser(UserDto userDto/*, Authentication authentication*/);
    /** Получить данные пользователя ро логину*/
    UserDto loadUserByName(String login);

    UserEntity getByLogin(String login);
}
