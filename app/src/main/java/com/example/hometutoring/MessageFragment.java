package com.example.hometutoring;

import com.example.hometutoring.R;

import android.content.Intent;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MessageFragment extends Fragment {
    private Button an;
    private TextView btn_order_teacher;
    private  TextView btn_mes_jianyi;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        return inflater.inflate(R.layout.activity_message_fragment, container, false);
    }
    // 想要在fragment中实现监听点击事件，得用onActivity
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        TextView btn_order_teacher=(TextView)getActivity().findViewById(R.id.order_teacher);
        btn_order_teacher.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(getActivity(),mes_order_teacher.class);
                startActivity(intent);
            }
        });

        TextView btn_mes_jianyi=(TextView)getActivity().findViewById(R.id.jianyi);
        btn_mes_jianyi.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(getActivity(),mes_jianyi.class);
                startActivity(intent);
            }
        });

        Button btnan=(Button)getActivity().findViewById(R.id.an);
        btnan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(getActivity(),textActivity.class);
                startActivity(intent);
            }
        });
    }
}



