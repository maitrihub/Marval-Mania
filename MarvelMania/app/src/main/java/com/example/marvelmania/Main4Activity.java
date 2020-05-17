package com.example.marvelmania;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Main4Activity extends AppCompatActivity {

    String you;
    ImageView hero, villan;
    TextView textView1, textView2;
    boolean villanFly=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);

        textView1.setVisibility(View.INVISIBLE);
        textView2.setVisibility(View.INVISIBLE);

        hero = findViewById(R.id.imageView1);
        villan = findViewById(R.id.imageView2);


        Bundle extras = getIntent().getExtras();
        if(extras !=null) {
            you = extras.getString("you");
        }

        switch(you){
            case "thor": {
                hero.setImageResource(R.drawable.thor);
                villan.setImageResource(R.drawable.loki);
                break;
            }
            case "redskull": {
                hero.setImageResource(R.drawable.redskull);
                villan.setImageResource(R.drawable.captainamerica);
                break;
            }
            case "blackpanther": {
                hero.setImageResource(R.drawable.blackpanther);
                villan.setImageResource(R.drawable.erikkillmonger);
                break;
            }
            case "blackwidow": {
                hero.setImageResource(R.drawable.blackwidow);
                villan.setImageResource(R.drawable.taskmaster);
                break;
            }
            case "captainamerica": {
                hero.setImageResource(R.drawable.captainamerica);
                villan.setImageResource(R.drawable.redskull);
                break;
            }
            case "erikkillmonger": {
                hero.setImageResource(R.drawable.erikkillmonger);
                villan.setImageResource(R.drawable.blackpanther);
                break;
            }
            case "hulk": {
                hero.setImageResource(R.drawable.hulk);
                villan.setImageResource(R.drawable.ultron);
                break;
            }
            case "ironman": {
                hero.setImageResource(R.drawable.ironman);
                villan.setImageResource(R.drawable.thanos);
                break;
            }
            case "kingpen": {
                hero.setImageResource(R.drawable.kingpen);
                villan.setImageResource(R.drawable.spiderman);
                break;
            }
            case "loki": {
                hero.setImageResource(R.drawable.loki);
                villan.setImageResource(R.drawable.thor);
                break;
            }
            case "skrulls": {
                hero.setImageResource(R.drawable.skrulls);
                villan.setImageResource(R.drawable.captainmarvel);
                break;
            }
            case "spiderman": {
                hero.setImageResource(R.drawable.spiderman);
                villan.setImageResource(R.drawable.kingpen);
                break;
            }
            case "taskmaster": {
                hero.setImageResource(R.drawable.taskmaster);
                villan.setImageResource(R.drawable.blackwidow);
                break;
            }
            case "thanos": {
                hero.setImageResource(R.drawable.thanos);
                villan.setImageResource(R.drawable.ironman);
                break;
            }
            case "ultron": {
                hero.setImageResource(R.drawable.ultron);
                villan.setImageResource(R.drawable.hulk);
                break;
            }
            case "captainmarvel": {
                hero.setImageResource(R.drawable.captainmarvel);
                villan.setImageResource(R.drawable.skrulls);
                break;
            }
        }

        final RelativeLayout rlayout = (RelativeLayout) findViewById(R.id.mainLayout);
        rlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //System.out.println("CLICKED");

                /*final ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f, 1.0f, 0.8f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                scaleAnimation.setDuration(1000);
                hero.startAnimation(scaleAnimation);*/

                //TranslateAnimation translateAnimation=new TranslateAnimation(0,0,0,-25);
                //translateAnimation.setDuration(500);
                //hero.startAnimation(translateAnimation);
                hero.setY(hero.getY()-25);
                TranslateAnimation translateAnimation2;
                //hero.setY(-50);

                if (!villanFly) {
                    translateAnimation2 = new TranslateAnimation(0, 0, -100, -1220);
                    translateAnimation2.setDuration(8000);
                    villan.startAnimation(translateAnimation2);
                    villanFly=true;
                }

                if (hero.getY()<=0){
                    hero.setVisibility(View.INVISIBLE);
                    villan.setVisibility(View.INVISIBLE);
                    textView1.setVisibility(View.VISIBLE);
                    textView2.setVisibility(View.VISIBLE);
                    rlayout.setBackgroundColor(Color.BLACK);
                    rlayout.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            startActivity(new Intent(Main4Activity.this, MainActivity.class));
                        }
                    });
                }

               System.out.println(villan.getY());

                /*Handler handler = new Handler();

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Do something after 5s = 5000ms
                        float y=hero.getY()-250;
                        while (hero.getY()>=y) {
                            hero.setY(hero.getY() - 25);
                            System.out.println("print");

                        }

                    }
                }, 5000);

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Do something after 5s = 5000ms
                        float y=hero.getY()-500;
                        while (hero.getY()>=y) {
                            hero.setY(hero.getY() - 25);
                            System.out.println("print");

                        }

                    }
                }, 5000);*/

            }
        });



        System.out.println("this is you: "+you);


    }
}
