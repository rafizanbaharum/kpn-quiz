package my.gov.kpn.quiz.manual;

import my.gov.kpn.quiz.biz.manager.ManualProcessManager;
import my.gov.kpn.quiz.core.model.QaTempAnswer;
import my.gov.kpn.quiz.core.model.impl.QaTempAnswerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

@Service
public class ManualAnswerProcessor {

    private String inputDir = "";

    @Autowired
    private ExcelReader excelReader;

    @Autowired
    private ManualProcessManager manualProcessManager;

    public void start(){

        File dir = new File(inputDir);
        FilenameFilter filter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                if (name.contains(".xls")) return true;
                if (name.contains(".xlsx")) return true;
                return false;
            }
        };

        File[] files = dir.listFiles(filter);
        for (File file : files) {
            if (file.canRead()){
                try {
                    StudentAnswerModel studentAnswerModel = excelReader.readAnswer(file.getName());
                    QaTempAnswer answer = transform(studentAnswerModel);
                    manualProcessManager.writeStudentAnswer(answer);
                    manualProcessManager.writeSuccessFileReadLog(file.getName());
                    file.delete();
                } catch (IOException e) {
                    manualProcessManager.writeErrorFileReadLog(file.getName(),e.getMessage());
                }
            }
        }


    }


    private QaTempAnswer transform(StudentAnswerModel model){

        QaTempAnswerImpl tempAnswer = new QaTempAnswerImpl();
        tempAnswer.setName(model.getName());
        tempAnswer.setNric(model.getNric());
        int id = 1;

        tempAnswer.setAnswer01(model.getAnswers().get(id++));
        tempAnswer.setAnswer02(model.getAnswers().get(id++));
        tempAnswer.setAnswer03(model.getAnswers().get(id++));
        tempAnswer.setAnswer04(model.getAnswers().get(id++));
        tempAnswer.setAnswer05(model.getAnswers().get(id++));
        tempAnswer.setAnswer06(model.getAnswers().get(id++));
        tempAnswer.setAnswer07(model.getAnswers().get(id++));
        tempAnswer.setAnswer08(model.getAnswers().get(id++));
        tempAnswer.setAnswer09(model.getAnswers().get(id++));
        tempAnswer.setAnswer10(model.getAnswers().get(id++));

        tempAnswer.setAnswer11(model.getAnswers().get(id++));
        tempAnswer.setAnswer12(model.getAnswers().get(id++));
        tempAnswer.setAnswer13(model.getAnswers().get(id++));
        tempAnswer.setAnswer14(model.getAnswers().get(id++));
        tempAnswer.setAnswer15(model.getAnswers().get(id++));
        tempAnswer.setAnswer16(model.getAnswers().get(id++));
        tempAnswer.setAnswer17(model.getAnswers().get(id++));
        tempAnswer.setAnswer18(model.getAnswers().get(id++));
        tempAnswer.setAnswer19(model.getAnswers().get(id++));
        tempAnswer.setAnswer20(model.getAnswers().get(id++));

        tempAnswer.setAnswer21(model.getAnswers().get(id++));
        tempAnswer.setAnswer22(model.getAnswers().get(id++));
        tempAnswer.setAnswer23(model.getAnswers().get(id++));
        tempAnswer.setAnswer24(model.getAnswers().get(id++));
        tempAnswer.setAnswer25(model.getAnswers().get(id++));
        tempAnswer.setAnswer26(model.getAnswers().get(id++));
        tempAnswer.setAnswer27(model.getAnswers().get(id++));
        tempAnswer.setAnswer28(model.getAnswers().get(id++));
        tempAnswer.setAnswer29(model.getAnswers().get(id++));
        tempAnswer.setAnswer30(model.getAnswers().get(id++));

        tempAnswer.setAnswer31(model.getAnswers().get(id++));
        tempAnswer.setAnswer32(model.getAnswers().get(id++));
        tempAnswer.setAnswer33(model.getAnswers().get(id++));
        tempAnswer.setAnswer34(model.getAnswers().get(id++));
        tempAnswer.setAnswer35(model.getAnswers().get(id++));
        tempAnswer.setAnswer36(model.getAnswers().get(id++));
        tempAnswer.setAnswer37(model.getAnswers().get(id++));
        tempAnswer.setAnswer38(model.getAnswers().get(id++));
        tempAnswer.setAnswer39(model.getAnswers().get(id++));
        tempAnswer.setAnswer40(model.getAnswers().get(id++));

        tempAnswer.setAnswer41(model.getAnswers().get(id++));
        tempAnswer.setAnswer42(model.getAnswers().get(id++));
        tempAnswer.setAnswer43(model.getAnswers().get(id++));
        tempAnswer.setAnswer44(model.getAnswers().get(id++));
        tempAnswer.setAnswer45(model.getAnswers().get(id++));
        tempAnswer.setAnswer46(model.getAnswers().get(id++));
        tempAnswer.setAnswer47(model.getAnswers().get(id++));
        tempAnswer.setAnswer48(model.getAnswers().get(id++));
        tempAnswer.setAnswer49(model.getAnswers().get(id++));
        tempAnswer.setAnswer50(model.getAnswers().get(id++));

        tempAnswer.setAnswer51(model.getAnswers().get(id));



        return tempAnswer;
    }
}
