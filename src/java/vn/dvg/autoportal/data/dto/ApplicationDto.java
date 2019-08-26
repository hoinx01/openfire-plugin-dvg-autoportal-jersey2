package vn.dvg.autoportal.data.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "ofdvgapapplications")
public class ApplicationDto extends BaseIntEntity {
    private String name;
    private String secretKey;
    private Date createdAt;
    private Date modifiedAt;
}
