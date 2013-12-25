package my.gov.kpn.quiz.core.dao;

import my.gov.kpn.quiz.core.report.InstructorModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.List;

@Repository("reportDao")
public class ReportDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<InstructorModel> getInstructorList() {


        String query = "select a.name,a.phone,school_type(i.school_type),i.school_name,i.school_phone,a.email,count(1) student_count " +
                "from QA_INTR i " +
                "inner join QA_ACTR a on i.id = a.id " +
                "inner join QA_STDN s on s.INSTRUCTOR_ID = i.id " +
                "inner join QA_ACTR astd on s.id = astd.id " +
                "where a.m_st = 1 and astd.m_st = 1 " +
                "group by a.name,a.phone,school_type(i.school_type),i.school_name,i.school_phone,a.email " +
                "order by a.name";


        List<InstructorModel> collection = this.jdbcTemplate.query(
                query,
                new InstructorRowMapper());

        return collection;
    }


    private class InstructorRowMapper implements RowMapper<InstructorModel>{

        @Override
        public InstructorModel mapRow(ResultSet rs, int rowNum) throws SQLException {
            InstructorModel model = new InstructorModel();
            model.setName(rs.getString("name"));
            model.setPhone(rs.getString("phone"));
            model.setSchool_type(rs.getString("school_type"));
            model.setSchool_name(rs.getString("school_name"));
            model.setSchool_phone(rs.getString("school_phone"));
            model.setEmail(rs.getString("email"));
            model.setStudent_count(rs.getLong("student_count"));
            return model;
        }
    }

}
