package com.books.DTO;

import com.books.entity.User;

import java.util.ArrayList;
import java.util.List;


public class DTOUtilMaper {

    public static List<UserDTO> userToDTOs(List<User> users){
        List<UserDTO> userDTOS = new ArrayList<UserDTO>();
        for (User user : users) {
            UserDTO userDTO = new UserDTO();
            userDTO.setId(user.getId());
            userDTO.setName(user.getName());

            userDTOS.add(userDTO);
        }
        return userDTOS;
    }

}
