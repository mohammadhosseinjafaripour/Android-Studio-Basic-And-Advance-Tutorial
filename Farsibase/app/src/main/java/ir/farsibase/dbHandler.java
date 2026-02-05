package ir.farsibase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by amir on 9/3/2015.
 */

public class dbHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "rahnama";
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private static final String TABLE_NAME_form_1 = "question_f1";
    public static final String COLUMN_ID = "f1_id";
    public static final String COLUMN_ID_USER = "user_id";

    public static final String COLUMN_LONG = "longitude";
    public static final String COLUMN_LATI = "latitude";
    public static final String COLUMN_STATE= "state";
    public static final String COLUMN_CITY = "city";
    public static final String COLUMN_VILLAGE = "village";
    public static final String COLUMN_PHONECODE = "phone_code";
    public static final String COLUMN_DATE = "date_client";


    public	static	final	String	F1S1V1	=  "f1s1v1";
    public	static	final	String	F1S1V2	=  "f1s1v2";
    public	static	final	String	F1S1V3	=  "f1s1v3";
    public	static	final	String	F1S1V4	=  "f1s1v4";
    public	static	final	String	F1S1V5	=  "f1s1v5";
    public	static	final	String	F1S1V6	=  "f1s1v6";
    public	static	final	String	F1S1V7	=  "f1s1v7";
    public	static	final	String	F1S1V8	=  "f1s1v8";


    public	static	final	String	F1S2V1	=  "f1s2v1";
    public	static	final	String	F1S2V2	=  "f1s2v2";
    public	static	final	String	F1S2V3	=  "f1s2v3";
    public	static	final	String	F1S2V4	=  "f1s2v4";


    public	static	final	String	F1S3V1	=  "f1s3v1";
    public	static	final	String	F1S3V2	=  "f1s3v2";
    public	static	final	String	F1S3V3	=  "f1s3v3";
    public	static	final	String	F1S3V4	=  "f1s3v4";
    public	static	final	String	F1S3V5	=  "f1s3v5";
    public	static	final	String	F1S3V6	=  "f1s3v6";


    public	static	final	String	F1S4V1	=  "f1s4v1";
    public	static	final	String	F1S4V2	=  "f1s4v2";
    public	static	final	String	F1S4V3	=  "f1s4v3";
    public	static	final	String	F1S4V4	=  "f1s4v4";
    public	static	final	String	F1S4V5	=  "f1s4v5";
    public	static	final	String	F1S4V6	=  "f1s4v6";
    public	static	final	String	F1S4V7	=  "f1s4v7";
    public	static	final	String	F1S4V8	=  "f1s4v8";
    public	static	final	String	F1S4V9	=  "f1s4v9";
    public	static	final	String	F1S4V10	=  "f1s4v10";
    public	static	final	String	F1S4V11	=  "f1s4v11";
    public	static	final	String	F1S4V12	=  "f1s4v12";
    public	static	final	String	F1S4V13	=  "f1s4v13";
    public	static	final	String	F1S4V14	=  "f1s4v14";
    public	static	final	String	F1S4V15	=  "f1s4v15";
    public	static	final	String	F1S4V16	=  "f1s4v16";
    public	static	final	String	F1S4V17	=  "f1s4v17";
    public	static	final	String	F1S4V18	=  "f1s4v18";
    public	static	final	String	F1S4V19	=  "f1s4v19";
    public	static	final	String	F1S4V20	=  "f1s4v20";
    public	static	final	String	F1S4V21	=  "f1s4v21";
    public	static	final	String	F1S4V22	=  "f1s4v22";
    public	static	final	String	F1S4V23	=  "f1s4v23";
    public	static	final	String	F1S4V24	=  "f1s4v24";
    public	static	final	String	F1S4V25	=  "f1s4v25";
    public	static	final	String	F1S4V26	=  "f1s4v26";
    public	static	final	String	F1S4V27	=  "f1s4v27";
    public	static	final	String	F1S4V28	=  "f1s4v28";
    public	static	final	String	F1S4V29	=  "f1s4v29";
    public	static	final	String	F1S4V30	=  "f1s4v30";
    public	static	final	String	F1S4V31	=  "f1s4v31";
    public	static	final	String	F1S4V32	=  "f1s4v32";
    public	static	final	String	F1S4V33	=  "f1s4v33";
    public	static	final	String	F1S4V34	=  "f1s4v34";

    public	static	final	String	F1S5V1	=  "f1s5v1";
    public	static	final	String	F1S5V2	=  "f1s5v2";
    public	static	final	String	F1S5V3	=  "f1s5v3";
    public	static	final	String	F1S5V4	=  "f1s5v4";
    public	static	final	String	F1S5V5	=  "f1s5v5";
    public	static	final	String	F1S5V6	=  "f1s5v6";
    public	static	final	String	F1S5V7	=  "f1s5v7";
    public	static	final	String	F1S5V8	=  "f1s5v8";
    public	static	final	String	F1S5V9	=  "f1s5v9";
    public	static	final	String	F1S5V10	=  "f1s5v10";

    public	static	final	String	F1S6V10	=  "f1s6v1";
    public	static	final	String	F1S6V11	=  "f1s6v2";
    public	static	final	String	F1S6V12	=  "f1s6v3";
    public	static	final	String	F1S6V13	=  "f1s6v4";
    public	static	final	String	F1S6V14	=  "f1s6v5";
    public	static	final	String	F1S6V15	=  "f1s6v6";
    public	static	final	String	F1S6V16	=  "f1s6v7";
    public	static	final	String	F1S6V17	=  "f1s6v8";
    public	static	final	String	F1S6V18	=  "f1s6v9";
    public	static	final	String	F1S6V19	=  "f1s6v10";
    public	static	final	String	F1S6V20	=  "f1s6v11";
    public	static	final	String	F1S6V21	=  "f1s6v12";
    public	static	final	String	F1S6V22	=  "f1s6v13";
    public	static	final	String	F1S6V23	=  "f1s6v14";
    public	static	final	String	F1S6V24	=  "f1s6v15";
    public	static	final	String	F1S6V25	=  "f1s6v16";
    public	static	final	String	F1S6V26	=  "f1s6v17";
    public	static	final	String	F1S6V27	=  "f1s6v18";
    public	static	final	String	F1S6V28	=  "f1s6v19";
    public	static	final	String	F1S6V29	=  "f1s6v20";
    public	static	final	String	F1S6V30	=  "f1s6v21";
    public	static	final	String	F1S6V31	=  "f1s6v22";
    public	static	final	String	F1S6V32	=  "f1s6v23";
    public	static	final	String	F1S6V33	=  "f1s6v24";
    public	static	final	String	F1S6V34	=  "f1s6v25";
    public	static	final	String	F1S6V35	=  "f1s6v26";

    public	static	final	String	F1S7V1	=  "f1s7v1";
    public	static	final	String	F1S7V2	=  "f1s7v2";
    public	static	final	String	F1S7V3	=  "f1s7v3";
    public	static	final	String	F1S7V4	=  "f1s7v4";
    public	static	final	String	F1S7V5	=  "f1s7v5";
    public	static	final	String	F1S7V6	=  "f1s7v6";
    public	static	final	String	F1S7V7	=  "f1s7v7";
    public	static	final	String	F1S7V8	=  "f1s7v8";
    public	static	final	String	F1S7V9	=  "f1s7v9";
    public	static	final	String	F1S7V10	=  "f1s7v10";
    public	static	final	String	F1S7V11	=  "f1s7v11";
    public	static	final	String	F1S7V12	=  "f1s7v12";
    public	static	final	String	F1S7V13	=  "f1s7v13";
    public	static	final	String	F1S7V14	=  "f1s7v14";
    public	static	final	String	F1S7V15	=  "f1s7v15";
    public	static	final	String	F1S7V16	=  "f1s7v16";
    public	static	final	String	F1S7V17	=  "f1s7v17";
    public	static	final	String	F1S7V18	=  "f1s7v18";
    public	static	final	String	F1S7V19	=  "f1s7v19";

    public	static	final	String	F1S8V1	=  "f1s8v1";
    public	static	final	String	F1S8V2	=  "f1s8v2";
    public	static	final	String	F1S8V3	=  "f1s8v3";

    public	static	final	String	F1S9V1	=  "f1s9v1";
    public	static	final	String	F1S9V2	=  "f1s9v2";
    public	static	final	String	F1S9V3	=  "f1s9v3";

    public	static	final	String	F1S10V1	=  "f1s10v1";
    public	static	final	String	F1S10V2	=  "f1s10v2";

    public	static	final	String	F1S11V1	=  "f1s11v1";
    public	static	final	String	F1S11V2	=  "f1s11v2";

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private static final String TABLE_NAME_form_2 = "question_f2";
    public static final String COLUMN_IDf2 = "f2_id";
    public static final String COLUMN_ID_F1 = "f1_id";
   // public static final String COLUMN_ID_USER = "user_id";

   // public	static	final	String	F1S1V1	=	"f1s1v1";
   // public	static	final	String	F1S1V2	=	"f1s1v2";
   // public	static	final	String	F1S1V3	=	"f1s1v3";
  //  public	static	final	String	F1S1V4	=	"f1s1v4";
  //  public	static	final	String	F1S1V5	=	"f1s1v5";
  //  public	static	final	String	F1S1V6	=	"f1s1v6";
  //  public	static	final	String	F1S1V7	=	"f1s1v7";

    public	static	final	String	F2S1V1	=	"f2s1v1";

    public	static	final	String	F2S2V1	=	"f2s2v1";

    public	static	final	String	F2S3V1	=	"f2s3v1";
    public	static	final	String	F2S3V2	=	"f2s3v2";
    public	static	final	String	F2S3V3	=	"f2s3v3";

    public	static	final	String	F2S4V1	=	"f2s4v1";

    public	static	final	String	F2S5V1	=	"f2s5v1";

    public	static	final	String	F2S6V1	=	"f2s6v1";

    public	static	final	String	F2S7V1	=	"f2s7v1";

    public	static	final	String	F2S8V1	=	"f2s8v1";

    public	static	final	String	F2S9V1	=	"f2s9v1";

    public	static	final	String	F2S10V1	=	"f2s10v1";

    public	static	final	String	F2S11V1	=	"f2s11v1";

    public	static	final	String	F2S12V1	=	"f2s12v1";

    public	static	final	String	F2S13V1	=	"f2s13v1";

    public	static	final	String	F2S14V1	=	"f2s14v1";

    public	static	final	String	F2S15V1	=	"f2s15v1";

    public	static	final	String	F2S16V1	=	"f2s16v1";

    public	static	final	String	F2S17V1	=	"f2s17v1";
    public	static	final	String	F2S17V2	=	"f2s17v2";
    public	static	final	String	F2S17V3	=	"f2s17v3";
    public	static	final	String	F2S17V4	=	"f2s17v4";
    public	static	final	String	F2S17V5	=	"f2s17v5";
    public	static	final	String	F2S17V6	=	"f2s17v6";

    public	static	final	String	F2S18V1	=	"f2s18v1";
    public	static	final	String	F2S18V2	=	"f2s18v2";
    public	static	final	String	F2S18V3	=	"f2s18v3";
    public	static	final	String	F2S18V4	=	"f2s18v4";
    public	static	final	String	F2S18V5	=	"f2s18v5";

    public	static	final	String	F2S19V1	=	"f2s19v1";
    public	static	final	String	F2S19V2	=	"f2s19v2";
    public	static	final	String	F2S19V3	=	"f2s19v3";

    public	static	final	String	F2S20V1	=	"f2s20v1";
    public	static	final	String	F2S20V2	=	"f2s20v2";
    public	static	final	String	F2S20V3	=	"f2s20v3";

    public	static	final	String	F2S21V1	=	"f2s21v1";
    public	static	final	String	F2S21V2	=	"f2s21v2";
    public	static	final	String	F2S21V3	=	"f2s21v3";
    public	static	final	String	F2S21V4	=	"f2s21v4";
    public	static	final	String	F2S21V5	=	"f2s21v5";
    public	static	final	String	F2S21V6	=	"f2s21v6";
    public	static	final	String	F2S21V7	=	"f2s21v7";
    public	static	final	String	F2S21V8	=	"f2s21v8";
    public	static	final	String	F2S21V9	=	"f2s21v9";
    public	static	final	String	F2S21V10	=	"f2s21v10";
    public	static	final	String	F2S21V11	=	"f2s21v11";
    public	static	final	String	F2S21V12	=	"f2s21v12";
    public	static	final	String	F2S21V13	=	"f2s21v13";
    public	static	final	String	F2S21V14	=	"f2s21v14";
    public	static	final	String	F2S21V15	=	"f2s21v15";
    public	static	final	String	F2S21V16	=	"f2s21v16";

    public	static	final	String	F2S22V1	=	"f2s22v1";
    public	static	final	String	F2S22V2	=	"f2s22v2";
    public	static	final	String	F2S22V3	=	"f2s22v3";
    public	static	final	String	F2S22V4	=	"f2s22v4";
    public	static	final	String	F2S22V5	=	"f2s22v5";
    public	static	final	String	F2S22V6	=	"f2s22v6";
    public	static	final	String	F2S22V7	=	"f2s22v7";
    public	static	final	String	F2S22V8	=	"f2s22v8";
    public	static	final	String	F2S22V9	=	"f2s22v9";
    public	static	final	String	F2S22V10	=	"f2s22v10";
    public	static	final	String	F2S22V11	=	"f2s22v11";
    public	static	final	String	F2S22V12	=	"f2s22v12";
    public	static	final	String	F2S22V13	=	"f2s22v13";
    public	static	final	String	F2S22V14	=	"f2s22v14";
    public	static	final	String	F2S22V15	=	"f2s22v15";
    public	static	final	String	F2S22V16	=	"f2s22v16";
    public	static	final	String	F2S22V17	=	"f2s22v17";
    public	static	final	String	F2S22V18	=	"f2s22v18";
    public	static	final	String	F2S22V19	=	"f2s22v19";
    public	static	final	String	F2S22V20	=	"f2s22v20";
    public	static	final	String	F2S22V21	=	"f2s22v21";
    public	static	final	String	F2S22V22	=	"f2s22v22";
    public	static	final	String	F2S22V23	=	"f2s22v23";
    public	static	final	String	F2S22V24	=	"f2s22v24";
    public	static	final	String	F2S22V25	=	"f2s22v25";
    public	static	final	String	F2S22V26	=	"f2s22v26";
    public	static	final	String	F2S22V27	=	"f2s22v27";
    public	static	final	String	F2S22V28	=	"f2s22v28";
    public	static	final	String	F2S22V29	=	"f2s22v29";
    public	static	final	String	F2S22V30	=	"f2s22v30";
    public	static	final	String	F2S22V31	=	"f2s22v31";
    public	static	final	String	F2S22V32	=	"f2s22v32";
    public	static	final	String	F2S22V33	=	"f2s22v33";
    public	static	final	String	F2S22V34	=	"f2s22v34";
    public	static	final	String	F2S22V35	=	"f2s22v35";
    public	static	final	String	F2S22V36	=	"f2s22v36";
    public	static	final	String	F2S22V37	=	"f2s22v37";
    public	static	final	String	F2S22V38	=	"f2s22v38";
    public	static	final	String	F2S22V39	=	"f2s22v39";
    public	static	final	String	F2S22V40	=	"f2s22v40";
    public	static	final	String	F2S22V41	=	"f2s22v41";
    public	static	final	String	F2S22V42	=	"f2s22v42";
    public	static	final	String	F2S22V43	=	"f2s22v43";
    public	static	final	String	F2S22V44	=	"f2s22v44";
    public	static	final	String	F2S22V45	=	"f2s22v45";
    public	static	final	String	F2S22V46	=	"f2s22v46";
    public	static	final	String	F2S22V47	=	"f2s22v47";
    public	static	final	String	F2S22V48	=	"f2s22v48";
    public	static	final	String	F2S22V49	=	"f2s22v49";
    public	static	final	String	F2S22V50	=	"f2s22v50";
    public	static	final	String	F2S22V51	=	"f2s22v51";
    public	static	final	String	F2S22V52	=	"f2s22v52";
    public	static	final	String	F2S22V53	=	"f2s22v53";
    public	static	final	String	F2S22V54	=	"f2s22v54";
    public	static	final	String	F2S22V55	=	"f2s22v55";
    public	static	final	String	F2S22V56	=	"f2s22v56";
    public	static	final	String	F2S22V57	=	"f2s22v57";
    public	static	final	String	F2S22V58	=	"f2s22v58";

    public	static	final	String	F2S23V1	=	"f2s23v1";
    public	static	final	String	F2S23V2	=	"f2s23v2";
    public	static	final	String	F2S23V3	=	"f2s23v3";
    public	static	final	String	F2S23V4	=	"f2s23v4";
    public	static	final	String	F2S23V5	=	"f2s23v5";
    public	static	final	String	F2S23V6	=	"f2s23v6";
    public	static	final	String	F2S23V7	=	"f2s23v7";
    public	static	final	String	F2S23V8	=	"f2s23v8";
    public	static	final	String	F2S23V9	=	"f2s23v9";
    public	static	final	String	F2S23V10=	"f2s23v10";
    public	static	final	String	F2S23V11=	"f2s23v11";
    public	static	final	String	F2S23V12=	"f2s23v12";

    public	static	final	String	F2S24V1	=	"f2s24v1";

    public	static	final	String	F2S25V1	=	"f2s25v1";

    public	static	final	String	F2S26V1	=	"f2s26v1";

    public	static	final	String	F2S27V1	=	"f2s27v1";












    private static final String TABLE_NAME_barand = "_car_brand";
    public static final String brand_COLUMN_ID = "id";
    public static final String brand_COLUMN_ID_FACTORY = "factory_id";
    public static final String brand_COLUMN_BRANDNAME = "brand_name";


    private static final String TABLE_NAME_china = "_car_china";
    public static final String china_COLUMN_ID = "id";
    public static final String china_COLUMN_NAME = "name";


    private static final String TABLE_NAME_carexport = "_car_export";
    public static final String carexport_COLUMN_ID = "id";
    public static final String carexport_COLUMN_NAME = "name";

    private static final String TABLE_NAME_carfactory = "_car_factory";
    public static final String factory_COLUMN_ID = "id";
    public static final String factory_COLUMN_NAME = "factory_name";


    private static final String TABLE_NAME_model = "_car_model";
    public static final String model_COLUMN_ID = "id";
    public static final String model_COLUMN_id_fac = "factory_id";
    public static final String model_COLUMN_id_bra = "brand_id";
    public static final String model_COLUMN_NAME = "model_name";



    private static final String TABLE_NAME_car_type = "_car_type";
    public static final String type_COLUMN_ID = "id";
    public static final String type_COLUMN_NAME = "name";



    private static final String TABLE_NAME_tip = "_car_tip";
    public static final String tip_COLUMN_ID = "id";
    public static final String tip_COLUMN_id_fac = "factory_id";
    public static final String tip_COLUMN_id_bra = "brand_id";
    public static final String tip_COLUMN_id_mod = "model_id";
    public static final String tip_COLUMN_NAME = "tip_name";
    public static final String tip_COLUMN_id_type = "type_id";
    public static final String tip_COLUMN_id_export = "export_id";
    public static final String tip_COLUMN_id_china = "china_id";
    public static final String tip_COLUMN_min_p = "min_price";
    public static final String tip_COLUMN_max_p = "max_price";



























    final ArrayList<HashMap<String, String>> table_info = new ArrayList<HashMap<String, String>>();

    public dbHandler(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_ITEM_TABLE_1 = "CREATE TABLE " + TABLE_NAME_barand + "(" +

                brand_COLUMN_ID + " INTEGER PRIMARY KEY," +
                brand_COLUMN_ID_FACTORY + " INTEGER," +
                brand_COLUMN_BRANDNAME + " NVARCHAR(100))";


        String CREATE_ITEM_TABLE_2 = "CREATE TABLE " + TABLE_NAME_china + "(" +

                china_COLUMN_ID + " INTEGER PRIMARY KEY," +
                china_COLUMN_NAME + " NVARCHAR(100))";


        String CREATE_ITEM_TABLE_3 = "CREATE TABLE " + TABLE_NAME_carexport + "(" +

                carexport_COLUMN_ID + " INTEGER PRIMARY KEY," +
                carexport_COLUMN_NAME + " NVARCHAR(100))";


        String CREATE_ITEM_TABLE_4 = "CREATE TABLE " + TABLE_NAME_carfactory + "(" +

                factory_COLUMN_ID + " INTEGER PRIMARY KEY," +
                factory_COLUMN_NAME + " NVARCHAR(100))";


        String CREATE_ITEM_TABLE_5 = "CREATE TABLE " + TABLE_NAME_model + "(" +

                model_COLUMN_ID + " INTEGER PRIMARY KEY," +
                model_COLUMN_id_fac + " INTEGER,"+
                model_COLUMN_id_bra + " INTEGER,"+
                model_COLUMN_NAME + " NVARCHAR(100))";

        String CREATE_ITEM_TABLE_6 = "CREATE TABLE " + TABLE_NAME_car_type + "(" +

                type_COLUMN_ID + " INTEGER PRIMARY KEY," +
                type_COLUMN_NAME + " NVARCHAR(100))";


        String CREATE_ITEM_TABLE_7 = "CREATE TABLE " + TABLE_NAME_tip + "(" +

                tip_COLUMN_ID + " INTEGER PRIMARY KEY," +
                tip_COLUMN_id_fac + " INTEGER,"+
                tip_COLUMN_id_bra + " INTEGER,"+
                tip_COLUMN_id_mod + " INTEGER,"+
                tip_COLUMN_NAME + " NVARCHAR(100),"+
                tip_COLUMN_id_type + " INTEGER,"+
                tip_COLUMN_id_export + " INTEGER,"+
                tip_COLUMN_id_china + " INTEGER,"+
                tip_COLUMN_min_p + " INTEGER,"+
                tip_COLUMN_max_p + " INTEGER)";






































        // Category table create query
        String CREATE_ITEM_TABLE = "CREATE TABLE " + TABLE_NAME_form_1 + "(" +

                COLUMN_ID + " INTEGER PRIMARY KEY," +
                COLUMN_ID_USER + " NVARCHAR(100)," +
                COLUMN_LONG + " NVARCHAR(100)," +
                COLUMN_LATI + " NVARCHAR(100)," +
                COLUMN_STATE + " NVARCHAR(100)," +
                COLUMN_CITY + " NVARCHAR(100)," +
                COLUMN_VILLAGE + " NVARCHAR(100)," +
                COLUMN_PHONECODE + " NVARCHAR(100)," +
                COLUMN_DATE + " NVARCHAR(100)," +

                F1S1V1	+	" NVARCHAR(100)," +
                F1S1V2	+	" NVARCHAR(100)," +
                F1S1V3	+	" NVARCHAR(100)," +
                F1S1V4	+	" NVARCHAR(100)," +
                F1S1V5	+	" NVARCHAR(100)," +
                F1S1V6	+	" NVARCHAR(100)," +
                F1S1V7	+	" NVARCHAR(100)," +
                F1S1V8	+	" NVARCHAR(100)," +

                F1S2V1	+	" NVARCHAR(100)," +
                F1S2V2	+	" NVARCHAR(100)," +
                F1S2V3	+	" NVARCHAR(100)," +
                F1S2V4	+	" NVARCHAR(100)," +

                F1S3V1	+	" NVARCHAR(100)," +
                F1S3V2	+	" NVARCHAR(100)," +
                F1S3V3	+	" NVARCHAR(100)," +
                F1S3V4	+	" NVARCHAR(100)," +
                F1S3V5	+	" NVARCHAR(100)," +
                F1S3V6	+	" NVARCHAR(100)," +

                F1S4V1	+	" NVARCHAR(100)," +
                F1S4V2	+	" NVARCHAR(100)," +
                F1S4V3	+	" NVARCHAR(100)," +
                F1S4V4	+	" NVARCHAR(100)," +
                F1S4V5	+	" NVARCHAR(100)," +
                F1S4V6	+	" NVARCHAR(100)," +
                F1S4V7	+	" NVARCHAR(100)," +
                F1S4V8	+	" NVARCHAR(100)," +
                F1S4V9	+	" NVARCHAR(100)," +
                F1S4V10	+	" NVARCHAR(100)," +
                F1S4V11	+	" NVARCHAR(100)," +
                F1S4V12	+	" NVARCHAR(100)," +
                F1S4V13	+	" NVARCHAR(100)," +
                F1S4V14	+	" NVARCHAR(100)," +
                F1S4V15	+	" NVARCHAR(100)," +
                F1S4V16	+	" NVARCHAR(100)," +
                F1S4V17	+	" NVARCHAR(100)," +
                F1S4V18	+	" NVARCHAR(100)," +
                F1S4V19	+	" NVARCHAR(100)," +
                F1S4V20	+	" NVARCHAR(100)," +
                F1S4V21	+	" NVARCHAR(100)," +
                F1S4V22	+	" NVARCHAR(100)," +
                F1S4V23	+	" NVARCHAR(100)," +
                F1S4V24	+	" NVARCHAR(100)," +
                F1S4V25	+	" NVARCHAR(100)," +
                F1S4V26	+	" NVARCHAR(100)," +
                F1S4V27	+	" NVARCHAR(100)," +
                F1S4V28	+	" NVARCHAR(100)," +
                F1S4V29	+	" NVARCHAR(100)," +
                F1S4V30	+	" NVARCHAR(100)," +
                F1S4V31	+	" NVARCHAR(100)," +
                F1S4V32	+	" NVARCHAR(100)," +
                F1S4V33	+	" NVARCHAR(100)," +
                F1S4V34	+	" NVARCHAR(100)," +

                F1S5V1	+	" NVARCHAR(100)," +
                F1S5V2	+	" NVARCHAR(100)," +
                F1S5V3	+	" NVARCHAR(100)," +
                F1S5V4	+	" NVARCHAR(100)," +
                F1S5V5	+	" NVARCHAR(100)," +
                F1S5V6	+	" NVARCHAR(100)," +
                F1S5V7	+	" NVARCHAR(100)," +
                F1S5V8	+	" NVARCHAR(100)," +
                F1S5V9	+	" NVARCHAR(100)," +
                F1S5V10	+	" NVARCHAR(100)," +

                F1S6V10	+	" NVARCHAR(100)," +
                F1S6V11	+	" NVARCHAR(100)," +
                F1S6V12	+	" NVARCHAR(100)," +
                F1S6V13	+	" NVARCHAR(100)," +
                F1S6V14	+	" NVARCHAR(100)," +
                F1S6V15	+	" NVARCHAR(100)," +
                F1S6V16	+	" NVARCHAR(100)," +
                F1S6V17	+	" NVARCHAR(100)," +
                F1S6V18	+	" NVARCHAR(100)," +
                F1S6V19	+	" NVARCHAR(100)," +
                F1S6V20	+	" NVARCHAR(100)," +
                F1S6V21	+	" NVARCHAR(100)," +
                F1S6V22	+	" NVARCHAR(100)," +
                F1S6V23	+	" NVARCHAR(100)," +
                F1S6V24	+	" NVARCHAR(100)," +
                F1S6V25	+	" NVARCHAR(100)," +
                F1S6V26	+	" NVARCHAR(100)," +
                F1S6V27	+	" NVARCHAR(100)," +
                F1S6V28	+	" NVARCHAR(100)," +
                F1S6V29	+	" NVARCHAR(100)," +
                F1S6V30	+	" NVARCHAR(100)," +
                F1S6V31	+	" NVARCHAR(100)," +
                F1S6V32	+	" NVARCHAR(100)," +
                F1S6V33	+	" NVARCHAR(100)," +
                F1S6V34	+	" NVARCHAR(100)," +
                F1S6V35	+	" NVARCHAR(100)," +

                F1S7V1	+	" NVARCHAR(100)," +
                F1S7V2	+	" NVARCHAR(100)," +
                F1S7V3	+	" NVARCHAR(100)," +
                F1S7V4	+	" NVARCHAR(100)," +
                F1S7V5	+	" NVARCHAR(100)," +
                F1S7V6	+	" NVARCHAR(100)," +
                F1S7V7	+	" NVARCHAR(100)," +
                F1S7V8	+	" NVARCHAR(100)," +
                F1S7V9	+	" NVARCHAR(100)," +
                F1S7V10	+	" NVARCHAR(100)," +
                F1S7V11	+	" NVARCHAR(100)," +
                F1S7V12	+	" NVARCHAR(100)," +
                F1S7V13	+	" NVARCHAR(100)," +
                F1S7V14	+	" NVARCHAR(100)," +
                F1S7V15	+	" NVARCHAR(100)," +
                F1S7V16	+	" NVARCHAR(100)," +
                F1S7V17	+	" NVARCHAR(100)," +
                F1S7V18	+	" NVARCHAR(100)," +
                F1S7V19	+	" NVARCHAR(100)," +

                F1S8V1	+	" NVARCHAR(100)," +
                F1S8V2	+	" NVARCHAR(100)," +
                F1S8V3	+	" NVARCHAR(100)," +

                F1S9V1	+	" NVARCHAR(100)," +
                F1S9V2	+	" NVARCHAR(100)," +
                F1S9V3	+	" NVARCHAR(100)," +

                F1S10V1	+	" NVARCHAR(100)," +
                F1S10V2	+	" NVARCHAR(100)," +

                F1S11V1	+	" NVARCHAR(100)," +
                F1S11V2	+	" NVARCHAR(100))";


       String CREATE_ITEM_TABLE2 = "CREATE TABLE " + TABLE_NAME_form_2 + "(" +
               COLUMN_ID + " INTEGER PRIMARY KEY," +
               COLUMN_ID_USER + " NVARCHAR(100)," +
               COLUMN_LONG + " NVARCHAR(100)," +
               COLUMN_LATI + " NVARCHAR(100)," +
               COLUMN_STATE + " NVARCHAR(100)," +
               COLUMN_CITY + " NVARCHAR(100)," +
               COLUMN_VILLAGE + " NVARCHAR(100)," +
               COLUMN_PHONECODE + " NVARCHAR(100)," +
               COLUMN_DATE + " NVARCHAR(100)," +

               F1S1V1 +   " NVARCHAR(100)," +
               F1S1V2 +   " NVARCHAR(100)," +
               F1S1V3 +   " NVARCHAR(100)," +
               F1S1V4 +   " NVARCHAR(100)," +
               F1S1V5 +   " NVARCHAR(100)," +
               F1S1V6 +   " NVARCHAR(100)," +
               F1S1V7 +   " NVARCHAR(100)," +

               F2S1V1 +   " NVARCHAR(100)," +

               F2S2V1 +   " NVARCHAR(100)," +

               F2S3V1 +   " NVARCHAR(100)," +
               F2S3V2 +   " NVARCHAR(100)," +
               F2S3V3 +   " NVARCHAR(100)," +

               F2S4V1 +   " NVARCHAR(100)," +

               F2S5V1 +   " NVARCHAR(100)," +

               F2S6V1 +   " NVARCHAR(100)," +

               F2S7V1 +   " NVARCHAR(100)," +

               F2S8V1 +   " NVARCHAR(100)," +

               F2S9V1 +   " NVARCHAR(100)," +

               F2S10V1 +   " NVARCHAR(100)," +

               F2S11V1 +   " NVARCHAR(100)," +

               F2S12V1 +   " NVARCHAR(100)," +

               F2S13V1 +   " NVARCHAR(100)," +

               F2S14V1 +   " NVARCHAR(100)," +

               F2S15V1 +   " NVARCHAR(100)," +

               F2S16V1 +   " NVARCHAR(100)," +

               F2S17V1 +   " NVARCHAR(100)," +
               F2S17V2 +   " NVARCHAR(100)," +
               F2S17V3 +   " NVARCHAR(100)," +
               F2S17V4 +   " NVARCHAR(100)," +
               F2S17V5 +   " NVARCHAR(100)," +
               F2S17V6 +   " NVARCHAR(100)," +

               F2S18V1 +   " NVARCHAR(100)," +
               F2S18V2 +   " NVARCHAR(100)," +
               F2S18V3 +   " NVARCHAR(100)," +
               F2S18V4 +   " NVARCHAR(100)," +
               F2S18V5 +   " NVARCHAR(100)," +

               F2S19V1 +   " NVARCHAR(100)," +
               F2S19V2 +   " NVARCHAR(100)," +
               F2S19V3 +   " NVARCHAR(100)," +

               F2S20V1 +   " NVARCHAR(100)," +
               F2S20V2 +   " NVARCHAR(100)," +
               F2S20V3 +   " NVARCHAR(100)," +

               F2S21V1 +   " NVARCHAR(100)," +
               F2S21V2 +   " NVARCHAR(100)," +
               F2S21V3 +   " NVARCHAR(100)," +
               F2S21V4 +   " NVARCHAR(100)," +
               F2S21V5 +   " NVARCHAR(100)," +
               F2S21V6 +   " NVARCHAR(100)," +
               F2S21V7 +   " NVARCHAR(100)," +
               F2S21V8 +   " NVARCHAR(100)," +
               F2S21V9 +   " NVARCHAR(100)," +
               F2S21V10 +   " NVARCHAR(100)," +
               F2S21V11 +   " NVARCHAR(100)," +
               F2S21V12 +   " NVARCHAR(100)," +
               F2S21V13 +   " NVARCHAR(100)," +
               F2S21V14 +   " NVARCHAR(100)," +
               F2S21V15 +   " NVARCHAR(100)," +
               F2S21V16 +   " NVARCHAR(100)," +

               F2S22V1 +   " NVARCHAR(100)," +
               F2S22V2 +   " NVARCHAR(100)," +
               F2S22V3 +   " NVARCHAR(100)," +
               F2S22V4 +   " NVARCHAR(100)," +
               F2S22V5 +   " NVARCHAR(100)," +
               F2S22V6 +   " NVARCHAR(100)," +
               F2S22V7 +   " NVARCHAR(100)," +
               F2S22V8 +   " NVARCHAR(100)," +
               F2S22V9 +   " NVARCHAR(100)," +
               F2S22V10 +   " NVARCHAR(100)," +
               F2S22V11 +   " NVARCHAR(100)," +
               F2S22V12 +   " NVARCHAR(100)," +
               F2S22V13 +   " NVARCHAR(100)," +
               F2S22V14 +   " NVARCHAR(100)," +
               F2S22V15 +   " NVARCHAR(100)," +
               F2S22V16 +   " NVARCHAR(100)," +
               F2S22V17 +   " NVARCHAR(100)," +
               F2S22V18 +   " NVARCHAR(100)," +
               F2S22V19 +   " NVARCHAR(100)," +
               F2S22V20 +   " NVARCHAR(100)," +
               F2S22V21 +   " NVARCHAR(100)," +
               F2S22V22 +   " NVARCHAR(100)," +
               F2S22V23 +   " NVARCHAR(100)," +
               F2S22V24 +   " NVARCHAR(100)," +
               F2S22V25 +   " NVARCHAR(100)," +
               F2S22V26 +   " NVARCHAR(100)," +
               F2S22V27 +   " NVARCHAR(100)," +
               F2S22V28 +   " NVARCHAR(100)," +
               F2S22V29 +   " NVARCHAR(100)," +
               F2S22V30 +   " NVARCHAR(100)," +
               F2S22V31 +   " NVARCHAR(100)," +
               F2S22V32 +   " NVARCHAR(100)," +
               F2S22V33 +   " NVARCHAR(100)," +
               F2S22V34 +   " NVARCHAR(100)," +
               F2S22V35 +   " NVARCHAR(100)," +
               F2S22V36 +   " NVARCHAR(100)," +
               F2S22V37 +   " NVARCHAR(100)," +
               F2S22V38 +   " NVARCHAR(100)," +
               F2S22V39 +   " NVARCHAR(100)," +
               F2S22V40 +   " NVARCHAR(100)," +
               F2S22V41 +   " NVARCHAR(100)," +
               F2S22V42 +   " NVARCHAR(100)," +
               F2S22V43 +   " NVARCHAR(100)," +
               F2S22V44 +   " NVARCHAR(100)," +
               F2S22V45 +   " NVARCHAR(100)," +
               F2S22V46 +   " NVARCHAR(100)," +
               F2S22V47 +   " NVARCHAR(100)," +
               F2S22V48 +   " NVARCHAR(100)," +
               F2S22V49 +   " NVARCHAR(100)," +
               F2S22V50 +   " NVARCHAR(100)," +
               F2S22V51 +   " NVARCHAR(100)," +
               F2S22V52 +   " NVARCHAR(100)," +
               F2S22V53 +   " NVARCHAR(100)," +
               F2S22V54 +   " NVARCHAR(100)," +
               F2S22V55 +   " NVARCHAR(100)," +
               F2S22V56 +   " NVARCHAR(100)," +
               F2S22V57 +   " NVARCHAR(100)," +
               F2S22V58 +   " NVARCHAR(100)," +

               F2S23V1 +   " NVARCHAR(100)," +
               F2S23V2 +   " NVARCHAR(100)," +
               F2S23V3 +   " NVARCHAR(100)," +
               F2S23V4 +   " NVARCHAR(100)," +
               F2S23V5 +   " NVARCHAR(100)," +
               F2S23V6 +   " NVARCHAR(100)," +
               F2S23V7 +   " NVARCHAR(100)," +
               F2S23V8 +   " NVARCHAR(100)," +
               F2S23V9 +   " NVARCHAR(100)," +
               F2S23V10 +   " NVARCHAR(100)," +
               F2S23V11 +   " NVARCHAR(100)," +
               F2S23V12 +   " NVARCHAR(100)," +

               F2S24V1 +   " NVARCHAR(100)," +

               F2S25V1 +   " NVARCHAR(100)," +

               F2S26V1 +   " NVARCHAR(100)," +

               F2S27V1 +   " NVARCHAR(100))";





        db.execSQL(CREATE_ITEM_TABLE);
        db.execSQL(CREATE_ITEM_TABLE_1);
        db.execSQL(CREATE_ITEM_TABLE_2);
        db.execSQL(CREATE_ITEM_TABLE_3);
        db.execSQL(CREATE_ITEM_TABLE_4);
        db.execSQL(CREATE_ITEM_TABLE_5);
        db.execSQL(CREATE_ITEM_TABLE_6);
        db.execSQL(CREATE_ITEM_TABLE_7);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        //db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_form_1);

        // Create tables again
        onCreate(db);
    }

    //Create one row for person
    public void gnerateOneRow() {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues valuesword = new ContentValues();
        try
        {
            //valuesword.put("id", "");
            valuesword.put( COLUMN_ID_USER , "");
            valuesword.put(COLUMN_LONG , "" );
            valuesword.put(COLUMN_LATI , "" );
            valuesword.put(COLUMN_STATE , "" );
            valuesword.put(COLUMN_CITY , "" );
            valuesword.put(COLUMN_VILLAGE , "" );
            valuesword.put(COLUMN_PHONECODE , "" );
            valuesword.put(COLUMN_DATE , "" );

            valuesword.put(	F1S1V1	,	""	);
            valuesword.put(	F1S1V2	,	""	);
            valuesword.put(	F1S1V3	,	""	);
            valuesword.put(	F1S1V4	,	""	);
            valuesword.put(	F1S1V5	,	""	);
            valuesword.put(	F1S1V6	,	""	);
            valuesword.put(	F1S1V7	,	""	);
            valuesword.put(	F1S1V8	,	""	);

            valuesword.put(	F1S2V1	,	""	);
            valuesword.put(	F1S2V2	,	""	);
            valuesword.put(	F1S2V3	,	""	);
            valuesword.put(	F1S2V4	,	""	);

            valuesword.put(	F1S3V1	,	""	);
            valuesword.put(	F1S3V2	,	""	);
            valuesword.put(	F1S3V3	,	""	);
            valuesword.put(	F1S3V4	,	""	);
            valuesword.put(	F1S3V5	,	""	);
            valuesword.put(	F1S3V6	,	""	);

            valuesword.put(	F1S4V1	,	""	);
            valuesword.put(	F1S4V2	,	""	);
            valuesword.put(	F1S4V3	,	""	);
            valuesword.put(	F1S4V4	,	""	);
            valuesword.put(	F1S4V5	,	""	);
            valuesword.put(	F1S4V6	,	""	);
            valuesword.put(	F1S4V7	,	""	);
            valuesword.put(	F1S4V8	,	""	);
            valuesword.put(	F1S4V9	,	""	);
            valuesword.put(	F1S4V10	,	""	);
            valuesword.put(	F1S4V11	,	""	);
            valuesword.put(	F1S4V12	,	""	);
            valuesword.put(	F1S4V13	,	""	);
            valuesword.put(	F1S4V14	,	""	);
            valuesword.put(	F1S4V15	,	""	);
            valuesword.put(	F1S4V16	,	""	);
            valuesword.put(	F1S4V17	,	""	);
            valuesword.put(	F1S4V18	,	""	);
            valuesword.put(	F1S4V19	,	""	);
            valuesword.put(	F1S4V20	,	""	);
            valuesword.put(	F1S4V21	,	""	);
            valuesword.put(	F1S4V22	,	""	);
            valuesword.put(	F1S4V23	,	""	);
            valuesword.put(	F1S4V24	,	""	);
            valuesword.put(	F1S4V25	,	""	);
            valuesword.put(	F1S4V26	,	""	);
            valuesword.put(	F1S4V27	,	""	);
            valuesword.put(	F1S4V28	,	""	);
            valuesword.put(	F1S4V29	,	""	);
            valuesword.put(	F1S4V30	,	""	);
            valuesword.put(	F1S4V31	,	""	);
            valuesword.put(	F1S4V32	,	""	);
            valuesword.put(	F1S4V33	,	""	);
            valuesword.put(	F1S4V34	,	""	);

            valuesword.put(	F1S5V1	,	""	);
            valuesword.put(	F1S5V2	,	""	);
            valuesword.put(	F1S5V3	,	""	);
            valuesword.put(	F1S5V4	,	""	);
            valuesword.put(	F1S5V5	,	""	);
            valuesword.put(	F1S5V6	,	""	);
            valuesword.put(	F1S5V7	,	""	);
            valuesword.put(	F1S5V8	,	""	);
            valuesword.put(	F1S5V9	,	""	);
            valuesword.put(	F1S5V10	,	""	);

            valuesword.put(	F1S6V10	,	""	);
            valuesword.put(	F1S6V11	,	""	);
            valuesword.put(	F1S6V12	,	""	);
            valuesword.put(	F1S6V13	,	""	);
            valuesword.put(	F1S6V14	,	""	);
            valuesword.put(	F1S6V15	,	""	);
            valuesword.put(	F1S6V16	,	""	);
            valuesword.put(	F1S6V17	,	""	);
            valuesword.put(	F1S6V18	,	""	);
            valuesword.put(	F1S6V19	,	""	);
            valuesword.put(	F1S6V20	,	""	);
            valuesword.put(	F1S6V21	,	""	);
            valuesword.put(	F1S6V22	,	""	);
            valuesword.put(	F1S6V23	,	""	);
            valuesword.put(	F1S6V24	,	""	);
            valuesword.put(	F1S6V25	,	""	);
            valuesword.put(	F1S6V26	,	""	);
            valuesword.put(	F1S6V27	,	""	);
            valuesword.put(	F1S6V28	,	""	);
            valuesword.put(	F1S6V29	,	""	);
            valuesword.put(	F1S6V30	,	""	);
            valuesword.put(	F1S6V31	,	""	);
            valuesword.put(	F1S6V32	,	""	);
            valuesword.put(	F1S6V33	,	""	);
            valuesword.put(	F1S6V34	,	""	);
            valuesword.put(	F1S6V35	,	""	);

            valuesword.put(	F1S7V1	,	""	);
            valuesword.put(	F1S7V2	,	""	);
            valuesword.put(	F1S7V3	,	""	);
            valuesword.put(	F1S7V4	,	""	);
            valuesword.put(	F1S7V5	,	""	);
            valuesword.put(	F1S7V6	,	""	);
            valuesword.put(	F1S7V7	,	""	);
            valuesword.put(	F1S7V8	,	""	);
            valuesword.put(	F1S7V9	,	""	);
            valuesword.put(	F1S7V10	,	""	);
            valuesword.put(	F1S7V11	,	""	);
            valuesword.put(	F1S7V12	,	""	);
            valuesword.put(	F1S7V13	,	""	);
            valuesword.put(	F1S7V14	,	""	);
            valuesword.put(	F1S7V15	,	""	);
            valuesword.put(	F1S7V16	,	""	);
            valuesword.put(	F1S7V17	,	""	);
            valuesword.put(	F1S7V18	,	""	);
            valuesword.put(	F1S7V19	,	""	);

            valuesword.put(	F1S8V1	,	""	);
            valuesword.put(	F1S8V2	,	""	);
            valuesword.put(	F1S8V3	,	""	);

            valuesword.put(	F1S9V1	,	""	);
            valuesword.put(	F1S9V2	,	""	);
            valuesword.put(	F1S9V3	,	""	);

            valuesword.put(	F1S10V1	,	""	);
            valuesword.put(	F1S10V2	,	""	);

            valuesword.put(	F1S11V1	,	""	);
            valuesword.put(	F1S11V2	,	""	);

            db.insert(TABLE_NAME_form_1, null, valuesword);
            db.close();
        }
        catch (Exception e)
        {
            db.close();
        }
    }



    //update for soal
    public void Updatefirst(String id, Map<String,String> amir){

        String text="";
        for (Map.Entry<String,String> entry : amir.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            // do stuff
            text +=key+"='"+value+"',";
        }
        String te = text.substring(0, text.length() - 1);
        SQLiteDatabase db = this.getWritableDatabase();
        //String selectQuery = "UPDATE "+ TABLE_NAME_form_1+" SET f1s1v1='"+v1+"',f1s1v2='"+v2+"',f1s1v3='"+v3+"' WHERE id="+id+";";
        String selectQuery = "UPDATE "+ TABLE_NAME_form_1+" SET "+te+" WHERE f1_id="+id+";";

        db.execSQL(selectQuery);
        db.close();
    }



    //update for soal
    public void UpdateF1S1(String id, Map<String,String> amir){

        String text="";
        for (Map.Entry<String,String> entry : amir.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            // do stuff
            text +=key+"='"+value+"',";
        }
        String te = text.substring(0, text.length() - 1);
        SQLiteDatabase db = this.getWritableDatabase();
        //String selectQuery = "UPDATE "+ TABLE_NAME_form_1+" SET f1s1v1='"+v1+"',f1s1v2='"+v2+"',f1s1v3='"+v3+"' WHERE id="+id+";";
        String selectQuery = "UPDATE "+ TABLE_NAME_form_1+" SET "+te+" WHERE f1_id="+id+";";

        db.execSQL(selectQuery);
        db.close();
    }





    //get last id in table
    public String GetLastIdRow(){
        //Select All Query
        String selectQuery = "SELECT f1_id FROM "+ TABLE_NAME_form_1 +" ORDER BY f1_id DESC LIMIT 1;";
        String id="";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);//selectQuery,selectedArguments
        if (cursor.moveToFirst()) {
             id = cursor.getString(0);//staus
        }
        db.close();
        return id;
    }

    //show one row in table for view
    public String viewOneRow(String id){
        //Select All Query
        List<String> list = new ArrayList<String>();

        String selectQuery = "SELECT  *  FROM "+TABLE_NAME_form_1 + " WHERE f1_id="+id+";";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);//selectQuery,selectedArguments
        Integer count=0;
        count = cursor.getCount();
        //list.add(Integer.toString(cursor.getCount()));

        while (cursor.moveToNext()) {
            list.add(cursor.getString(0));//id
            list.add(cursor.getString(1));//idcat
            list.add(cursor.getString(2));//voen
            list.add(cursor.getString(3));//vofa
            list.add(cursor.getString(4));//vocode
            list.add(cursor.getString(5));//status
            list.add(cursor.getString(6));//status2
            list.add(cursor.getString(7));//img1
            list.add(cursor.getString(8));//img2
            list.add(cursor.getString(9));//img2
            list.add(cursor.getString(10));//img2
            list.add(cursor.getString(11));//img2
        }


        cursor.close();
        db.close();
        return list.get(0)+list.get(9)+list.get(10)+list.get(11);
    }

