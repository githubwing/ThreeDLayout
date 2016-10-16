package com.wingsofts.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.wingsofts.threedlayout.ThreeDLayout;
import java.util.ArrayList;
import java.util.List;

public class WeatherActivity extends AppCompatActivity {
  RecyclerView recyclerView;
  private Adapter adapter;
  private boolean flag = true;
  List<String> list = new ArrayList<>();

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_weather);
    recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
    list.add("周日");
    list.add("周一");
    list.add("周二");
    list.add("周三");
    list.add("周四");
    list.add("周五");
    list.add("周六");

    adapter = new Adapter(list);
    recyclerView.setAdapter(adapter);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));

    ThreeDLayout layout = (ThreeDLayout) findViewById(R.id.td_header);

    layout.setTouchable(true);

    layout.setTouchMode(ThreeDLayout.MODE_BOTH_X_Y);


  }
  public void onClick(View v){

    ThreeDLayout layout = (ThreeDLayout) findViewById(R.id.td_header);
    if(!flag){
      flag = true;
      ((TextView)findViewById(R.id.textView)).setText("72℉");
    }else {
      flag = false;

      ((TextView)findViewById(R.id.textView)).setText("30℃");
    }
    layout.startHorizontalAnimate(1000);


    for(int i = 0;i<list.size();i++){
      ((ThreeDLayout)recyclerView.getChildAt(i)).startHorizontalAnimateDelayed(100*i,1000);
    }

  }


  class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
    List<String> list;

    public Adapter(List<String> list) {
      this.list = list;
    }

    @Override public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      return new MyViewHolder(
          LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main, parent, false));
    }

    @Override public void onBindViewHolder(Adapter.MyViewHolder holder, int position) {
      holder.textView.setText(list.get(position));

    }

    @Override public int getItemCount() {
      return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
      TextView textView;
      TextView temperatureTxt;
      MyViewHolder(View itemView) {
        super(itemView);
        textView = (TextView) itemView.findViewById(R.id.textView);
        temperatureTxt = (TextView) itemView.findViewById(R.id.tv_temperature);

      }
    }
  }
}
