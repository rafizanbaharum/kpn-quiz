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
        if val = 0 then return 'M';
        elsif val = 1 then return 'C';
        elsif val = 2 then return 'I';
        elsif val = 3 then return 'SB';
        elsif val = 4 then return 'SW';
        elsif val = 5 then return 'O';
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


