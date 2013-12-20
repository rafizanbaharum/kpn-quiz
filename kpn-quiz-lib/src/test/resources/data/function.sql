CREATE or replace FUNCTION public.gender_type
(val integer)
RETURNS text AS $$
        BEGIN
        if val = 0 then
                return 'PEREMPUAN';
        elsif val = 1 then return 'LELAKI';
        else
           RETURN '-';
        end if;
        END;
$$ LANGUAGE plpgsql;


CREATE or replace FUNCTION public.race_type
(val integer)
RETURNS text AS $$
        BEGIN
        if val = 0 then return 'MELAYU';
        elsif val = 1 then return 'CINA';
        elsif val = 2 then return 'INDIA';
        elsif val = 3 then return 'BUMIPUTERA SABAH';
        elsif val = 4 then return 'BUMIPUTERA SARAWAK';
        elsif val = 5 then return 'LAIN LAIN';
        else
           RETURN '-';
        end if;
        END;
$$ LANGUAGE plpgsql;

CREATE or replace FUNCTION public.school_type
(val integer)
RETURNS text AS $$
        BEGIN
        if val = 0 then return 'SMK';
        elsif val = 1 then return 'PRIVATE';
        elsif val = 2 then return 'SBP';
        elsif val = 3 then return 'SMK TEKNIK';
        elsif val = 4 then return 'SMKJ(C)';
        elsif val = 5 then return 'SMKJ(T)';
        elsif val = 6 then return 'SMA';
        elsif val = 7 then return 'MRSM';
        else
           RETURN '-';
        end if;
        END;
$$ LANGUAGE plpgsql;


