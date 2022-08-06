package com.example.chocolateapp;

import android.os.Bundle;
import android.widget.Toast;

import com.shashank.sony.fancywalkthroughlib.FancyWalkthroughActivity;
import com.shashank.sony.fancywalkthroughlib.FancyWalkthroughCard;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FancyWalkthroughActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FancyWalkthroughCard fancywalkthroughCard1 = new FancyWalkthroughCard("Find Choco's", "Find your favourite chocolates inside your hand.", R.drawable.chocolate_logo2);
        FancyWalkthroughCard fancywalkthroughCard2 = new FancyWalkthroughCard("Pick the best", "Pick the right candies using trusted ratings and reviews.", R.drawable.chocolate_logo1);
        FancyWalkthroughCard fancywalkthroughCard3 = new FancyWalkthroughCard("Choose your brand", "Easily find the type of candy you're looking for.", R.drawable.chocolate_logo3);
        FancyWalkthroughCard fancywalkthroughCard4 = new FancyWalkthroughCard("Choco's on the way", "Get ready and comfortable while our biker bring your choco's at your door.", R.drawable.chocolate_logo4);

        fancywalkthroughCard1.setBackgroundColor(R.color.white);
        fancywalkthroughCard1.setIconLayoutParams(500, 500, 0, 0, 0, 0);
        fancywalkthroughCard1.setDisplaySkip(true);
        fancywalkthroughCard2.setBackgroundColor(R.color.white);
        fancywalkthroughCard2.setIconLayoutParams(350, 350, 0, 0, 0, 0);
        fancywalkthroughCard2.setDisplaySkip(true);
        fancywalkthroughCard3.setBackgroundColor(R.color.white);
        fancywalkthroughCard3.setIconLayoutParams(450, 450, 0, 0, 0, 0);
        fancywalkthroughCard3.setDisplaySkip(true);
        fancywalkthroughCard4.setBackgroundColor(R.color.white);
        fancywalkthroughCard4.setIconLayoutParams(600, 600, 0, 0, 0, 0);
        fancywalkthroughCard4.setDisplaySkip(true);
        List<FancyWalkthroughCard> pages = new ArrayList<>();

        pages.add(fancywalkthroughCard1);
        pages.add(fancywalkthroughCard2);
        pages.add(fancywalkthroughCard3);
        pages.add(fancywalkthroughCard4);

        for (FancyWalkthroughCard page : pages) {
            page.setTitleColor(R.color.black);
            page.setDescriptionColor(R.color.black);
        }
        setFinishButtonTitle("Get Started");
        showNavigationControls(true);
        setImageBackground(R.drawable.chocolate_walkthrough);
        setInactiveIndicatorColor(R.color.grey);
        setActiveIndicatorColor(R.color.green);
        setOnboardPages(pages);

    }

    @Override
    public void onFinishButtonPressed() {
        Toast.makeText(this, "Finish Pressed", Toast.LENGTH_SHORT).show();

    }
}