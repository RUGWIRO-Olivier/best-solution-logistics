package com.bestSolutionCargo.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.bestSolutionCargo.util.UtilIdGen;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@MappedSuperclass
public abstract class BaseEntity implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", length = 120, nullable = false)
    private String id;
    @Column(name = "status", length = 12, nullable = true)
    private String status;
    @Column(name = "creationTime", nullable = false, updatable = false, insertable = true)
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+0")
    private Date creationTime;
    @Column(name = "updateTime", nullable = true, insertable = false, updatable = true)
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+0")
    private Date updateTime;
    @Column(name = "createdBy", length = 90, nullable = true)
    private String createdBy;
    @Column(name = "updatedBy", length = 90, nullable = true)
    private String updatedBy;

    public BaseEntity() {
    }

    public BaseEntity(String id, String createdBy) {
        this.id = id;
        this.createdBy=createdBy;
    }


    @PrePersist
    private void onCreate() {
        this.setCreationTime(new Date());
        this.setId(this.getId() != null ? this.getId() : UtilIdGen.GEN());
        this.setStatus(this.getStatus() != null ? this.getStatus() : "1");
    }

    @PreUpdate
    private void onPersist() {
        this.setUpdateTime(new Date());
    }
}
