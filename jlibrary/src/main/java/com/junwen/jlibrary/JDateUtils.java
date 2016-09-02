package com.junwen.jlibrary;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

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

        //年月日，带中文
        public static final String FORMAT_Month_YYYY_MM_DD = "yyyy年MM月dd";

        //年月日，小时分钟秒，无中文
        public static final String FORMAT_NONE_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

        //年月日，小时分钟秒，带中文
        public static final String FORMAT_MONTH_YYYY_MM_DD_HH_MM_SS = "yyyy年MM月dd HH:mm:ss";

        //月日 小时分钟秒，无中文
        public static final String FORMAT_NONE_MM_DD_HH_MM_SS = "MM-dd HH:mm:ss";

        //月日 小时分钟秒，有中文
        public static final String FORMAT_MONTH_MM_DD_HH_MM_SS = "MM月dd HH:mm:ss";

        //小时分钟秒
        public static final String FORMAT_HH_MM_SS = "HH:mm:ss";
    }

    public final static String[] zodiacArray = {"猴", "鸡", "狗", "猪", "鼠", "牛", "虎",
            "兔", "龙", "蛇", "马", "羊"};

    public final static String[] constellationArray = {"水瓶座", "双鱼座", "牡羊座", "金牛座",
            "双子座", "巨蟹座", "狮子座", "处女座", "天秤座", "天蝎座", "射手座", "魔羯座"};

    public final static int[] constellationDay = {20, 19, 21, 21, 21, 22, 23, 23, 23,
            24, 23, 22};


    /**
     * 描述:获取当前日期
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/8/11 16:19
     */
    public static String getCurrDate() {
        return new SimpleDateFormat(DataFormatType.FORMAT_NONE_YYYY_MM_DD).format(new Date());
    }

    /**
     * 描述:获取当前时间
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/8/11 16:19
     */
    public static String getCurrTime() {
        return new SimpleDateFormat(DataFormatType.FORMAT_HH_MM_SS).format(new Date());
    }

    /**
     * 描述:获取当前时间,根据指定的格式
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/8/11 16:19
     */
    public static String getDataFormat(String format) {
        SimpleDateFormat df = new SimpleDateFormat(format);
        return df.format(new Date());
    }

    /**
     * 描述:String转Date
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/9/2 10:25
     */
    public static Date stringToDate(String strTime, String formatType) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(formatType);
            Date date = null;
            date = formatter.parse(strTime);
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
    public static String dateToString(Date data, String formatType) {
        return new SimpleDateFormat(formatType).format(data);
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
    public static Date longToDate(long currentTime, String formatType)
            throws ParseException {
        Date dateOld = new Date(currentTime); // 根据long类型的毫秒数生命一个date类型的时间
        String sDateTime = dateToString(dateOld, formatType); // 把date类型的时间转换为string
        Date date = stringToDate(sDateTime, formatType); // 把String类型转换为Date类型
        return date;
    }

    /**
     * 描述:Long转成String
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/9/2 10:24
     */
    public static String longToString(long currentTime, String formatType)
            throws ParseException {
        Date date = longToDate(currentTime, formatType); // long类型转成Date类型
        String strTime = dateToString(date, formatType); // date类型转成String
        return strTime;
    }

    /**
     * 描述:String转Long
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/9/2 10:26
     */
    public static long stringToLong(String strTime, String formatType)
            throws ParseException {
        Date date = stringToDate(strTime, formatType); // String类型转成date类型
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
    public static String getNextHour(String format, int h) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date = new Date();
        date.setTime(date.getTime() + h * 60 * 60 * 1000);
        return sdf.format(date);
    }

    /**
     * 描述:在日期上增加数个整月
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/8/11 16:20
     */
    public static Date addMonth(Date date, int n) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, n);
        return cal.getTime();

    }

    /**
     * 描述: 在日期上增加天数
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/8/11 16:20
     */
    public static Date addDay(Date date, int n) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, n);
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
    public static String dayForWeek(String pTime) {
        String week = "";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
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
    public static int compareDate(String DATE1, String DATE2) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
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
//    public static void main(String args[]) {
//        System.out.println("当前日期:" + JDateUtils.getCurrDate()); //"当前日期，默认格式：yyyy-MM-dd"
//        System.out.println("当前时间" + JDateUtils.getCurrTime()); //"当前时间，默认格式：HH:mm:ss"
//        System.out.println("自定义格式:" + JDateUtils.getDataFormat(JDateUtils.DataFormatType.FORMAT_NONE_YYYY_MM_DD_HH_MM_SS)); //"自定义格式，默认格式：yyyy-MM-dd HH:mm:ss"
//        System.out.println("判断当天是上午下午还是晚上:" + JDateUtils.convertNowHour2CN(new Date())); //判断当天是上午下午还是晚上
//        System.out.println("返回2个小时之后的日期" + JDateUtils.getNextHour(JDateUtils.DataFormatType.FORMAT_NONE_YYYY_MM_DD_HH_MM_SS, 2));//返回n个小时之后的日期
//        System.out.println("5个月之后的日期:" + JDateUtils.dateToString(JDateUtils.addMonth(new Date(), 5), JDateUtils.DataFormatType.FORMAT_NONE_YYYY_MM_DD_HH_MM_SS));//返回n个月之后的日期
//        System.out.println("9月2日增加2个月之后的日期：" + JDateUtils.dateToString(JDateUtils.addMonth(JDateUtils.stringToDate("2016-09-02 14:24:00", JDateUtils.DataFormatType.FORMAT_NONE_YYYY_MM_DD_HH_MM_SS), 2), JDateUtils.DataFormatType.FORMAT_NONE_YYYY_MM_DD_HH_MM_SS));
//        System.out.println("9月2日增加1天：" + JDateUtils.dateToString(JDateUtils.addDay(new Date(), 1), JDateUtils.DataFormatType.FORMAT_NONE_YYYY_MM_DD_HH_MM_SS));
//        System.out.println("获取指定毫秒数的对应星期：" + JDateUtils.getWeek(System.currentTimeMillis()));
//        System.out.println("明天的日期：" + JDateUtils.getTomoData());
//        System.out.println("今天的详细日期（带星期）:" + JDateUtils.StringData());//2016年9月2日 星期五
//        System.out.println("判断今天还是昨天还是后天：" + JDateUtils.getCustomStr(JDateUtils.getTomoData()));
//        System.out.println("对比今天多少时间了，秒，天，年" + JDateUtils.getShortTime("2016-09-02 15:30:00")); //输入格式化必须是yyyy-MM-dd HH:mm:ss
//        System.out.println("根据出生年日返回生肖：" + JDateUtils.date2Zodica(1995)); //返回猪
//        System.out.println("根据月份和日期返回星座：" + JDateUtils.date2Constellation(2, 21)); //返回双鱼
//        System.out.println("根据出生年份返回岁数：" + JDateUtils.date2Age(1995)); //返回21岁
//        System.out.println("今年第一天:" + JDateUtils.formatDate(JDateUtils.getCurrYearFirst()));
//        System.out.println("今年最后一天：" + JDateUtils.formatDate(JDateUtils.getCurrYearLast()));
//        System.out.println("判断是否是今天：" + JDateUtils.isTodayDate(JDateUtils.getTomoData()));
//        System.out.println("根据日期返回周几：" + JDateUtils.dayForWeek(JDateUtils.getTomoData()));
//        System.out.println("获取公历：" + JDateUtils.getGregorianCalendar(JDateUtils.getCurrDate()));
//        System.out.println("比较两个日期大于？小于？等于？：" + JDateUtils.compareDate(JDateUtils.getCurrDate(), JDateUtils.getTomoData())); //返回负1 代表第一个日期比第二个日期小
//        System.out.println("判断日期是否在星期五？:"+JDateUtils.isWorkingDays(JDateUtils.getCurrDate()));
//    }
}
