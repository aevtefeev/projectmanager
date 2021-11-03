package ru.crmkrd.projectmanager.dto;

import javax.validation.constraints.Size;

//@ApiModel()
public class RoleDto extends AbstractDto<Long> {
    private Long id;
    @Size(max = 10)
    private String role;

    public RoleDto() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return this.role;
    }
}