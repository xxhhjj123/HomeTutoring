package com.example.hometutoring;

import com.example.hometutoring.R;

import android.content.Intent;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MoodFragment extends Fragment {
    private  TextView btn_mood_yuwen;
    private  TextView btn_mood_shuxue;
    private  TextView btn_mood_yingyu;
    private  TextView btn_mood_wuli;
    private  TextView btn_mood_huaxue;
    private  TextView btn_mood_zhengzhi;
    private  TextView btn_mood_dili;
    private  TextView btn_mood_shengwu;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        return inflater.inflate(R.layout.activity_mood_fragment, container, false);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        TextView btn_mood_yuwen=(TextView)getActivity().findViewById(R.id.mood_yuwen);
        TextView btn_mood_shuxue=(TextView)getActivity().findViewById(R.id.mood_shuxu);
        TextView btn_mood_yingyu=(TextView)getActivity().findViewById(R.id.mood_yingyu);
        TextView btn_mood_wuli=(TextView)getActivity().findViewById(R.id.mood_wuli);
        TextView btn_mood_zhengzhi=(TextView)getActivity().findViewById(R.id.mood_zhengzhi);
        TextView btn_mood_shengwu=(TextView)getActivity().findViewById(R.id.mood_shengwu);
        TextView btn_mood_huaxue=(TextView)getActivity().findViewById(R.id.mood_huaxue);
        TextView btn_mood_dili=(TextView)getActivity().findViewById(R.id.mood_dili);

        btn_mood_yuwen.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"天行健，君子以自强不息！",Toast.LENGTH_LONG).show();
            }
        });

        btn_mood_shuxue.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"数学，是科学的女皇，数论，是数学的女皇！",Toast.LENGTH_LONG).show();
            }
        });

        btn_mood_yingyu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"For man is man and master of his fate. 人就是人，是自己命运的主人。",Toast.LENGTH_LONG).show();
            }
        });

        btn_mood_wuli.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"物理定律不能单靠“思维”来获得，还应致力于观察和实验。",Toast.LENGTH_LONG).show();
            }
        });

        btn_mood_zhengzhi.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"政治是一种科学,是一种艺术。",Toast.LENGTH_LONG).show();
            }
        });

        btn_mood_shengwu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"物竞天择,适者生存!",Toast.LENGTH_LONG).show();
            }
        });

        btn_mood_huaxue.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"化学家需要精细，必须杜绝含糊其词的“about”！",Toast.LENGTH_LONG).show();
            }
        });

        btn_mood_dili.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"高岸为谷，深谷为陵。",Toast.LENGTH_LONG).show();
            }
        });


    }

}

