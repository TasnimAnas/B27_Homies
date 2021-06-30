package com.TasnimAnas.b27_homies;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ShowUpActivity extends AppCompatActivity {

    private Button homeBtn;
    private TextView roll;
    private TextView name;
    private TextView country;
    private TextView facebook;
    private TextView insta;
    private TextView Wp;
    private ImageView pic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showup);

        homeBtn = findViewById(R.id.home);
        roll = findViewById(R.id.textView16);
        name = findViewById(R.id.textView19);
        country = findViewById(R.id.textView22);
        facebook = findViewById(R.id.textView28);
        insta = findViewById(R.id.textView31);
        Wp = findViewById(R.id.textView25);
        pic = findViewById(R.id.imageView3);

        NameFetch Nf = new NameFetch();
        ConFetch Cf = new ConFetch();
        FbFetch Ff = new FbFetch();
        InstaFetch If = new InstaFetch();
        com.TasnimAnas.b27_homies.WpFetch Wf = new com.TasnimAnas.b27_homies.WpFetch();


        Bundle extras = getIntent().getExtras();
        String Roll = extras.getString("key");

        roll.setText(Roll);

        String NameS = Nf.Nf(Integer.parseInt(Roll));
        String CountryS = Cf.Cf(Integer.parseInt(Roll));
        String FbS = Ff.Ff(Integer.parseInt(Roll));
        String InstaS = If.If(Integer.parseInt(Roll));
        String wpS = Wf.Wf(Integer.parseInt(Roll));

        name.setText(NameS);
        country.setText(CountryS);
        facebook.setText(FbS);
        insta.setText(InstaS);
        Wp.setText(wpS);

        switch (Integer.parseInt(Roll))
        {
            case 20051762:
                pic.setImageResource(R.drawable.p20051762);
                break;
            case 20051719:
                pic.setImageResource(R.drawable.p20051719);
                break;
            case 20051728:
                pic.setImageResource(R.drawable.p20051728);
                break;
            case 20051815:
                pic.setImageResource(R.drawable.p20051815);
                break;
            case 20051729:
                pic.setImageResource(R.drawable.p20051729);
                break;
            default:
                  pic.setImageResource(R.drawable.defaultpic);

        }

        if (FbS!="Not Found")
        {
            facebook.setMovementMethod(LinkMovementMethod.getInstance());
            facebook.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                    browserIntent.setData(Uri.parse("FbS"));
                    startActivity(browserIntent);
                }
            });
        }
        if (InstaS!="Not Found"){
            insta.setMovementMethod(LinkMovementMethod.getInstance());
            insta.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                    browserIntent.setData(Uri.parse("InstaS"));
                    startActivity(browserIntent);
                }
            });}
        if (wpS!="Not Found"){
            Wp.setMovementMethod(LinkMovementMethod.getInstance());
            Wp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                    browserIntent.setData(Uri.parse("wpS"));
                    startActivity(browserIntent);
                }
            });}


        homeBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v)
            {
                Intent ln = new Intent(ShowUpActivity.this, MainActivity.class);
                startActivity(ln);
            }
        });

    }
}