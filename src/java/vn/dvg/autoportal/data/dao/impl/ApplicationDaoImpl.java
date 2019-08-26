package vn.dvg.autoportal.data.dao.impl;

import lombok.val;
import vn.dvg.autoportal.data.dao.ApplicationDao;
import vn.dvg.autoportal.data.dto.ApplicationDto;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public class ApplicationDaoImpl extends BaseDaoImpl<ApplicationDto, Integer> implements ApplicationDao {
//public class ApplicationDaoImpl implements ApplicationDao {
    public ApplicationDaoImpl(){

        super(ApplicationDto.class);
    }
//    public ApplicationDto getById(int id){
//        return new ApplicationDto();
//    }
    public static List<ApplicationDto> getAll() throws SQLException, IllegalAccessException {
        String statement = "select * from ofdvgapapplications";
        val applicationDtoes = BaseDaoImpl.Query(statement, null, ApplicationDto.class);
        return applicationDtoes;
    }

    public static List<ApplicationDto> filter() throws SQLException, IllegalAccessException {
        String statement = "select * from ofdvgapapplications where id =:id";
        val applicationDtoes = BaseDaoImpl.Query(statement, new HashMap<String, Object>(){
            {put("id", 1);}
        }, ApplicationDto.class);
        return applicationDtoes;
    }

    public static int add() throws Exception{
        String statement = "insert into ofdvgapapplications(name, createdAt, modifiedAt)\n" +
                "values('test02', now(), now()),('test03', now(), now())";
        val insertResult = BaseDaoImpl.Execute(statement, null);
        return insertResult;
    }
}
