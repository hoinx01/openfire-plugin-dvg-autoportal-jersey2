package vn.dvg.autoportal.restapi.authentication;

import lombok.Getter;

@Getter
public enum ApplicationRole {
    APPLICATION(1, "application"),
    CHAT_PARTICIPANT(2, "chat_participant");

    private int id;
    private String name;

    ApplicationRole(int id, String name){
        this.id = id;
        this.name = name;
    }
}
