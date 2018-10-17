package udf;

import org.apache.hadoop.hive.ql.exec.UDF;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author: xiliang
 * @Date: 2018/10/17 15:00
 **/

public class WeekdaysFun extends UDF {

    public int evaluate(String date){
        return isWeekday(date);
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


}
