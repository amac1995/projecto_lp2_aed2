package projeto;

import java.time.*;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.ChronoLocalDateTime;
import java.time.temporal.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Date implements Comparable<Date>, Temporal {

    private int hour;

    private int min;

    private int day;

    private int month;

    private int year;

    public Date(int hour, int min, int day, int month, int year) {
        this.hour = hour;
        this.min = min;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public Date(int day, int month, int year) {
        this.hour = 00;
        this.min = 00;
        this.setDay(day);
        this.setMonth(month);
        this.setYear(year);
    }

    public Date(int month, int year) {
        this.hour = 00;
        this.min = 00;
        this.setDay(1);
        this.setMonth(month);
        this.setYear(year);
    }

    public Date() {
        Calendar gregCalendar = new GregorianCalendar();
        this.setDay(gregCalendar.get(Calendar.DAY_OF_MONTH));
        this.setMonth(gregCalendar.get(Calendar.MONTH));
        this.setYear(gregCalendar.get(Calendar.YEAR));
        this.setHour(gregCalendar.get(Calendar.HOUR));
        this.setMin(gregCalendar.get(Calendar.MINUTE));
    }

    public void DataHoje(Date d){
        LocalDate hoje= LocalDate.now();
        System.out.println(hoje);
    }

    public boolean beforeDate(Date d) {
        if (this.getYear() < d.getYear()) {
            return true;
        }
        else if (this.getYear() == d.getYear()) {
            if (this.getMonth() < d.getMonth()) {
                return true;
            } else if (this.getMonth() == d.getMonth()) {
                return this.getDay() < d.getDay();
            } else if(this.getHour()==d.getHour()){
                return this.getHour() < d.getHour();
            } else if(this.getMin()==d.getMin()){
                return this.getMin() < d.getMin();
            }
        }
        return false;
    }


    public int daysMonth(int month, int year) {
        switch (month) {
            case 11:
            case 9:
            case 6:
            case 4:
                return 30;
            case 2:
                return (isLeapYear(year) ? 29 : 28);
            default:
                return 31;

        }
    }

    public boolean afterDate(Date d) {

        return false;
    }

    public void incrementDate(int i) {

        this.setDay(getDay()+i);

    }

    public boolean isLeapYear() { //multiplo de (4 e nao é 100) ou (4 e 400)

        return this.isLeapYear(this.getYear());
    }

    public boolean isLeapYear(int year) {

        return ((year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0)));
    }

    public int differenceYears(Date d) {
        //int yy, mm, dd, hh, mi;
        if (this.getYear()==d.getYear()){
            System.out.println("Os anos são iguais!!");

        }
        return 0;
    }

    public long diferenceHour(Date d1, Date d2){
        return ChronoUnit.HOURS.between(d1, d2);
    }

    public static void diferenceHours(LocalDateTime d3, LocalDateTime d4){

        Duration difHour = Duration.between(d3, d4);
        //System.out.println(difHour);
        System.out.println("Horas: "+difHour.toHours() +"Segundos: "+difHour.getSeconds()+" Nanos: "+difHour.getNano());
    }

    public int compareTo(Date d){
        if (this.getYear() == d.getYear() && this.getMonth() == d.getMonth() && this.getDay() == d.getDay() && this.getHour()== d.getMin() && this.getMin()==d.getMin()){
            return 0;
        } else if(this.beforeDate(d)){
            return -1;
        } else {
            return 1;
        }
    }


    
    //Gets e Sets
    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    @Override
    public String toString() {
        return "Date{" +
                "hour=" + hour +
                ", min=" + min +
                ", day=" + day +
                ", month=" + month +
                ", year=" + year +
                '}';
    }

    @Override
    public boolean isSupported(TemporalUnit unit) {
        return false;
    }

    @Override
    public Temporal with(TemporalField field, long newValue) {
        return null;
    }

    @Override
    public Temporal plus(long amountToAdd, TemporalUnit unit) {
        return null;
    }

    @Override
    public long until(Temporal endExclusive, TemporalUnit unit) {
        return 0;
    }

    @Override
    public boolean isSupported(TemporalField field) {
        return false;
    }

    @Override
    public long getLong(TemporalField field) {
        return 0;
    }
}