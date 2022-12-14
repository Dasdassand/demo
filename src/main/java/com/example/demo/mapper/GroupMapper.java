package com.example.demo.mapper;

import com.example.demo.dto.AddGroupRequestBody;
import com.example.demo.dto.GetGroupResponseBody;
import com.example.demo.dto.GroupDomain;
import com.example.demo.entity.Group;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


import java.util.List;

@Mapper(componentModel = "spring")
public interface GroupMapper {

    @Mapping(target = "countStudent", expression = "java(group.getStudents().size())")
    List<GetGroupResponseBody> getListGroupResponseBody(List<GroupDomain> groupsDomain);

    @Mapping(target = "students", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "creationDate", expression = "java(new java.util.Date())")
    Group getGroup(AddGroupRequestBody groupRequestDTO);

    @Mapping(target = "countStudent", expression = "java(group.getStudents().size())")
    GetGroupResponseBody getGroupResponseBody(Group group);


    @Mapping(target = "studentDomainList", expression = "java(new StudentMapperImpl().getStudentsDomain(group.getStudents()))")
    GroupDomain getGroupDomain(Group group);

    List<GroupDomain> getGroupsDomainList(List<Group> groups);


}
