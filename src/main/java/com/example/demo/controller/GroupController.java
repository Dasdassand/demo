package com.example.demo.controller;

import com.example.demo.dto.AddGroupRequestDTO;
import com.example.demo.dto.GetGroupRequestDTO;
import com.example.demo.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/groups")
@RequiredArgsConstructor
public class GroupController {


    private final GroupService groupService;

    @PostMapping
    public void add(@RequestBody AddGroupRequestDTO groupRequestDto) {
        groupService.addGroup(groupRequestDto);

    }

    @GetMapping
    public List<GetGroupRequestDTO> getGroups() {
        return groupService.getAllGroupsDTO();
    }

    @GetMapping(path = "{id}")
    public GetGroupRequestDTO getGroup(@PathVariable Integer id) {
        return groupService.getGroupFromDTO(id);
    }

}

