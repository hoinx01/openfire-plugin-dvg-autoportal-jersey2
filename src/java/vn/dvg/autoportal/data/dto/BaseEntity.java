package vn.dvg.autoportal.data.dto;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntity<TId> extends BaseDto{
    public abstract TId getId();
    public abstract void setId(TId id);
}
