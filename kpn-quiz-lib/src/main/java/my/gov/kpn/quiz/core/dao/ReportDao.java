package my.gov.kpn.quiz.core.dao;

import my.gov.kpn.quiz.core.report.InstructorModel;
import my.gov.kpn.quiz.core.report.StudentModel;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.List;

@Repository("reportDao")
public class ReportDao implements InitializingBean {

    @Autowired
    private DataSource dataSource;

    private JdbcTemplate jdbcTemplate;

    @Override
    public void afterPropertiesSet() throws Exception {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<InstructorModel> getInstructorList(String state) {


        String query = "select a.name,a.phone,school_type(i.school_type),i.school_name,i.school_phone,a.email,count(1) student_count " +
                "from QA_INTR i " +
                "inner join QA_ACTR a on i.id = a.id " +
                "inner join QA_STDN s on s.INSTRUCTOR_ID = i.id " +
                "inner join QA_ACTR astd on s.id = astd.id " +
                "where a.m_st = 1 and astd.m_st = 1 ";

        if (null != state && !state.isEmpty()) {
            query = query + " and i.state_id = " + state + " ";
        }

        query = query + "group by a.name,a.phone,school_type(i.school_type),i.school_name,i.school_phone,a.email " +
                "order by a.name";


        List<InstructorModel> collection = this.jdbcTemplate.query(
                query,
                new InstructorRowMapper());

        return collection;
    }

    public List<StudentModel> getStudentList(String state, String schoolType, String schoolName) {


        String query = "select a.name,s.dob,gender_type(s.gender_type),extract (year from current_date) - extract (year from dob) age,race_type(s.race_type),school_type(s.school_type),s.school_name " +
                "from QA_STDN s " +
                "inner join QA_ACTR a on s.id = a.id ";

        if (null != state && !state.isEmpty()) {
            query = query + " and s.state_id = " + state + " ";
        }

        if (null != schoolType && !schoolType.isEmpty()) {
            query = query + " and s.school_type = " + schoolType + " ";
        }

        if (null != schoolName && !schoolName.isEmpty()) {
            query = query + " and s.school_name = " + schoolName + " ";
        }

        query = query + "order by s.school_name, a.name ";


        List<StudentModel> collection = this.jdbcTemplate.query(
                query,
                new StudentRowMapper());

        return collection;
    }


    private class InstructorRowMapper implements RowMapper<InstructorModel> {

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

    private class StudentRowMapper implements RowMapper<StudentModel> {

        @Override
        public StudentModel mapRow(ResultSet rs, int rowNum) throws SQLException {

            StudentModel model = new StudentModel();
            model.setName(rs.getString("name"));
            model.setAge(rs.getDouble("age"));
            model.setDob(rs.getTimestamp("dob"));
            model.setRace_type(rs.getString("race_type"));
            model.setGender_type(rs.getString("gender_type"));
            model.setSchool_type(rs.getString("school_type"));
            model.setSchool_name(rs.getString("school_name"));

            return model;
        }
    }

}
