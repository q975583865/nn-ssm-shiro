package com.qppi.crud.bean;

import org.hibernate.validator.constraints.NotBlank;

import com.qppi.crud.utils.QpGroup;

public class PartBuyMx {
	
    private String id;
    @NotBlank(message="不能为空",groups=QpGroup.Add.class)
    private String name;
    @NotBlank(message="不能为空",groups=QpGroup.Add.class)
    private String num;
    @NotBlank(message="不能为空",groups=QpGroup.Add.class)
    private Integer count;
    @NotBlank(message="不能为空",groups=QpGroup.Add.class)
    private String repo;

    private String partBuyId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num == null ? null : num.trim();
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getRepo() {
        return repo;
    }

    public void setRepo(String repo) {
        this.repo = repo == null ? null : repo.trim();
    }

    public String getPartBuyId() {
        return partBuyId;
    }

    public void setPartBuyId(String partBuyId) {
        this.partBuyId = partBuyId == null ? null : partBuyId.trim();
    }
}