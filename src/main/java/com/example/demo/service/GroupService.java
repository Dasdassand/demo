package com.example.demo.service;

import com.example.demo.dto.AddGroupRequestBody;
import com.example.demo.dto.GetGroupResponseBody;
import com.example.demo.entity.Group;

import java.util.List;

public interface GroupService {
    void addGroup(AddGroupRequestBody groupRequestDto);
    GetGroupResponseBody getGroupRequestBody(Integer id);
    List<GetGroupResponseBody> getListGroupResponseBody();
     Group getGroup(Integer id);
}
