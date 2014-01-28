package my.gov.kpn.quiz.core.dao;

import my.gov.kpn.quiz.core.model.QaGenderType;
import my.gov.kpn.quiz.core.model.QaInstructor;
import my.gov.kpn.quiz.core.model.QaRaceType;
import my.gov.kpn.quiz.core.report.InstructorModel;
import my.gov.kpn.quiz.core.report.StudentModel;
import my.gov.kpn.quiz.core.report.StudentStatisticModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("reportDao")
public class ReportDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<InstructorModel> getInstructorList(String state) {


        String query = "select a.name,a.nric_no,a.phone,school_type(i.school_type),i.school_name,i.school_phone,a.email,count(astd.name) student_count " +
                "from QA_INTR i " +
                "inner join QA_ACTR a on i.id = a.id " +
                "left join QA_STDN s on s.INSTRUCTOR_ID = i.id " +
                "left join QA_ACTR astd on s.id = astd.id and astd.m_st = 1 " +
                "where a.m_st = 1  ";

        if (null != state && !state.isEmpty()) {
            query = query + " and i.state_id = " + state + " ";
        }

        query = query + "group by a.name,a.nric_no,a.phone,school_type(i.school_type),i.school_name,i.school_phone,a.email " +
                "order by a.name";


        List<InstructorModel> collection = this.jdbcTemplate.query(
                query,
                new InstructorRowMapper());

