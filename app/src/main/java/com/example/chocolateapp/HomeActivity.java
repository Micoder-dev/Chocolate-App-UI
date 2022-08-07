package com.example.chocolateapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.chocolateapp.adapter.ChocolateAdapter;
import com.example.chocolateapp.model.Chocolate;
import com.gigamole.infinitecycleviewpager.HorizontalInfiniteCycleViewPager;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.shape.CornerFamily;
import com.google.android.material.shape.MaterialShapeDrawable;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private MaterialToolbar mToolBar;

    RelativeLayout relativeMain;

    HorizontalInfiniteCycleViewPager viewPager;
    List<Chocolate> listCoffee = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mToolBar = (MaterialToolbar) findViewById(R.id.main_page_toolbar);
        setSupportActionBar(mToolBar);

        float radius = getResources().getDimension(com.shashank.sony.fancywalkthroughlib.R.dimen.activity_half_margin);
        MaterialShapeDrawable toolbarBackground = (MaterialShapeDrawable) mToolBar.getBackground();
        toolbarBackground.setShapeAppearanceModel(
                toolbarBackground.getShapeAppearanceModel()
                        .toBuilder()
                        .setBottomRightCorner(CornerFamily.ROUNDED,radius)
                        .setBottomLeftCorner(CornerFamily.ROUNDED,radius)
                        .build()
        );

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);

        LayoutInflater layoutInflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View actionBarView = layoutInflater.inflate(R.layout.custom_app_bar, null);
        actionBar.setCustomView(actionBarView);

        //infiniteSwipeVP
        viewPager=findViewById(R.id.view_pager);
        relativeMain=findViewById(R.id.relative_home);

        initData();

        ChocolateAdapter adapter=new ChocolateAdapter(this,listCoffee);
        viewPager.setAdapter(adapter);

        viewPager.setVisibility(View.VISIBLE);

    }

    private void initData() {
        listCoffee.add(new Chocolate("DairyMilk Silk", "DairyMilk", getString(R.string.diarymilk), R.drawable.dairymilk_logo, R.drawable.choco_card_bg, R.drawable.choco_fall, Color.parseColor("#2d181c")));
        listCoffee.add(new Chocolate("KitKat", "Kit Kat", getString(R.string.kitkat), R.drawable.kitkat_logo, R.drawable.choco_card_bg, R.drawable.choco_fall, Color.parseColor("#5d6d1b")));
        listCoffee.add(new Chocolate("5 Star", "5Star", getString(R.string.fivestar), R.drawable.fivestar_logo, R.drawable.choco_card_bg, R.drawable.choco_fall, Color.parseColor("#b38868")));

    }
}