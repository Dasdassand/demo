package com.example.demo.service;

import com.example.demo.dto.AddGroupRequestDTO;
import com.example.demo.dto.GetGroupRequestDTO;
import com.example.demo.entity.Group;

import java.util.List;
import java.util.Optional;

public interface GroupService {
    void addGroup(AddGroupRequestDTO groupRequestDto);
    GetGroupRequestDTO getGroupFromDTO(Integer id);
    List<GetGroupRequestDTO> getAllGroupsDTO();
     Group getGroup(Integer id);
}