        return collection;
    }

    public List<StudentModel> getStudentList(String state, String schoolType, String schoolName) {


        String query = "select a.name,s.dob,gender_type(s.gender_type),extract (year from current_date) - extract (year from dob) age,race_type(s.race_type),school_type(s.school_type),s.school_name,a.nric_no " +
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

    public List<StudentModel> getStudentList(QaInstructor instructor) {


        String query = "select a.name,a.nric_no,s.dob,gender_type(s.gender_type),extract (year from current_date) - extract (year from dob) age,race_type(s.race_type),school_type(s.school_type),s.school_name,a.nric_no " +
                "from QA_STDN s " +
                "inner join QA_ACTR a on s.id = a.id where s.instructor_id = " + instructor.getId();


        query = query + " order by  a.name ";


        List<StudentModel> collection = this.jdbcTemplate.query(
                query,
                new StudentRowMapper());

        return collection;
    }

    public Collection<StudentStatisticModel> getStudentStatisticMap() {

        Map<Long, StudentStatisticModel> results = new HashMap<Long, StudentStatisticModel>();

        String query = "select state_id,race_type,count(race_type),t.name  from qa_stdn s " +
                "inner join qa_actr a on a.id = s.id " +
                "inner join qa_stte t on t.id = s.state_id " +
                "group by race_type,state_id,t.name ";


        List<StudentStatisticResult> raceResult = this.jdbcTemplate.query(query, new StudentStatisticRaceRowMapper());

        query = "select state_id,gender_type,count(gender_type),t.name from qa_stdn s " +
                "inner join qa_actr a on a.id = s.id " +
                "inner join qa_stte t on t.id = s.state_id " +
                "group by gender_type,state_id,t.name ";


        List<StudentStatisticResult> genderResult = this.jdbcTemplate.query(query, new StudentStatisticGenderRowMapper());

        if (null != raceResult) {
            for (StudentStatisticResult resultModel : raceResult) {
                StudentStatisticModel model = results.get(resultModel.getStateId());
                if (null == model) {
                    model = new StudentStatisticModel();
                    model.setStateId(resultModel.getStateId());
                    model.setStateName(resultModel.getStateName());
                }


                Map<Integer, Long> raceMap = resultModel.getRaceMap();

                if (null != raceMap.get(QaRaceType.MALAY.ordinal()))
                    model.setMalayTotal(raceMap.get(QaRaceType.MALAY.ordinal()));
                if (null != raceMap.get(QaRaceType.CHINESE.ordinal()))
                    model.setChineseTotal(raceMap.get(QaRaceType.CHINESE.ordinal()));
                if (null != raceMap.get(QaRaceType.INDIAN.ordinal()))
                    model.setIndianTotal(raceMap.get(QaRaceType.INDIAN.ordinal()));
                if (null != raceMap.get(QaRaceType.NATIVE_SABAH.ordinal()))
                    model.setNativeSabahTotal(raceMap.get(QaRaceType.NATIVE_SABAH.ordinal()));
                if (null != raceMap.get(QaRaceType.NATIVE_SARAWAK.ordinal()))
                    model.setNativeSarawakTotal(raceMap.get(QaRaceType.NATIVE_SARAWAK.ordinal()));
                if (null != raceMap.get(QaRaceType.OTHERS.ordinal()))
                    model.setOthersTotal(raceMap.get(QaRaceType.OTHERS.ordinal()));


                results.put(resultModel.getStateId(), model);
            }
        }

        if (null != genderResult) {
            for (StudentStatisticResult resultModel : genderResult) {
                StudentStatisticModel model = results.get(resultModel.getStateId());
                if (null == model) {
                    model = new StudentStatisticModel();
                    model.setStateId(resultModel.getStateId());
                    model.setStateName(resultModel.getStateName());
                }

                Map<Integer, Long> genderMap = resultModel.getGenderMap();

                if (null != genderMap.get(QaGenderType.MALE.ordinal()))
                    model.setMaleTotal(genderMap.get(QaGenderType.MALE.ordinal()));
                if (null != genderMap.get(QaGenderType.FEMALE.ordinal()))
                    model.setFemaleTotal(genderMap.get(QaGenderType.FEMALE.ordinal()));

                results.put(resultModel.getStateId(), model);
            }
        }


        return results.values();
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
            model.setNric(rs.getString("nric_no"));
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
            model.setNric(rs.getString("nric_no"));

            return model;
        }
    }

    private class StudentStatisticRaceRowMapper implements RowMapper<StudentStatisticResult> {


        @Override
        public StudentStatisticResult mapRow(ResultSet rs, int rowNum) throws SQLException {

            Long stateId = rs.getLong("state_id");
            StudentStatisticResult studentStatisticModel = new StudentStatisticResult();

            Integer raceType = rs.getInt(("race_type"));
            Long count = rs.getLong(("count"));
            studentStatisticModel.setStateId(stateId);
            studentStatisticModel.setStateName(rs.getString("name"));
            studentStatisticModel.getRaceMap().put(raceType, count);


            return studentStatisticModel;
        }
    }

    private class StudentStatisticGenderRowMapper implements RowMapper<StudentStatisticResult> {

        @Override
        public StudentStatisticResult mapRow(ResultSet rs, int rowNum) throws SQLException {

            Long stateId = rs.getLong("state_id");
            StudentStatisticResult studentStatisticModel = new StudentStatisticResult();

            Integer genderType = rs.getInt(("gender_type"));
            Long count = rs.getLong(("count"));

            studentStatisticModel.setStateId(stateId);
            studentStatisticModel.setStateName(rs.getString("name"));
            studentStatisticModel.getGenderMap().put(genderType, count);


            return studentStatisticModel;
        }
    }

    public class StudentStatisticResult {

        private Long stateId;
        private String stateName;
        private Map<Integer, Long> raceMap;
        private Map<Integer, Long> genderMap;

        public StudentStatisticResult() {
            raceMap = new HashMap<Integer, Long>();
            genderMap = new HashMap<Integer, Long>();
        }

        public Map<Integer, Long> getGenderMap() {
            return genderMap;
        }

        public void setGenderMap(Map<Integer, Long> genderMap) {
            this.genderMap = genderMap;
        }

        public Map<Integer, Long> getRaceMap() {
            return raceMap;
        }

        public void setRaceMap(Map<Integer, Long> raceMap) {
            this.raceMap = raceMap;
        }

        public Long getStateId() {
            return stateId;
        }

        public void setStateId(Long stateId) {
            this.stateId = stateId;
        }

        public String getStateName() {
            return stateName;
        }

        public void setStateName(String stateName) {
            this.stateName = stateName;
        }
    }

}
