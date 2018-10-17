package main;

import udf.WeekdaysFun;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author: xiliang
 * @Date: 2018/10/17 15:09
 **/

public class App {
    private static App app;

    private App(){ }

    public static App getAppInstance(){
        if(app == null){
            synchronized(App.class){
                if(app == null){
                    app = new App();
                }
            }
        }
        return app;
    }


    private int isWeekday(String input) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        try {
            Date date = sdf.parse(input);
            cal.setTime(date);
            if(cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY   ){
                return 1;
            }
            return 0;
        }catch (Exception e){
            e.getMessage();
        }
        return -1;
    }

    public static void main(String[] args){
        App app = App.getAppInstance();
        String input = "20181020" ;
        System.out.println( app.isWeekday(input) );
    }
}
