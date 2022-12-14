package com.example.demo.controller;

import com.example.demo.dto.AddGroupRequestBody;
import com.example.demo.dto.GetGroupResponseBody;
import com.example.demo.service.GroupService;
import com.google.common.base.Preconditions;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/groups")
@RequiredArgsConstructor
public class GroupController {


    private final GroupService groupService;

    @PostMapping
    public void add(@RequestBody AddGroupRequestBody group) {
        Preconditions.checkArgument(group != null && group.getNumber() != null,
                "Argument AddGroupRequestBody is null");
        groupService.addGroup(group);
    }

    @GetMapping
    public List<GetGroupResponseBody> getListGroupResponseBody() {
        return groupService.getListGroupResponseBody();
    }

    @GetMapping(path = "{groupID}")
    public GetGroupResponseBody getGroup(@PathVariable Integer groupID) {
        Preconditions.checkArgument(groupID != null, "groupID is null");
        return groupService.getGroupRequestBody(groupID);
    }

}

