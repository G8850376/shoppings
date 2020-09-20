package com.mapper;

import com.pojo.Department;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeptMapper {

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into dept(departmentName) values(#{departmentName})")
    public int insertDept(Department department);

    @Update("update dept set departmentName=#{departmentName} where id=#{id}")
    public int updateDept(Department department);

    @Delete("delete from dept where id=#{id}")
    public int deleteDept(Integer id);

    @Select("select * from dept where id=#{id}")
    public Department getDeptById(Integer id);

    @Select("select * from dept")
    public List<Department> getDeptByAll();

}
