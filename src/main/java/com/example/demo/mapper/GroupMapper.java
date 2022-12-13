package com.example.demo.mapper;

import com.example.demo.dto.AddGroupRequestDTO;
import com.example.demo.dto.GetGroupRequestDTO;
import com.example.demo.entity.Group;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;

@Mapper(componentModel = "spring")
public interface GroupMapper {
    @Mapping(target = "countStudent", expression = "java(group.getStudents().size())")
    List<GetGroupRequestDTO> getDTOs(List<Group> groups);

    @Mapping(target = "students", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "creationDate", expression = "java(new java.util.Date())")
    Group getGroup(AddGroupRequestDTO groupRequestDTO);

    @Mapping(target = "countStudent", expression = "java(group.getStudents().size())")
    GetGroupRequestDTO getDTO(Group group);

}
