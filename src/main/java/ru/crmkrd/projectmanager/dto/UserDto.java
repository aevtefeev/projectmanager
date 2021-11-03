package ru.crmkrd.projectmanager.dto;

import ru.crmkrd.projectmanager.entity.Role;

import javax.validation.constraints.Size;

//@ApiModel()
public class UserDto extends AbstractDto<Long> {
    private Long id;
    @Size(max = 30)
    private String name;
    @Size(max = 30)
    private String secondName;
    private Role role;

    public UserDto() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getSecondName() {
        return this.secondName;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Role getRole() {
        return this.role;
    }
}