package ir.rahnama.form1;

/**
 * Created by jefferson on 9/17/2017.
 */

public class convertinttotext {


    final private  static String[] units = {"صفر","یک","دو","سه","چهار",
            "پنج","شش","هفت","هشت","نه","ده",
            "یازده","دوازده","سیزده","چهارده","پانزده",
            "شانزده","هفده","هیچده","نوزده"};
    final private static String[] tens = {"","","بیست","سی","چهل","پنجاه",
            "شصت","هفتاد","هشتاد","نود"};

    final private static String[] tens1 = {"","یکصد","دویست","سیصد","چهار صد","پانصد",
            "ششصد","هفتصد","هشتصد","نهصد"};

    public static String convert(Integer i) {
        //
        if( i < 20)  return units[i];
        if( i < 100) return tens[i/10] + ((i % 10 > 0)? " و " + convert(i % 10):"");
        if( i < 1000) return tens1[i/100] +  ((i % 100 > 0)?" و " + convert(i % 100):"");
        if( i < 1000000) return convert(i / 1000) + " هزار " + ((i % 1000 > 0)? " و " + convert(i % 1000):"") ;
        if( i < 1000000000) return convert(i / 1000000) + " میلیون " + ((i % 1000000 > 0)? " و " + convert(i % 1000000):"") ;
        return convert(i / 1000000000) + " میلیارد " + ((i % 1000000000 > 0)? " و " + convert(i % 1000000000):"") ;
    }

    public static String price_convert(int i)
    {
       return  convert(i*1000000)+" تومان ";
    }
    public static String price_default(int i)
    {
        return  convert(i)+" تومان ";
    }

    public static String price_convert_1000(int i)
    {
        return  convert(i*1000)+" تومان ";
    }

}
