package in.ongrid.kshitijroy.model.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Date;

@MappedSuperclass
public class ResourceInfo {


    @Column
    private Date created;

    @Column
    private Date updated;

    @PrePersist
    public void onCreate(){
        created =new Date();
    }

    @PreUpdate
    public void onUpdate(){
        updated =new Date();
    }


    public Date getCreated() {
        return created;
    }

    public void setCreated(Date resourceCreate) {
        this.created = resourceCreate;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date resourceUpdate) {
        this.updated = resourceUpdate;
    }
}
