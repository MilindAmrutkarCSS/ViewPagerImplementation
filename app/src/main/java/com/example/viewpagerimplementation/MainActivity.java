package com.example.viewpagerimplementation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.viewpagerimplementation.FragmentPagerAdapter.NUM_ITEMS;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.viewPager)
    ViewPager viewPager;
    FragmentPagerAdapter fragmentPagerAdapter;
    @BindView(R.id.btnNext)
    Button btnNext;
    @BindView(R.id.btnSkip)
    Button btnSkip;
    @BindView(R.id.viewPagerDots)
    LinearLayout viewPagerDots;

    private ImageView[] imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        fragmentPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(fragmentPagerAdapter);

        generateDots();
        imageView[0].setImageResource(R.drawable.selected_page);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < FragmentPagerAdapter.NUM_ITEMS ; i++) {
                    imageView[i].setImageResource(R.drawable.unselected_page);
                }
                imageView[position].setImageResource(R.drawable.selected_page);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void generateDots() {
        imageView = new ImageView[FragmentPagerAdapter.NUM_ITEMS];

        for (int i = 0; i < NUM_ITEMS; i++) {
            imageView[i] = new ImageView(this);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(5, 0, 5, 0);
            imageView[i].setLayoutParams(layoutParams);
            imageView[i].setImageResource(R.drawable.unselected_page);
            viewPagerDots.addView(imageView[i]);
            viewPagerDots.bringToFront();
        }
    }

    @OnClick({R.id.btnNext, R.id.btnSkip})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnNext:
                //Toast.makeText(this, "Next", Toast.LENGTH_SHORT).show();
                if (viewPager.getCurrentItem() == (NUM_ITEMS - 1)) {
                    Toast.makeText(this, "This is the last one", Toast.LENGTH_SHORT).show();
                } else {
                    viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                }

                break;

            case R.id.btnSkip:
                //Toast.makeText(this, "Skip", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, SecondActivity.class);
                startActivity(intent);
                break;
        }
    }
}
