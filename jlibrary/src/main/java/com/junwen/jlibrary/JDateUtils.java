package com.junwen.jlibrary;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

import static com.junwen.jlibrary.JDateUtils.DataFormatType.FORMAT_NONE_YYYY_MM_DD;

/**
 * 描述:时间工具类
 * 作者:卜俊文
 * 邮箱:344176791@qq.com
 * 创建时间: 2016/8/11 16:19
 */
public class JDateUtils {

    private static GregorianCalendar calendar = new GregorianCalendar();

    public class DataFormatType {

        //年月日，无中文
        public static final String FORMAT_NONE_YYYY_MM_DD = "yyyy-MM-dd";

        //年月
        public static final String FORMAT_NONE_YYYY_MM = "yyyy-MM";

        //年
        public static final String FORMAT_NONE_YYYY = "yyyy";

        //年月日，带中文
        public static final String FORMAT_Month_YYYY_MM_DD = "yyyy年MM月dd";

        //年月日，小时分钟秒，无中文
        public static final String FORMAT_NONE_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

        //年月日，小时分钟秒，带中文
        public static final String FORMAT_MONTH_YYYY_MM_DD_HH_MM_SS = "yyyy年MM月dd HH:mm:ss";

        //月日 小时分钟秒，无中文
        public static final String FORMAT_NONE_MM_DD_HH_MM_SS = "MM-dd HH:mm:ss";

        //月日
        public static final String FORMAT_NONE_MM_DD = "MM-dd";

        //月日 小时分钟秒，有中文
        public static final String FORMAT_MONTH_MM_DD_HH_MM_SS = "MM月dd HH:mm:ss";

        //小时分钟秒
        public static final String FORMAT_HH_MM_SS = "HH:mm:ss";

        //分钟秒
        public static final String FORMAT_MM_SS = "mm:ss";

        //小时分钟
        public static final String FORMAT_HH_MM = "HH:mm";
    }

    public final static String[] zodiacArray = {"猴", "鸡", "狗", "猪", "鼠", "牛", "虎",
            "兔", "龙", "蛇", "马", "羊"};

    public final static String[] constellationArray = {"水瓶座", "双鱼座", "牡羊座", "金牛座",
            "双子座", "巨蟹座", "狮子座", "处女座", "天秤座", "天蝎座", "射手座", "魔羯座"};

    public final static int[] constellationDay = {20, 19, 21, 21, 21, 22, 23, 23, 23,
            24, 23, 22};

    public static final String DATA_TYPE_YEAR = "data_type_year"; //年份类型

    public static final String DATA_TYPE_MONTH = "data_type_month"; //月份类型

    public static final String DATA_TYPE_DAY = "data_type_day"; //天数类型

    public static final String DATA_TYPE_HOUR = "data_type_hour"; //小时类型

    public static final String DATA_TYPE_MINUTE = "data_type_minute"; //分钟类型

    public static final String DATA_TYPE_SECONDS = "data_type_seconds"; //秒类型

    /**
     * 描述:获取当前日期,返回格式 yyyy-MM-dd HH:mm:ss
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/8/11 16:19
     */
    public static String getCurrDate() {
        return new SimpleDateFormat(DataFormatType.FORMAT_NONE_YYYY_MM_DD_HH_MM_SS).format(new Date());
    }

    /**
     * 描述:获取当前日期根据格式
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/11/3 8:39
     */
    public static String getCurrDate(String format) {
        return new SimpleDateFormat(format).format(new Date());
    }


