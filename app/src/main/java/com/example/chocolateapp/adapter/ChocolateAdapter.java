package com.example.chocolateapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.chocolateapp.R;
import com.example.chocolateapp.model.Chocolate;

import java.util.List;

public class ChocolateAdapter extends PagerAdapter {

    private Context context;
    private List<Chocolate> listChocolate;

    public ChocolateAdapter(Context context, List<Chocolate> listChocolate) {
        this.context = context;
        this.listChocolate = listChocolate;
    }

    @Override
    public int getCount() {
        return listChocolate.size();
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return super.getItemPosition(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_chocolates,container,false);

        ImageView ivImage=view.findViewById(R.id.iv_image);
        ImageView ivDecoration=view.findViewById(R.id.iv_decoration);
        TextView tvTitle=view.findViewById(R.id.tv_title);
        TextView tvSubtitle=view.findViewById(R.id.tv_subtitle);
        TextView tvDesc=view.findViewById(R.id.tv_desc);
        RelativeLayout relativeBack=view.findViewById(R.id.relative_back);

        ivImage.setImageResource(listChocolate.get(position).getImage());
        ivDecoration.setImageResource(listChocolate.get(position).getDecoration());
        relativeBack.setBackgroundResource(listChocolate.get(position).getBackground());
        tvTitle.setText(listChocolate.get(position).getTitle());
        tvSubtitle.setText(listChocolate.get(position).getSubTitle());
        tvDesc.setText(listChocolate.get(position).getDescription());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, ""+listChocolate.get(position).getTitle(), Toast.LENGTH_SHORT).show();
            }
        });

        container.addView(view);

        return view;
    }
}
