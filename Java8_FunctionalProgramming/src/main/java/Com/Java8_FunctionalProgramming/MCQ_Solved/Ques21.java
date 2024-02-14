package Com.Java8_FunctionalProgramming.MCQ_Solved;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.TemporalAdjusters;

public class Ques21 {
    public static void main(String[] args) {
        LocalDate today=LocalDate.now();
                LocalDate lastDay=    today.with(TemporalAdjusters.lastDayOfYear());
        System.out.println(lastDay);
        Period period=today.until(lastDay); // period.getDays() -> no of days left in this month
        System.out.println("Months remaining in the current year: "+period.getMonths());
    }
}
