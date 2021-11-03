package ru.crmkrd.projectmanager.dto;

import javax.validation.constraints.Size;

//@ApiModel()
public class StatusDto extends AbstractDto<Long> {
    private Long id;
    @Size(max = 120)
    private String caption;

    public StatusDto() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getCaption() {
        return this.caption;
    }
}