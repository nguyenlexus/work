set serveroutput on
declare
    
    HW_Pct percentages.HWPct%type;
    Mid_Pct percentages.MidPct%type;
    Fin_Pct percentages.FinPct%type;
    Lab_Pct percentages.LabPct%type;
    
    cursor studentPTR is SELECT * FROM STUDENT;
    sID student.ID%type;
    fullname student.Name%type;
    hw student.HOMEWORK%type;
    mt student.MIDTERM%type;
    f student.FINAL%type;
    l student.LABS%type;
    
    w NUMBER;
    x NUMBER;
    y NUMBER;
    z NUMBER;
    
    pSum number:= 0;
    
    
begin
    SELECT HWPct, MidPct, FinPct, LabPct INTO HW_Pct, Mid_Pct, Fin_Pct, Lab_Pct
    FROM PERCENTAGES;
    dbms_output.put_line ('Percentages are ' || HW_Pct || ' ' || Mid_Pct || ' ' || Fin_Pct || ' ' || Lab_Pct);
    open studentPTR;
    loop
        fetch studentPTR into sID, fullname, hw, mt, f, l;
        if studentPTR%found then 
            w := hw;
            x := mt;
            y := f;
            z := l;
            pSum := (w + x + y + z) / 4;
            dbms_output.put_line (sID || ' ' || fullname || ' ' || pSum);
        else
            exit;
            
        end if;
    end loop;
    close studentPTR;
end;