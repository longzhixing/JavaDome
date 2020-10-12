import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.text.DateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class JavaTime {
    public static void main(String[] args){
        //LacalData用于表示今天的日期，和Java.Util.Date不同，它只有日期，不包含时间
        LocalDate today = LocalDate.now();
        System.out.println("今天的日期："+today);
        //今天的日期：2020-02-12

        //获取年、月、日
        int year = today.getYear();//年
        int month=today.getMonthValue();//月
        int day = today.getDayOfMonth();//日
        System.out.println("年："+year); //年：2020
        System.out.println("月："+month);//月：2
        System.out.println("日："+day);//日：12

        /**
         * 处理特定的日期
         * LocalDate.of()创建任意日期，参数传入年、月、日
         * 年度起始于1900，月份从0开始
         */
        LocalDate date = LocalDate.of(2020,2,12);
        System.out.println("自定义日期为："+date);//自定义日期为：2020-02-12

        //判断两个日期是否相等
        LocalDate date1 = LocalDate.now();
        LocalDate date2 = LocalDate.of(2020,2,12);
        if(date1.equals(date2)){
            System.out.println("时间相等");//时间相等
        }else {
            System.out.println("时间不等");
        }

        //检查像生日这种周期性事件
        LocalDate date3 = LocalDate.now();
        LocalDate date4 = LocalDate.of(2020,7,9);
        MonthDay birthday = MonthDay.of(date4.getMonth(),date4.getDayOfMonth());
        MonthDay currentMonthDay=MonthDay.from(date3);
        if(currentMonthDay.equals(birthday)){
            System.out.println("是你的生日");
        }else {
            System.out.println("你的生日还没有到");//你的生日还没有到
        }

        //获取当前时间，不包含日期
        LocalTime time=LocalTime.now();
        System.out.println("当前不包含日期的时间为："+time);
        //当前不包含日期的时间为：17:32:16.285

        LocalTime time1 = LocalTime.now();
        LocalTime newTime = time1.plusHours(3);//计算3个小时后的时间
        System.out.println("三个小时后的时间为："+newTime);
        //三个小时后的时间为：20:38:19.189

        //计算一周后的时间
        LocalDate today1 = LocalDate.now();
        System.out.println("今天的日期为："+today1);
        //今天的日期为：2020-02-12
        //计算一周后的日期
        LocalDate nextWeek=today1.plus(1, ChronoUnit.WEEKS);
        System.out.println("一周后的日期为："+nextWeek);
        //一周后的日期为：2020-02-19

        //计算一年前或一年后的日期
        LocalDate today2 = LocalDate.now();
        //minus()计算一年前的日期
        LocalDate previousYear = today2.minus(1,ChronoUnit.YEARS);
        //plus()计算一年后的日期
        LocalDate nextYear = today2.plus(1,ChronoUnit.YEARS);
        System.out.println("一年前的日期："+previousYear);//一年前的日期：2019-02-12
        System.out.println("一年后的日期："+nextYear);//一年后的日期：2021-02-12

        Clock clock = Clock.systemUTC();
        System.out.println("Clock:"+clock.millis());
        Clock defaultClock=Clock.systemDefaultZone();//Clock:1581501673607
        System.out.println("Clock："+defaultClock.millis());//Clock：1581501673607

        //比较日期
        LocalDate today3=LocalDate.now();
        LocalDate tomorrow=LocalDate.of(2020,2,13);
        if(tomorrow.isAfter(today3)){
            System.out.println("之后的日期："+tomorrow);//之后的日期：2020-02-13
        }
        //计算前一天的日期
        LocalDate yesterday=today3.minus(1,ChronoUnit.DAYS);
        if(yesterday.isBefore(today3)){
            System.out.println("之前的日期："+yesterday);//之前的日期：2020-02-11
        }

        //如何把本时区的时间转换成另一个时区的时间
        ZoneId america = ZoneId.of("America/New_York");
        LocalDateTime localDateTime = LocalDateTime.now();
        ZonedDateTime dataAndTimeInNewYork=ZonedDateTime.of(localDateTime,america);
        System.out.println("特定时区中的当前日期和时间："+dataAndTimeInNewYork);
        //特定时区中的当前日期和时间：2020-02-12T18:25:37.243-05:00[America/New_York]

        YearMonth currentYearMonth=YearMonth.now();
        System.out.printf("年、月、日 %s: %d%n", currentYearMonth,currentYearMonth.lengthOfMonth());
        //年、月、日 2020-02: 29
        YearMonth creeditCardExpiry = YearMonth.of(2020,Month.FEBRUARY);
        System.out.printf("你的信用卡到期日 %s %n",creeditCardExpiry);
        //你的信用卡到期日 2020-02

        LocalDate today4=LocalDate.now();
        //检查不否是闰年
        if(today4.isLeapYear()){
            System.out.println("2020年是闰年");//2020年是闰年
        }else {
            System.out.println("2020年不是闰年");
        }

        LocalDate today5=LocalDate.now();
        LocalDate Release = LocalDate.of(2020,12,14);
        //计算两个日期之间的天数,月数
        Period todaySinceRelease = Period.between(today5,Release);
        System.out.printf("从现到到2020年12月14日还有%s个月",todaySinceRelease.getMonths());
        //从现到到2020年12月14日还有10月
        System.out.printf("从现在到2020年12月14日还有%s天",todaySinceRelease.getDays());

        //获取当前的时间戳
        Instant instant = Instant.now();
        System.out.println("这一瞬间的价值是什么："+instant.toEpochMilli());
        //这一瞬间的价值是什么：1581582840761

        String daytStr="20200213";
        //格式化日期
        LocalDate formatted=LocalDate.parse(daytStr, DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println("格式化后的日期为："+formatted);//格式化后的日期为：2020-02-13

        LocalDateTime localDateTime1 = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        //日期转换为字符串
        String str=localDateTime1.format(formatter);
        System.out.println("日期转换为字符串："+str);//日期转换为字符串：2020/02/13 16:51:36

        DateTimeFormatter formatter1=DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        //字符串转日期
        LocalDate date5 = LocalDate.parse(str,formatter1);
        System.out.println("字符串转日期类型："+date5);//字符串转日期类型：2020-02-13
    }
}
