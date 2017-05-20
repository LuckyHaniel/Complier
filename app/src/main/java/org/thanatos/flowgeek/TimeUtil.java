package org.thanatos.flowgeek;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zsachg on 2017/5/18.
 */
public class TimeUtil {

    public static String getCuurentTime(){
        Date date=new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(date)+"";
    }

}
