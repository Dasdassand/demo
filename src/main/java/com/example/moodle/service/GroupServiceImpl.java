package com.example.moodle.service;

import com.example.moodle.mapper.GroupMapper;
import com.example.moodle.repository.GroupRepository;
import com.example.moodle.dto.AddGroupRequestBody;
import com.example.moodle.dto.GetGroupResponseBody;
import com.example.moodle.entity.Group;
import com.example.moodle.exception_handling.NoSuchEntityException;
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
