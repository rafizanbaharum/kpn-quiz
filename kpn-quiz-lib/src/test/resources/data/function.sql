CREATE or replace FUNCTION public.gender_type
(val integer)
RETURNS text AS $$
        BEGIN
        if val = 0 then
                return 'M';
        elsif val = 1 then return 'F';
        else
           RETURN '-';
        end if;
        END;
$$ LANGUAGE plpgsql;


CREATE or replace FUNCTION public.race_type
(val integer)
RETURNS text AS $$
        BEGIN
        if val = 0 then return 'MALAY';
        elsif val = 1 then return 'CHINESE';
        elsif val = 2 then return 'INDIAN';
        elsif val = 3 then return 'NATIVE SABAH';
        elsif val = 4 then return 'NATIVE SARAWAK';
        elsif val = 5 then return 'OTHERS';
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


