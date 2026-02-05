package ir.rahnama;

/**
 * Created by Reza on 9/25/2017.
 */
public class ccconvert {

    public String GetFigures(String x)
    {
        x = Integer.toString(Integer.parseInt(x));
        String text7;
        String text10;

        String[] textArray0_10 = new String[11];
        textArray0_10[0] = "صفر";
        textArray0_10[1] = "یک";
        textArray0_10[2] = "دو";
        textArray0_10[3] = "سه";
        textArray0_10[4] = "چهار";
        textArray0_10[5] = "پنج";
        textArray0_10[6] = "شش";
        textArray0_10[7] = "هفت";
        textArray0_10[8] = "هشت";
        textArray0_10[9] = "نه";

        String[] textArray10_19 = new String[11];
        textArray10_19[0] = "ده";
        textArray10_19[1] = "یازده";
        textArray10_19[2] = "دوازده";
        textArray10_19[3] = "سیزده";
        textArray10_19[4] = "چهارده";
        textArray10_19[5] = "پانزده";
        textArray10_19[6] = "شانزده";
        textArray10_19[7] = "هفده";
        textArray10_19[8] = "هجده";
        textArray10_19[9] = "نوزده";

        String[] textArray20_90 = new String[11];
        textArray20_90[2] = "بیست";
        textArray20_90[3] = "سی";
        textArray20_90[4] = "چهل";
        textArray20_90[5] = "پنجاه";
        textArray20_90[6] = "شصت";
        textArray20_90[7] = "هفتاد";
        textArray20_90[8] = "هشتاد";
        textArray20_90[9] = "نود";

        String[] textArray100_900 = new String[11];
        textArray100_900[1] = "یکصد";
        textArray100_900[2] = "دویست";
        textArray100_900[3] = "سیصد";
        textArray100_900[4] = "چهارصد";
        textArray100_900[5] = "پانصد";
        textArray100_900[6] = "ششصد";
        textArray100_900[7] = "هفتصد";
        textArray100_900[8] = "هشتصد";
        textArray100_900[9] = "نهصد";

        String strHezar = "هزار";
        String strHezar_ = "هزار" + " ";
        String strMeliun = "میلیون";
        String strMiliard = "میلیارد";
        String strMiliard_ = "میلیارد" + " ";
        String strTriliun = "تریلیون";
        String strTriliun_ = "تریلیون" + " ";

        String text4 = x;
        text7 = "";
        switch (text4.length())
        {
            case 1:
                if (x != "")
                {
                    text7 = textArray0_10[Integer.parseInt((String)x)];
                }
                break;

            case 2:
                if ((Integer.parseInt(text4.substring(text4.length() - 1, 1)) > 0) & (Double.parseDouble(text4.substring(0, 1)) > 1))
                {
                    text10 = Integer.toString(Integer.parseInt(text4.substring(  text4.length() - 1, 1)));
                    text7 = " و " + GetFigures(text10);
                }
                if (Double.parseDouble(text4.substring(0, 1)) > 1)
                {
                    text7 = textArray20_90[Integer.parseInt(text4.substring(0, 1))] + text7;
                }
                if (Double.parseDouble(text4.substring(0, 1)) == 1)
                {
                    text7 = textArray10_19[Integer.parseInt(text4.substring(text4.length() - 1, 1))];
                }
                break;

            case 3:
                if (Double.parseDouble(text4.substring(text4.length() - 2, 2)) > 0)
                {
                    text10 = Integer.toString(Integer.parseInt(text4.substring(  text4.length() - 2, 2)));
                    text7 = " و " + GetFigures(text10);
                }
                text7 = textArray100_900[(int)Math.round(Double.parseDouble(text4.substring(0  , 1)))] + text7;
                break;

            case 4:
                if (Double.parseDouble(text4.substring(text4.length() - 3, 3)) > 0)
                {
                    text10 = Integer.toString(Integer.parseInt(text4.substring(  text4.length() - 3, 3)));
                    text7 = " و " + GetFigures(text10);
                }
                text10 = Integer.toString(Integer.parseInt(text4.substring(  0, 1)));
                text7 = GetFigures(text10) + strHezar + text7;
                break;

            case 5:
                if (Double.parseDouble(text4.substring(text4.length() - 3, 3)) > 0)
                {
                    text10 = Integer.toString(Integer.parseInt(text4.substring(  text4.length() - 3, 3)));
                    text7 = " و " + GetFigures(text10);
                }
                text10 = Integer.toString(Integer.parseInt(text4.substring(  0, 2)));
                text7 = GetFigures(text10) + strHezar + text7;
                break;

            case 6:
                if (Integer.parseInt(text4.substring(text4.length() - 5, 5)) != 0)
                {
                    if (Double.parseDouble(text4.substring(text4.length() - 3, 3)) > 0)
                    {
                        text10 = Integer.toString(Integer.parseInt(text4.substring(text4.length() - 3, 3)));
                        text7 = " و " + GetFigures(text10);
                    }
                    text10 = Integer.toString(Integer.parseInt(text4.substring(  0, 3)));
                    text7 = GetFigures(text10) + strHezar_ + text7;
                    break;
                }
                text7 = textArray100_900[(int)Math.round(Integer.parseInt(text4.substring(0  , 1)))] + strHezar_;
                break;


            case 7:
                if (Integer.parseInt(text4.substring(text4.length() - 6, 6)) != 0)
                {
                    text10 = Integer.toString(Integer.parseInt(text4.substring(text4.length() - 6, 6)));
                    text7 = " و " + GetFigures(text10);
                }
                text10 = Integer.toString(Integer.parseInt(text4.substring(  0, 1)));
                text7 = GetFigures(text10) + strMeliun + text7;
                break;

            case 8:
                if (Integer.parseInt(text4.substring(text4.length() - 6, 6)) > 0)
                {
                    text10 = Integer.toString(Integer.parseInt(text4.substring(text4.length() - 6, 6)));
                    text7 = " و " + GetFigures(text10);
                }
                text10 = Integer.toString(Integer.parseInt(text4.substring(  0, 2)));
                text7 = GetFigures(text10) + strMeliun + text7;
                break;

            case 9:
                if (Integer.parseInt(text4.substring(text4.length() - 6, 6)) > 0)
                {
                    text10 = Integer.toString(Integer.parseInt(text4.substring(text4.length() - 6, 6)));
                    text7 = " و " + GetFigures(text10);
                }
                text10 = Integer.toString(Integer.parseInt(text4.substring(  0, 3)));
                text7 = GetFigures(text10) + strMeliun + text7;
                break;

            case 10:
                if (Integer.parseInt(text4.substring(text4.length() - 9, 9)) > 0)
                {
                    text10 = Integer.toString(Integer.parseInt(text4.substring(text4.length() - 9, 9)));
                    text7 = " و " + GetFigures(text10);
                }
                text10 = Integer.toString(Integer.parseInt(text4.substring(  0, 1)));
                text7 = GetFigures(text10) + strMiliard + text7;
                break;

            case 11:
                if (Integer.parseInt(text4.substring(text4.length() - 9, 9)) > 0)
                {
                    text10 = Integer.toString(Integer.parseInt(text4.substring(text4.length() - 9, 9)));
                    text7 = " و " + GetFigures(text10);
                }
                text10 = Integer.toString(Integer.parseInt(text4.substring(  0, 2)));
                text7 = GetFigures(text10) + strMiliard + text7;
                break;
            case 12:
                if (Integer.parseInt(text4.substring(text4.length() - 9, 9)) > 0)
                {
                    text10 = text4.substring(text4.length() - 9, 9);
                    text7 = " و " + GetFigures(text10);
                }
                text10 = Integer.toString(Integer.parseInt(text4.substring(  0, 3)));
                text7 = GetFigures(text10) + strMiliard_ + text7;
                break;

            case 13:
                if (Integer.parseInt(text4.substring(text4.length() - 12, 12)) > 0)
                {
                    text10 = text4.substring(text4.length() - 12, 12);
                    text7 = " و " + GetFigures(text10);
                }
                text10 = Integer.toString(Integer.parseInt(text4.substring(  0, 1)));
                text7 = GetFigures(text10) + strTriliun + text7;

                break;

            case 14:
                if (Integer.parseInt(text4.substring(text4.length() - 12, 12)) > 0)
                {
                    text10 = text4.substring(text4.length() - 12, 12);
                    text7 = " و " + GetFigures(text10);
                }
                text10 = Integer.toString(Integer.parseInt(text4.substring(  0, 2)));
                text7 = GetFigures(text10) + strTriliun + text7;
                break;

            case 15:
                if (Integer.parseInt(text4.substring(text4.length() - 12, 12)) > 0)
                {
                    text10 = text4.substring(text4.length() - 12, 12);
                    text7 = " و " + GetFigures(text10);
                }
                text10 = Integer.toString(Integer.parseInt(text4.substring(  0, 3)));
                text7 = GetFigures(text10) + strTriliun_ + text7;
                break;
        }
        String text3 = " " + text7 + " ";
        //return text3.Replace(" ", "");
        return text3;
    }


//    private void textBox1_TextChanged(object sender, EventArgs e)
//    {
//        if (textBox1.Text == "")
//        {
//            label1.Text = "";
//        }
//        else
//        {
//            label1.Text = GetFigures(textBox1.Text) + " ریال ";
//        }
//    }
}
