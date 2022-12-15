package com.example.moodle.service;

import com.example.moodle.dto.AddGroupRequestBody;
import com.example.moodle.dto.GetGroupResponseBody;
import com.example.moodle.entity.Group;

import java.util.List;

public interface GroupService {
    void addGroup(AddGroupRequestBody groupRequestDto);

    GetGroupResponseBody getGroupRequestBody(Integer id);

    List<GetGroupResponseBody> getListGroupResponseBody();

    Group getGroup(Integer id);
}
