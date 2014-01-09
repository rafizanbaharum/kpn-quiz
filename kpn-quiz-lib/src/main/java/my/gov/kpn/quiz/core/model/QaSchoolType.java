package my.gov.kpn.quiz.core.model;

/**
 * @author rafizan.baharum
 * @since 7/15/13
 */
public enum QaSchoolType {
    /*
1) Sekolah Menengah Kebangsaan (SMK)
2) Sekolah Menengah Berasrama Penuh (SBP)
3) Sekolah Menengah Teknik & Vokasional (SMT/V)
4) Sekolah Menengah Kebangsaan Agama (SMKA)
5) Sekolah Agama Bantuan Kerajaan (SABK)
6) Sekolah Menengah Seni Dan Sukan (SM Sains Dan Sukan)
7) Sekolah Persendirian / Swasta (Persendirian/Swasta)
*/
    SMK,
    SBP,
    SMT_V,
    SMKA,
    SABK,
    SMS,
    PRIVATE;

    public static QaSchoolType get(int index) {
        return values()[index];
    }

}
