package vn.dvg.autoportal.restapi.statics;

import lombok.Getter;

@Getter
public enum UserType {
    CHAT_PARTICIPANT(1,"chat_participant"),
    APPLICATION(2, "application");

    private int id;
    private String name;
    private UserType(int id, String name){
        this.id = id;
        this.name = name;
    }

}
