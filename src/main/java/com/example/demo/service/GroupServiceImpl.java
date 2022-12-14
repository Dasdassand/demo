package com.example.demo.service;

import com.example.demo.mapper.GroupMapper;
import com.example.demo.repository.GroupRepository;
import com.example.demo.dto.AddGroupRequestBody;
import com.example.demo.dto.GetGroupResponseBody;
import com.example.demo.entity.Group;
import com.example.demo.exception_handling.NoSuchEntityException;
import com.google.common.base.Preconditions;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {


    private final GroupRepository groupRepository;
    private final GroupMapper groupMapper;

    @Override
    public void addGroup(AddGroupRequestBody groupRequestDto) {
        groupRepository.save(groupMapper.getGroup(groupRequestDto));
    }

    @Override
    public GetGroupResponseBody getGroupRequestBody(Integer groupID) {
        Optional<Group> group = groupRepository.findById(groupID);
        Preconditions.checkArgument(group.isPresent(), new NoSuchEntityException("Group by id = " + groupID + " not found"));
        return groupMapper.getGroupResponseBody(group.get());
    }

    @Override
    public List<GetGroupResponseBody> getListGroupResponseBody() {
        return groupMapper.getListGroupResponseBody(groupMapper.getGroupsDomainList(groupRepository.findAll()));
    }

    @Override
    public Group getGroup(Integer groupID) {
        Optional<Group> group = groupRepository.findById(groupID);
        Preconditions.checkArgument(group.isPresent(), new NoSuchEntityException("Group by id = " + groupID + " not found"));
        return group.get();
    }
}