    /**
     * 描述:String转Date
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/9/2 10:25
     */
    public static Date stringToDate(String string, String formatType) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(formatType);
            Date date = null;
            date = formatter.parse(string);
            return date;
        } catch (Exception e) {
        }
        return null;
    }

    /**
     * 描述:Date转String类型
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/9/2 10:24
     */
    public static String dateToString(Date data, String format) {
        return new SimpleDateFormat(format).format(data);
    }

    /**
     * 描述:Date数据转换Long
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/9/2 10:21
     */
    public static long dateToLong(Date date) {
        return date.getTime();
    }


    /**
     * 描述:Long转换Date
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/9/2 10:22
     */
    public static Date longToDate(long currentTime, String format)
            throws ParseException {
        Date dateOld = new Date(currentTime); // 根据long类型的毫秒数生命一个date类型的时间
        String sDateTime = dateToString(dateOld, format); // 把date类型的时间转换为string
        Date date = stringToDate(sDateTime, format); // 把String类型转换为Date类型
        return date;
    }

    /**
     * 描述:Long转成String
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/9/2 10:24
     */
    public static String longToString(long currentTime, String format)
            throws ParseException {
        Date date = longToDate(currentTime, format); // long类型转成Date类型
        String strTime = dateToString(date, format); // date类型转成String
        return strTime;
    }

    /**
     * 描述:String转Long
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/9/2 10:26
     */
    public static long stringToLong(String string, String format)
            throws ParseException {
        Date date = stringToDate(string, format); // String类型转成date类型
        if (date == null) {
            return 0;
        } else {
            long currentTime = dateToLong(date); // date类型转成long类型
            return currentTime;
        }
    }

    /**
     * 描述:清除时区。有时候只是格式化时间数字，不希望把时区换算出来
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/8/11 16:20
     */
    public static String format(long timeMillis, String format,
                                boolean clearTimeZone) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        if (clearTimeZone)
            sdf.setTimeZone(TimeZone.getTimeZone("GMT+00"));
        return sdf.format(new Date(timeMillis));
    }

    /**
     * 描述:转换中文对应的时段
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/8/11 16:20
     */
    public static String convertNowHour2CN(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH");
        String hourString = sdf.format(date);
        int hour = Integer.parseInt(hourString);
        if (hour < 6) {
            return "凌晨";
        } else if (hour >= 6 && hour < 12) {
            return "早上";
        } else if (hour == 12) {
            return "中午";
        } else if (hour > 12 && hour <= 18) {
            return "下午";
        } else if (hour >= 19) {
            return "晚上";
        }
        return "";
    }


    /**
     * 描述:增加小时，返回增加后的日期。
     * 现在的时间，2016-09-02 14:11:35
     * JDateUtils.getNextHour(JDateUtils.DataFormatType.FORMAT_NONE_YYYY_MM_DD_HH_MM_SS, 2)
     * 增加后的，2016-09-02 16:11:35
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/8/11 16:20
     */
    public static String getNextHour(String format, int hour) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date = new Date();
        date.setTime(date.getTime() + hour * 60 * 60 * 1000);
        return sdf.format(date);
    }

    /**
     * 描述:在日期上增加年月日小时分钟秒，正数就是加，负数是减
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/8/11 16:20
     */
    public static Date addOrDeleteDate(Date date, int n, String datatype) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        if (datatype.equals(DATA_TYPE_YEAR)) {
            //年数
            cal.add(Calendar.YEAR, n);
        } else if (datatype.equals(DATA_TYPE_MONTH)) {
            //月份
            cal.add(Calendar.MONTH, n);
        } else if (datatype.equals(DATA_TYPE_DAY)) {
            //天数
            cal.add(Calendar.DATE, n);
        } else if (datatype.equals(DATA_TYPE_DAY)) {
            //天数
            cal.add(Calendar.DATE, n);
        } else if (datatype.equals(DATA_TYPE_HOUR)) {
            //小时
            cal.add(Calendar.HOUR, n);
        } else if (datatype.equals(DATA_TYPE_MINUTE)) {
            //分钟
            cal.add(Calendar.MINUTE, n);
        } else if (datatype.equals(DATA_TYPE_SECONDS)) {
            //秒
            cal.add(Calendar.SECOND, n);
        }
        return cal.getTime();
    }

    /**
     * 描述:获取指定毫秒数的对应星期
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/8/11 16:21
     */
    public static String getWeek(long millis) {
        calendar.setTimeInMillis(millis);
        String week = "";
        int cweek = calendar.get(Calendar.DAY_OF_WEEK);
        switch (cweek) {
            case 1:
                week = "日";
                break;
            case 2:
                week = "一";
                break;
            case 3:
                week = "二";
                break;
            case 4:
                week = "三";
                break;
            case 5:
                week = "四";
                break;
            case 6:
                week = "五";
                break;
            case 7:
                week = "六";
                break;
        }
        return week;

    }

    /**
     * 描述:根据输入的年、月、日，转换成毫秒表示的时间
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/8/11 16:21
     */
    public static long getMillis(int year, int month, int day) {
        GregorianCalendar calendar = new GregorianCalendar(year, month, day);
        return calendar.getTimeInMillis();

    }

    /**
     * 描述:根据输入的年、月、日，转换成毫秒表示的时间
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/8/11 16:21
     */
    public static long getMillis(String yearString, String monthString,
                                 String dayString) {
        int year = Integer.parseInt(yearString);
        int month = Integer.parseInt(monthString) - 1;
        int day = Integer.parseInt(dayString);
        return getMillis(year, month, day);

    }

    /**
     * 描述: 根据输入的毫秒数，获得日期字符串
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/8/11 16:21
     */
    public static String getDate(long millis) {
        calendar.setTimeInMillis(millis);
        return DateFormat.getDateInstance().format(calendar.getTime());
    }

    /**
     * 描述: 获得当前时间的毫秒表示
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/8/11 16:21
     */
    public static long getNow() {
        GregorianCalendar now = new GregorianCalendar();
        return now.getTimeInMillis();
    }

    /**
     * 描述:获得今天日期
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/8/11 16:21
     */
    public static String getTodayData() {
        return getDate(getNow());
    }

    /**
     * 描述:提供“yyyy-mm-dd”形式的字符串到毫秒的转换
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/8/11 16:21
     */
    public static long getMillis(String dateString) {
        String[] date = dateString.split("-");
        return getMillis(date[0], date[1], date[2]);
    }

    /**
     * 描述:获得明天日期
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/8/11 16:21
     */
    public static String getTomoData() {
        // 86400000为一天的毫秒数
        return getDate(getNow() + 86400000);
    }

    /**
     * 描述: 获得后天日期
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/8/11 16:21
     */
    public static String getTheDayData() {
        return getDate(getNow() + 86400000 + 86400000);
    }

    /**
     * 描述:获得昨天日期
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/8/11 16:21
     */
    public static String getYesData() {
        return getDate(getNow() - 86400000L);
    }

    /**
     * 描述:获得前天日期
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/8/11 16:21
     */
    public static String getBeforeYesData() {
        return getDate(getNow() - 86400000L - 86400000L);
    }

    /**
     * 描述:获取今天时间具体内容
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/8/11 16:21
     */
    public static String StringData() {
        final Calendar c = Calendar.getInstance();
        c.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        String mYear = String.valueOf(c.get(Calendar.YEAR)); // 获取当前年份
        String mMonth = String.valueOf(c.get(Calendar.MONTH) + 1);// 获取当前月份
        String mDay = String.valueOf(c.get(Calendar.DAY_OF_MONTH));// 获取当前月份的日期号码
        String mWay = String.valueOf(c.get(Calendar.DAY_OF_WEEK));
        if ("1".equals(mWay)) {
            mWay = "天";
        } else if ("2".equals(mWay)) {
            mWay = "一";
        } else if ("3".equals(mWay)) {
            mWay = "二";
        } else if ("4".equals(mWay)) {
            mWay = "三";
        } else if ("5".equals(mWay)) {
            mWay = "四";
        } else if ("6".equals(mWay)) {
            mWay = "五";
        } else if ("7".equals(mWay)) {
            mWay = "六";
        }
        return mYear + "年" + mMonth + "月" + mDay + "日" + " 星期" + mWay;
    }

    /**
     * 描述:获取类似今天、昨天的简单名称
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/8/11 16:22
     */
    public static String getCustomStr(String date) {
        if (getMillis(date) == getMillis(getBeforeYesData())) {
            return "前天";
        } else if (getMillis(date) == getMillis(getYesData())) {
            return "昨天";
        } else if (getMillis(date) == getMillis(getTodayData())) {
            return "今天";
        } else if (getMillis(date) == getMillis(getTomoData())) {
            return "明天";
        } else if (getMillis(date) == getMillis(getTheDayData())) {
            return "后天";
        } else {
            return "星期" + getWeek((getMillis(date)));
        }
    }

    public static Date getDateByString(String time) {
        Date date = null;
        if (time == null)
            return date;
        String date_format = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat format = new SimpleDateFormat(date_format);
        try {
            date = format.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 描述:回对比参数中的时间，间隔了多少时间
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/8/11 16:22
     */
    public static String getShortTime(String time) {
        String shortstring = null;
        long now = Calendar.getInstance().getTimeInMillis();
        Date date = getDateByString(time);
        if (date == null)
            return shortstring;
        long deltime = (now - date.getTime()) / 1000;
        if (deltime > 365 * 24 * 60 * 60) {
            shortstring = (int) (deltime / (365 * 24 * 60 * 60)) + "年前";
        } else if (deltime > 24 * 60 * 60) {
            shortstring = (int) (deltime / (24 * 60 * 60)) + "天前";
        } else if (deltime > 60 * 60) {
            shortstring = (int) (deltime / (60 * 60)) + "小时前";
        } else if (deltime > 60) {
            shortstring = (int) (deltime / (60)) + "分前";
        } else if (deltime > 1) {
            shortstring = deltime + "秒前";
        } else {
            shortstring = "1秒前";
        }
        return shortstring;
    }


    /**
     * 描述:根据出生年份获取生肖
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/8/11 15:53
     */
    public static String date2Zodica(int year) {
        return zodiacArray[year % 12];
    }

    /**
     * 描述:根据日期获取星座
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/8/11 15:53
     */
    public static String date2Constellation(int month, int day) {

        month = month - 1;
        if (day < constellationDay[month]) {
            month = month - 1;
        }
        if (month >= 0) {
            return constellationArray[month];
        }
        // 默认魔羯
        return constellationArray[11];
    }

    /**
     * 描述:根据出生年份得到年龄
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/8/11 15:53
     */
    public static int date2Age(int year) {

        Calendar c = Calendar.getInstance();
        int y = c.get(Calendar.YEAR);
        int age = y - year;

        if (age < 0) {
            age = 0;
        }
        return age;

    }

    /**
     * 默认日期格式
     */
    public static String DEFAULT_FORMAT = "yyyy-MM-dd";

    /**
     * 测试主方法
     *
     * @param args
     */
    public static void main(String[] args) {
        for (int i = 1951; i < 1960; i++) {
            System.out.println(formatDate(getYearFirst(i)));
            System.out.println(formatDate(getYearLast(i)));
        }

        System.out.println(formatDate(getCurrYearFirst()));
        System.out.println(formatDate(getCurrYearLast()));

    }

    /**
     * 格式化日期
     *
     * @param date 日期对象
     * @return String 日期字符串
     */
    public static String formatDate(Date date) {
        SimpleDateFormat f = new SimpleDateFormat(DEFAULT_FORMAT);
        String sDate = f.format(date);
        return sDate;
    }

    /**
     * 获取当年的第一天
     *
     * @return
     */
    public static Date getCurrYearFirst() {
        Calendar currCal = Calendar.getInstance();
        int currentYear = currCal.get(Calendar.YEAR);
        return getYearFirst(currentYear);
    }

    /**
     * 获取当年的最后一天
     *
     * @return
     */
    public static Date getCurrYearLast() {
        Calendar currCal = Calendar.getInstance();
        int currentYear = currCal.get(Calendar.YEAR);
        return getYearLast(currentYear);
    }

    /**
     * 获取某年第一天日期
     *
     * @param year 年份
     * @return Date
     */
    public static Date getYearFirst(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        Date currYearFirst = calendar.getTime();
        return currYearFirst;
    }

    /**
     * 获取某年最后一天日期
     *
     * @param year 年份
     * @return Date
     */
    public static Date getYearLast(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        calendar.roll(Calendar.DAY_OF_YEAR, -1);
        Date currYearLast = calendar.getTime();
        return currYearLast;
    }

    /**
     * 描述:判断当前日期是否是今天
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/9/2 16:09
     */
    public static boolean isTodayDate(String date) {
        boolean flag = false;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        String todayDate = df.format(new Date());// new Date()为获取当前系统时间
        if (todayDate.equals(date)) {
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }


    /**
     * 描述:根据日期返回周几
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/9/2 16:12
     */
    public static String dayForWeek(String pTime, String formattype) {
        String week = "";
        SimpleDateFormat format = new SimpleDateFormat(formattype);
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(format.parse(pTime));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        int dayForWeek = 0;
        if (c.get(Calendar.DAY_OF_WEEK) == 1) {
            dayForWeek = 7;
        } else {
            dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
        }

        switch (dayForWeek) {
            case 1:
                week = "周一";
                break;
            case 2:
                week = "周二";
                break;
            case 3:
                week = "周三";
                break;
            case 4:
                week = "周四";
                break;
            case 5:
                week = "周五";
                break;
            case 6:
                week = "周六";
                break;
            case 7:
                week = "周日";
                break;
            default:
                break;
        }

        return week;
    }

    /**
     * 描述:得到公历
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/9/2 16:15
     */
    public static String getGregorianCalendar(String date) {
        String time = "";
        String[] strings = date.split("-");
        time = strings[0] + "年" + String.valueOf(Integer.valueOf(strings[1])) + "月" + String.valueOf(Integer.valueOf(strings[2])) + "日";
        return time;
    }

    /**
     * 描述:日期比较，第一个日期是否比第二个日期大
     * 1 date1 > date2
     * -1 date1 < date2
     * 0 date1 == date2
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/9/2 16:17
     */
    public static int compareDate(String DATE1, String DATE2, String format) {
        SimpleDateFormat df = new SimpleDateFormat(format);
        try {
            Date dt1 = df.parse(DATE1);
            Date dt2 = df.parse(DATE2);
            if (dt1.getTime() > dt2.getTime()) {
                return 1;
            } else if (dt1.getTime() < dt2.getTime()) {
                return -1;
            } else {
                return 0;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }


    /**
     * 描述:当前日期是否在周一到周五
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/9/2 16:45
     */
    public static boolean isWorkingDays(String date) {
        boolean flag = false;
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");

        Date bdate = null;
        try {
            bdate = format1.parse(date);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(bdate);
        if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            flag = false;
        } else {
            flag = true;
        }
        return flag;
    }

    /**
     * 描述:某年某周的第一天日期
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/12/22 16:24
     */
    public static String getWeekFirstDate(int year, int week) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);// 设置年份
        cal.set(Calendar.WEEK_OF_YEAR, week);// 设置周
        cal.setFirstDayOfWeek(Calendar.MONDAY);// 设置该周第一天为星期一
        cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek()); // 设置最后一天是星期日
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_NONE_YYYY_MM_DD);
        return sdf.format(cal.getTime());
    }

    /**
     * 描述:获取某年某周的最后一天
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/12/22 16:23
     */
    public static String getWeekLastDate(int year, int week) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);// 设置年份
        cal.set(Calendar.WEEK_OF_YEAR, week);// 设置周
        cal.setFirstDayOfWeek(Calendar.MONDAY);// 设置该周第一天为星期一
        cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek() + 6); // 设置最后一天是星期日
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_NONE_YYYY_MM_DD);
        return sdf.format(cal.getTime());
    }

    private static Calendar getCalendarFormYear(int year) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        cal.set(Calendar.YEAR, year);
        return cal;
    }

    public static String calToDay(String calSource) {
        String target = "";
        try {
            Date date = new SimpleDateFormat("yyyy-M-d").parse(calSource);
            target = new SimpleDateFormat("yyyy-MM-dd").format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return target;
    }

    /**
     * 描述:获取今天是今年的第几周
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/11/3 11:43
     */
    public static int getWeekByYear() {
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);// 设置该周第一天为星期一
        calendar.set(Calendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek() + 6); // 设置最后一天是星期日
        calendar.setTime(new Date());
        return calendar.get(Calendar.WEEK_OF_YEAR);
    }

    /**
     * @方法名:
     * @参数：
     * @返回值：
     * @描述: 秒转时分秒
     * @作者： junwen
     * @创建日期 2016/11/8 15:41
     */
    public static String secToTime(int time) {
        String timeStr = null;
        int hour = 0;
        int minute = 0;
        int second = 0;
        if (time <= 0)
            return "00:00";
        else {
            minute = time / 60;
            if (minute < 60) {
                second = time % 60;
                timeStr = unitFormat(minute) + ":" + unitFormat(second);
            } else {
                hour = minute / 60;
                if (hour > 99)
                    return "99:59:59";
                minute = minute % 60;
                second = time - hour * 3600 - minute * 60;
                timeStr = unitFormat(hour) + ":" + unitFormat(minute) + ":" + unitFormat(second);
            }
        }
        return timeStr;
    }

    public static String unitFormat(int i) {
        String retStr = null;
        if (i >= 0 && i < 10)
            retStr = "0" + Integer.toString(i);
        else
            retStr = "" + i;
        return retStr;
    }

    public static int getWeekNumByYear(final int year) {
        if (year < 1900 || year > 9999) {
            throw new NullPointerException("年度必须大于等于1900年小于等于9999年");
        }
        int result = 52;//每年至少有52个周 ，最多有53个周。
        String date = getYearWeekFirstDay(year, 53);
        if (date.substring(0, 4).equals(year + "")) { //判断年度是否相符，如果相符说明有53个周。
            result = 53;
        }
        return result;
    }

    /**
     * 计算某年某周的开始日期
     *
     * @param yearNum 格式 yyyy  ，必须大于1900年度 小于9999年
     * @param weekNum 1到52或者53
     * @return 日期，格式为yyyy-MM-dd
     */
    public static String getYearWeekFirstDay(int yearNum, int weekNum) {
        if (yearNum < 1900 || yearNum > 9999) {
            throw new NullPointerException("年度必须大于等于1900年小于等于9999年");
        }
        Calendar cal = Calendar.getInstance();
        cal.setFirstDayOfWeek(Calendar.MONDAY); //设置每周的第一天为星期一
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);//每周从周一开始
//       上面两句代码配合，才能实现，每年度的第一个周，是包含第一个星期一的那个周。
        cal.setMinimalDaysInFirstWeek(7);  //设置每周最少为7天
        cal.set(Calendar.YEAR, yearNum);
        cal.set(Calendar.WEEK_OF_YEAR, weekNum);

        //分别取得当前日期的年、月、日
        return dateToString(cal.getTime(), FORMAT_NONE_YYYY_MM_DD);
    }

    /**
     * 描述:根据开始时间和结束时间，返回从开始到结束的所有年份
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/11/23 17:33
     */
    public static List<String> getStartYearToEntYear(String startYear, String entYear) {
        List<String> result = new ArrayList<>();
        result.add(startYear);
        //先判断start和end是否是相同时间
        if (JDateUtils.compareDate(startYear, entYear, "yyyy") == 0) {
            return result;
        }
        while (JDateUtils.compareDate(JDateUtils.dateToString(JDateUtils.addOrDeleteDate(JDateUtils.stringToDate(startYear, "yyyy"), 1, JDateUtils.DATA_TYPE_YEAR), "yyyy"), entYear, "yyyy") == -1) {
            //判断
            String dateToString = JDateUtils.dateToString(JDateUtils.addOrDeleteDate(JDateUtils.stringToDate(startYear, "yyyy"), 1, JDateUtils.DATA_TYPE_YEAR), "yyyy");
            result.add(dateToString);
            startYear = dateToString;
        }
        result.add(JDateUtils.dateToString(JDateUtils.addOrDeleteDate(JDateUtils.stringToDate(startYear, "yyyy"), 1, JDateUtils.DATA_TYPE_YEAR), "yyyy"));
        return result;
    }

    /**
     * 描述:String日期格式化成另一种格式的
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/12/2 9:53
     */
    public static String stringFormat(String string, String defaultFormat, String targerFormat) {
        String result = "";
        SimpleDateFormat formatter = new SimpleDateFormat(defaultFormat);
        SimpleDateFormat tartMatter = new SimpleDateFormat(targerFormat);
        try {
            Date date = formatter.parse(string);
            result = tartMatter.format(date);
            return result;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }
}

