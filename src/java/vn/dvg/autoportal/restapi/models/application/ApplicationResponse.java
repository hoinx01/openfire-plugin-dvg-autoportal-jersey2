package vn.dvg.autoportal.restapi.models.application;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ApplicationResponse {
    private int id;
    private String name;
    private Date createdAt;
    private Date modifiedAt;
}
