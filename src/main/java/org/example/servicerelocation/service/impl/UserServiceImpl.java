package org.example.servicerelocation.service.impl;



import org.example.servicerelocation.dto.UserDto;
import org.example.servicerelocation.entity.UserEntity;
import org.example.servicerelocation.exception.ElemNotFound;
import org.example.servicerelocation.mapper.UserMapper;
import org.example.servicerelocation.repository.UserRepository;
import org.example.servicerelocation.service.UserService;
import org.springframework.stereotype.Service;

/** Реализация сервиса пользователей*/
@Service
//@Slf4j
public class UserServiceImpl implements UserService{//}, UserDetailsService {
  private UserRepository userRepository;
  private UserMapper userMapper;

  public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
    this.userRepository = userRepository;
    this.userMapper = userMapper;
  }

  @Override
  public UserDto getUser(String login) {
   // log.debug("Получить данные пользователя" );
    UserEntity user= new UserEntity();
    user= (UserEntity) userRepository.findByName( login).orElseThrow(()->
            new ElemNotFound("Такого пользователя не существует"));
    return userMapper.toDTO(user);
  }@Override
  public UserDto greateUser(UserDto userDto) {
   // log.debug("Создать пользователя");
    if (userRepository.findByNameIsNotNull(userDto.getName())) {
      throw new UnsupportedOperationException("Такой пользователь уже существует");
    } else userRepository.save(userMapper.toEntity(userDto));
      return userDto;
  }

  @Override
  public UserDto loadUserByName(String login) {
    return userMapper.toDTO((UserEntity) userRepository.findByName(login).orElseThrow(ElemNotFound::new));
  }

  @Override
  public UserEntity getByLogin(String login) {
    return (UserEntity) userRepository.findByName(login).orElseThrow(ElemNotFound::new);
  }

  @Override
  public UserDto updateUser(UserDto newUserDto) {
  //  log.debug("Обновить данные пользователя");
    UserEntity user= new UserEntity();
    user= userRepository.findByEmail(newUserDto.getEmail()).orElseThrow(()->
            new ElemNotFound("Такого пользователя не существует"));
    user=userMapper.toEntity(newUserDto);
    userRepository.save(user);
    return newUserDto;
  }

  @Override
  public void deleteUser(String login) {
   // log.debug("Удалить пользователя");
    UserEntity user= new UserEntity();
    user= userRepository.findByEmail(login).orElseThrow(()->
            new ElemNotFound("Такого пользователя не существует"));
    userRepository.delete(user);
  }


//  @Override
//  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//    return userRepository.findByUsername(username);
//  }
}
