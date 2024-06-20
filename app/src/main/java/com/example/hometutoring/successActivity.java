package com.example.hometutoring;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import static com.example.hometutoring.R.layout.activity_main_fragment;

/**
 * 通过切换选项控制页面更新
 * @author
 * @create
 */
public class successActivity extends FragmentActivity {

    private MainFragment mainFragment;
    private MoodFragment moodFragment;
    private MessageFragment messageFragment;
    private PersonFragment personFragment;

    private int currentId = R.id.tv_main;

    private TextView tvMain, tvMood, tvMessage, tvPerson;


    //index
    private Button benan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

        // 首页标签默认选中
        tvMain = (TextView) findViewById(R.id.tv_main);
        tvMain.setSelected(true);
        tvMood = (TextView) findViewById(R.id.tv_mood);
        tvMessage = (TextView) findViewById(R.id.tv_message);
        tvPerson = (TextView) findViewById(R.id.tv_person);

        //App启动的时候加载首页页面
        mainFragment = new MainFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.main_container, mainFragment).commit();

        tvMain.setOnClickListener(tabClickListener);
        tvMood.setOnClickListener(tabClickListener);
        tvMessage.setOnClickListener(tabClickListener);
        tvPerson.setOnClickListener(tabClickListener);
    }


//private  OnClickListener onClickListener =new OnClickListener() {
//    @Override
//    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.an:
//                Intent intent = new Intent(successActivity.this, textActivity.class);
//                startActivity(intent);
//                break;
//        }
//    }
//};



    /**
     * 通过单击事件调用对应方法改变TextView的状态和fragment
     * 更新当前项的id（主要根据id标记当前项的位置）
     */
    private OnClickListener tabClickListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.getId() != currentId) {
                changeSelect(v.getId());
                changeFragment(v.getId());
                currentId = v.getId();
            }

        }
    };

    /**
     * 切换fragment方法
     * @param resId
     */
    private void changeFragment(int resId) {
        FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction();

        //调用方法隐藏fragment
        hideFragments(transaction);

        //声明fragment并且添加到页面
        if (resId == R.id.tv_main) {
            if (mainFragment == null) {
                mainFragment = new MainFragment();
                transaction.add(R.id.main_container, mainFragment);
            } else {
                transaction.show(mainFragment);
            }
        } else if (resId == R.id.tv_mood) {
            if (moodFragment == null) {
                moodFragment = new MoodFragment();
                transaction.add(R.id.main_container, moodFragment);
            } else {
                transaction.show(moodFragment);
            }
        } else if (resId == R.id.tv_message) {
            if (messageFragment == null) {
                messageFragment = new MessageFragment();
                transaction.add(R.id.main_container, messageFragment);
            } else {
                transaction.show(messageFragment);
            }
        } else if (resId == R.id.tv_person) {
            if (personFragment == null) {
                personFragment = new PersonFragment();
                transaction.add(R.id.main_container, personFragment);
            } else {
                transaction.show(personFragment);
            }
        }
        transaction.commit();
    }

    /**
     * 点击事件隐藏所有fragment
     * @param transaction
     */
    private void hideFragments(FragmentTransaction transaction) {
        if (mainFragment != null)
            transaction.hide(mainFragment);
        if (moodFragment != null)
            transaction.hide(moodFragment);
        if (messageFragment != null)
            transaction.hide(messageFragment);
        if (personFragment != null)
            transaction.hide(personFragment);
    }

    /**
     * 单击事件改变textview的状态
     * @param resId
     */
    private void changeSelect(int resId) {

        //选项全部设置为未选中
        tvMain.setSelected(false);
        tvMood.setSelected(false);
        tvMessage.setSelected(false);
        tvPerson.setSelected(false);

        //切换选中项的状态
        switch (resId) {
            case R.id.tv_main:
                tvMain.setSelected(true);
                break;
            case R.id.tv_mood:
                tvMood.setSelected(true);
                break;
            case R.id.tv_message:
                tvMessage.setSelected(true);
                break;
            case R.id.tv_person:
                tvPerson.setSelected(true);
                break;
        }
    }
}
