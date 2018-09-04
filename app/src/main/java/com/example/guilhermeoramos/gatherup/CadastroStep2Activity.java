package com.example.guilhermeoramos.gatherup;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import in.goodiebag.carouselpicker.CarouselPicker;

public class CadastroStep2Activity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_step2);
        testCarouselPicker();
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        if (hasFocus) {
            TextView textView = findViewById(R.id.btncontinuar);
            textView.startAnimation(AnimationUtils.loadAnimation(CadastroStep2Activity.this, R.anim.slide_left_center));
        }
    }

    @Override
    public void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
    }

    CarouselPicker carouselPicker1;

    public void testCarouselPicker(){
        carouselPicker1 = findViewById(R.id.carouselPicker1);

        //Carousel 2 with all images
        List<CarouselPicker.PickerItem> textItems = new ArrayList<>();
        textItems.add(new CarouselPicker.TextItem("1", 30));
        textItems.add(new CarouselPicker.TextItem("2", 30));
        textItems.add(new CarouselPicker.TextItem("3", 30));
        textItems.add(new CarouselPicker.TextItem("4", 30));
        textItems.add(new CarouselPicker.TextItem("5", 30));
        textItems.add(new CarouselPicker.TextItem("6", 30));
        textItems.add(new CarouselPicker.TextItem("7", 30));
        textItems.add(new CarouselPicker.TextItem("8", 30));
        textItems.add(new CarouselPicker.TextItem("9", 30));
        textItems.add(new CarouselPicker.TextItem("10", 30));
        textItems.add(new CarouselPicker.TextItem("11", 30));
        textItems.add(new CarouselPicker.TextItem("12", 30));
        textItems.add(new CarouselPicker.TextItem("13", 30));
        textItems.add(new CarouselPicker.TextItem("14", 30));
        textItems.add(new CarouselPicker.TextItem("15", 30));
        CarouselPicker.CarouselViewAdapter textAdapter = new CarouselPicker.CarouselViewAdapter(this,textItems, 0);
        carouselPicker1.setAdapter(textAdapter);
    }

//    private void setFont(){
//        TextView textView = (TextView) findViewById(R.id.title_step2);
//        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/zillah-modern-ouline.ttf");
//        textView.setTypeface(typeface);
//    }
}
