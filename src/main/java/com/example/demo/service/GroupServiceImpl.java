package com.example.demo.service;

import com.example.demo.mapper.GroupMapper;
import com.example.demo.repository.GroupRepository;
import com.example.demo.dto.AddGroupRequestDTO;
import com.example.demo.dto.GetGroupRequestDTO;
import com.example.demo.entity.Group;
import com.example.demo.exception_handling.NoCorrectDataDTO;
import com.example.demo.exception_handling.NoSuchEntityException;
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
    public void addGroup(AddGroupRequestDTO groupRequestDto) {
        if (!groupRequestDto.getNumber().equals("")) {
            groupRepository.save(groupMapper.getGroup(groupRequestDto));
        }else {
            throw new NoCorrectDataDTO("Params not correct");
        }


    }

    @Override
    public GetGroupRequestDTO getGroupFromDTO(Integer id) {
        Optional<Group> group = groupRepository.findById(id);
        if (group.isPresent()) {
            return groupMapper.getDTO(group.get());
        } else {
            throw new NoSuchEntityException("No correct group_id = " + id);
        }
    }

    @Override
    public List<GetGroupRequestDTO> getAllGroupsDTO() {
        return groupMapper.getDTOs(groupRepository.findAll());
    }

    @Override
    public Group getGroup(Integer id) {
       Optional<Group> groupOptional = groupRepository.findById(id);
       if (groupOptional.isPresent()){
           return groupOptional.get();
       }else {
           throw new NoSuchEntityException("No corrected groupID = " + id);
       }
    }
}
