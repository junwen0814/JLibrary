package com.junwen.jlibrary;

/**
 * 描述：
 * 作者：卜俊文
 * 创建：2016/9/2 09:47
 * 邮箱：344176791@qq.com
 */
public class Test {
    public static void main(String args[]) {
//        System.out.println("当前日期:" + JDateUtils.getCurrDate()); //"当前日期，默认格式：yyyy-MM-dd"
//        System.out.println("自定义格式:" + JDateUtils.getCurrDate(JDateUtils.DataFormatType.FORMAT_NONE_YYYY_MM_DD_HH_MM_SS)); //"自定义格式，默认格式：yyyy-MM-dd HH:mm:ss"
//        System.out.println("判断当天是上午下午还是晚上:" + JDateUtils.convertNowHour2CN(new Date())); //判断当天是上午下午还是晚上
//        System.out.println("返回2个小时之后的日期" + JDateUtils.getNextHour(JDateUtils.DataFormatType.FORMAT_NONE_YYYY_MM_DD_HH_MM_SS, 2));//返回n个小时之后的日期
//        System.out.println("5个月之后的日期:" + JDateUtils.dateToString(JDateUtils.addData(new Date(), 5, DATA_TYPE_MONTH), JDateUtils.DataFormatType.FORMAT_NONE_YYYY_MM_DD_HH_MM_SS));//返回n个月之后的日期
//        System.out.println("9月2日增加2个月之后的日期：" + JDateUtils.dateToString(JDateUtils.addData(JDateUtils.stringToDate("2016-09-02 14:24:00", JDateUtils.DataFormatType.FORMAT_NONE_YYYY_MM_DD_HH_MM_SS), 2, DATA_TYPE_MONTH), JDateUtils.DataFormatType.FORMAT_NONE_YYYY_MM_DD_HH_MM_SS));
//        System.out.println("今天增加1天：" + JDateUtils.dateToString(JDateUtils.addData(new Date(), 1, DATA_TYPE_DAY), JDateUtils.DataFormatType.FORMAT_NONE_YYYY_MM_DD_HH_MM_SS));
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
//        System.out.println("根据日期返回周几：" + JDateUtils.dayForWeek(JDateUtils.getTomoData(), JDateUtils.DataFormatType.FORMAT_NONE_YYYY_MM_DD));
//        System.out.println("比较两个日期大于？小于？等于？：" + JDateUtils.compareDate(JDateUtils.getCurrDate(), JDateUtils.getTomoData())); //返回负1 代表第一个日期比第二个日期小
//        System.out.println("判断日期是否在星期五？:" + JDateUtils.isWorkingDays(JDateUtils.getCurrDate()));
//        String startDayOfWeekNo = JDateUtils.getStartDayOfWeekNo(2016, 25);
//        System.out.println("获取2016年25周的日期开始时间？:" + startDayOfWeekNo);
//        String overDayOfWeekNo = JDateUtils.getEndDayOfWeekNo(2016, 25);
//        System.out.println("获取2016年25周的日期结束时间？:" + overDayOfWeekNo);
//        System.out.println("返回今天是第几周？:" + getWeekByYear());

        String currTime = "07:44";
        String s = JDateUtils.dateToString(JDateUtils.addData(JDateUtils.stringToDate("08:00", JDateUtils.DataFormatType.FORMAT_HH_MM), -15, JDateUtils.DATA_TYPE_MINUTE), JDateUtils.DataFormatType.FORMAT_HH_MM);
        String end = JDateUtils.dateToString(JDateUtils.addData(JDateUtils.stringToDate("08:00", JDateUtils.DataFormatType.FORMAT_HH_MM), 15, JDateUtils.DATA_TYPE_MINUTE), JDateUtils.DataFormatType.FORMAT_HH_MM);
        System.out.println("15分钟之前：" + s);
        System.out.println("15分钟之前：" + end);
        System.out.println("当前时间是否大于8点：" + JDateUtils.compareDate(currTime, s, JDateUtils.DataFormatType.FORMAT_HH_MM));
        int i = JDateUtils.compareDate(currTime, s, JDateUtils.DataFormatType.FORMAT_HH_MM);
        int compareDate = JDateUtils.compareDate(currTime, end, JDateUtils.DataFormatType.FORMAT_HH_MM);
        if(i == 1 || i == 0){
            if(compareDate == -1 || compareDate == 0){
                System.out.println("通过");
            }
        }
//        Date end = JDateUtils.addData(JDateUtils.stringToDate(beginTime, JDateUtils.DataFormatType.FORMAT_MM_SS), 15, JDateUtils.DATA_TYPE_MINUTE);
    }
}