/*
    //show one row in table for view
    public String  viewOneRow2(String id){
        //Select All Query
        List<String> list = new ArrayList<String>();

        String selectQuery = "SELECT  *  FROM "+TABLE_NAME_factory+";";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);//selectQuery,selectedArguments
        Integer count=0;
        count = cursor.getCount();
        JSONArray resultSet = new JSONArray();
        //list.add(Integer.toString(cursor.getCount()));
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false) {

            int totalColumn = cursor.getColumnCount();
            JSONObject rowObject = new JSONObject();

            for( int i=0 ;  i< totalColumn ; i++ )
            {
                if( cursor.getColumnName(i) != null )
                {
                    try
                    {
                        if( cursor.getString(i) != null )
                        {
                            Log.d("TAG_NAME", cursor.getString(i));
                            rowObject.put(cursor.getColumnName(i) ,  cursor.getString(i) );
                        }
                        else
                        {
                            rowObject.put( cursor.getColumnName(i) ,  "" );
                        }
                    }
                    catch( Exception e )
                    {
                        Log.d("TAG_NAME", e.getMessage()  );
                    }
                }
            }
            resultSet.put(rowObject);
            cursor.moveToNext();
        }
        cursor.close();
        Log.d("TAG_NAME", resultSet.toString());
        JSONObject obj = new JSONObject();
        try {
            obj.put(TABLE_NAME_form_1, resultSet);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return obj.toString();
    }

*/
    //Create one row for person
    public void addDataType(String jsonstring) throws JSONException {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues valuesword = new ContentValues();

        JSONObject jsonObj = new JSONObject(jsonstring);

        try
        {
            // Extract data from json and store into ArrayList as class objects
            for(int i=1;i<=jsonObj.length();i++){
                JSONObject json_data = jsonObj.getJSONObject(Integer.toString(i));
                valuesword.put(type_COLUMN_NAME, json_data.getString("name"));
                db.insert(TABLE_NAME_car_type, null, valuesword);
            }

            db.close();
        }
        catch (Exception e)
        {
            db.close();
        }
    }
    public void addDataBrand(String jsonstring) throws JSONException {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues valuesword = new ContentValues();

        JSONObject jsonObj = new JSONObject(jsonstring);

        try
        {
            // Extract data from json and store into ArrayList as class objects
            for(int i=1;i<=jsonObj.length();i++){
                JSONObject json_data = jsonObj.getJSONObject(Integer.toString(i));
                valuesword.put(brand_COLUMN_ID_FACTORY, json_data.getString(brand_COLUMN_ID_FACTORY));
                valuesword.put(brand_COLUMN_BRANDNAME, json_data.getString(brand_COLUMN_BRANDNAME));
                db.insert(TABLE_NAME_barand, null, valuesword);
            }

            db.close();
        }
        catch (Exception e)
        {
            db.close();
        }
    }
    public void addDataCarChina(String jsonstring) throws JSONException {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues valuesword = new ContentValues();

        JSONObject jsonObj = new JSONObject(jsonstring);

        try
        {
            // Extract data from json and store into ArrayList as class objects
            for(int i=1;i<=jsonObj.length();i++){
                JSONObject json_data = jsonObj.getJSONObject(Integer.toString(i));
                valuesword.put(china_COLUMN_NAME, json_data.getString(china_COLUMN_NAME));
                db.insert(TABLE_NAME_china, null, valuesword);
            }

            db.close();
        }
        catch (Exception e)
        {
            db.close();
        }
    }

    public void addDataCarExport(String jsonstring) throws JSONException {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues valuesword = new ContentValues();

        JSONObject jsonObj = new JSONObject(jsonstring);

        try
        {
            // Extract data from json and store into ArrayList as class objects
            for(int i=1;i<=jsonObj.length();i++){
                JSONObject json_data = jsonObj.getJSONObject(Integer.toString(i));
                valuesword.put(carexport_COLUMN_NAME, json_data.getString(carexport_COLUMN_NAME));
                db.insert(TABLE_NAME_carexport, null, valuesword);
            }

            db.close();
        }
        catch (Exception e)
        {
            db.close();
        }
    }
    public void addDataCarFactory(String jsonstring) throws JSONException {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues valuesword = new ContentValues();

        JSONObject jsonObj = new JSONObject(jsonstring);

        try
        {
            // Extract data from json and store into ArrayList as class objects
            for(int i=1;i<=jsonObj.length();i++){
                JSONObject json_data = jsonObj.getJSONObject(Integer.toString(i));
                valuesword.put(factory_COLUMN_NAME, json_data.getString(factory_COLUMN_NAME));

                db.insert(TABLE_NAME_carfactory, null, valuesword);
            }

            db.close();
        }
        catch (Exception e)
        {
            db.close();
        }
    }
    public void addDataCarModel(String jsonstring) throws JSONException {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues valuesword = new ContentValues();

        JSONObject jsonObj = new JSONObject(jsonstring);

        try
        {
            // Extract data from json and store into ArrayList as class objects
            for(int i=1;i<=jsonObj.length();i++){
                JSONObject json_data = jsonObj.getJSONObject(Integer.toString(i));
                valuesword.put(model_COLUMN_id_fac, json_data.getString(china_COLUMN_NAME));
                valuesword.put(model_COLUMN_id_bra, json_data.getString(model_COLUMN_id_fac));
                valuesword.put(model_COLUMN_NAME, json_data.getString(model_COLUMN_NAME));
                db.insert(TABLE_NAME_model, null, valuesword);
            }

            db.close();
        }
        catch (Exception e)
        {
            db.close();
        }
    }
    public void addDataCarTip(String jsonstring) throws JSONException {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues valuesword = new ContentValues();

        JSONObject jsonObj = new JSONObject(jsonstring);

        try
        {
            // Extract data from json and store into ArrayList as class objects
            for(int i=1;i<=jsonObj.length();i++){
                JSONObject json_data = jsonObj.getJSONObject(Integer.toString(i));
                valuesword.put(tip_COLUMN_id_fac, json_data.getString(tip_COLUMN_id_fac));
                valuesword.put(tip_COLUMN_id_bra, json_data.getString(tip_COLUMN_id_bra));
                valuesword.put(tip_COLUMN_id_mod, json_data.getString(tip_COLUMN_id_mod));
                valuesword.put(tip_COLUMN_NAME, json_data.getString(tip_COLUMN_NAME));
                valuesword.put(tip_COLUMN_id_type, json_data.getString(tip_COLUMN_id_type));
                valuesword.put(tip_COLUMN_id_export, json_data.getString(tip_COLUMN_id_export));
                valuesword.put(tip_COLUMN_id_china, json_data.getString(tip_COLUMN_id_china));
                valuesword.put(tip_COLUMN_min_p, json_data.getString(tip_COLUMN_min_p));
                valuesword.put(tip_COLUMN_max_p, json_data.getString(tip_COLUMN_max_p));
                db.insert(TABLE_NAME_tip, null, valuesword);
            }

            db.close();
        }
        catch (Exception e)
        {
            db.close();
        }
    }







    //show one row in table for view
    public List<String> viewOneRowType(){
        //Select All Query
        List<String> list = new ArrayList<String>();
        type_model da = new type_model();

        String selectQuery = "SELECT  *  FROM "+TABLE_NAME_car_type +" ;";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);//selectQuery,selectedArguments
        Integer count=0;
        count = cursor.getCount();
        //list.add(Integer.toString(cursor.getCount()));

        while (cursor.moveToNext()) {

            list.add(cursor.getString(0)+"#%"+cursor.getString(1));
        }


        cursor.close();
        db.close();
        return list;
    }


    public List<String> viewOneRowBrand(int tip){
        //Select All Query
        List<String> list = new ArrayList<String>();
        type_model da = new type_model();

        String selectQuery = "SELECT  *  FROM "+TABLE_NAME_tip +"WHERE id ="+ tip+";";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);//selectQuery,selectedArguments
        Integer count=0;
        count = cursor.getCount();
        //list.add(Integer.toString(cursor.getCount()));

        while (cursor.moveToNext()) {

            list.add(cursor.getString(0)+"#%"+cursor.getString(1)+"#%"+cursor.getString(2));
        }


        cursor.close();
        db.close();
        return list;
    }
	
	
	
	    public List<String> viewOneRowFactory(){
        //Select All Query
        List<String> list = new ArrayList<String>();
        type_model da = new type_model();

        String selectQuery = "SELECT  *  FROM "+TABLE_NAME_carfactory +";";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);//selectQuery,selectedArguments
        Integer count=0;
        count = cursor.getCount();
        //list.add(Integer.toString(cursor.getCount()));

        while (cursor.moveToNext()) {

            list.add(cursor.getString(0)+"#%"+cursor.getString(1));
        }


        cursor.close();
        db.close();
        return list;
    }


/*

    //Create one row for person
    public void addDataBrand() {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues valuesword = new ContentValues();
        try
        {
            //valuesword.put("id", "");
            valuesword.put( BCOLUMN_ID_FACTORY , "");
            valuesword.put( BCOLUMN_NAME , "");

            db.insert(TABLE_NAME_brand, null, valuesword);
            db.close();
        }
        catch (Exception e)
        {
            db.close();
        }
    }

    //Create one row for person
    public void addDataCar() {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues valuesword = new ContentValues();
        try
        {
            //valuesword.put("id", "");
            valuesword.put( BCOLUMN_ID_FACTORY , "");
            valuesword.put(BCOLUMN_NAME, "");

            db.insert(TABLE_NAME_brand, null, valuesword);
            db.close();
        }
        catch (Exception e)
        {
            db.close();
        }
    }*/


}

