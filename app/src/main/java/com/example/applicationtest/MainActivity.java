package com.example.applicationtest;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private  double bmi;
    private  String bmiStr;
    private Button cbutton ;
    private EditText bmiheight;
    private EditText bmiweight;
    private TextView WHOText;
    private TextView YZText;
    private TextView CNText;
    private CheckBox WHOCheck;
    private CheckBox YZCheck;
    private CheckBox CNCheck;
    public DecimalFormat df = new DecimalFormat("#.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    /**
     * 菜单选择下拉
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }


    /**
     * 菜单中每个熟悉设置
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.add_item:
                Toast.makeText(this, "this is add", Toast.LENGTH_LONG).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this, "this is remove", Toast.LENGTH_SHORT).show();
                break;
            case  R.id.update_item:
                Toast.makeText(this, "this is update", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * 初始化视图
     */
    public void initView(){
        //获取资源空间
        cbutton =  findViewById(R.id.CButton);
        bmiheight = findViewById(R.id.BMIHeght);
        bmiweight = findViewById(R.id.BMIWeight);
        WHOCheck = findViewById(R.id.WHOCheck);
        YZCheck = findViewById(R.id.YZChek);
        CNCheck = findViewById(R.id.CNCheck);

        WHOText = findViewById(R.id.WHOText);
        YZText = findViewById(R.id.YZText);
        CNText = findViewById(R.id.CNText);
        //为按钮对象添加监听器
        cbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this, "hello activity", Toast.LENGTH_LONG).show();

                //显示添加意图Intent

                //获取输入框中的内容
                double height = Double.parseDouble(bmiheight.getText().toString());
                double weight = Double.parseDouble(bmiweight.getText().toString());
                bmiStr =  df.format( weight/(height*height));
                bmi = Double.parseDouble(bmiStr);
                String  message = "";


                //判断复选框 输出内容
                if (WHOCheck.isChecked()){
                    if (bmi < 18.5){
                        message = "体重过低";
                    }else if (bmi>= 18.5 && bmi <25){
                        message = "正常范围";
                    }else if (bmi >= 25 && bmi < 30){
                        message = "超重";
                    }else if (bmi >= 30 && bmi < 35 ){
                        message = "Ⅰ度肥胖";
                    }else if (bmi >= 35 && bmi < 40 ){
                        message = "ⅠⅠ度肥胖";
                    }else if (bmi >= 40 ){
                        message = "ⅠⅠⅠ度肥胖";
                    }

                System.out.println(df.format( weight/(height*height)));
                WHOText.setTextColor(Color.RED);
                WHOText.setText("WHO 标准 \n"+"BMI:"+bmiStr+"\n"+message+"\n");
            }


                if (YZCheck.isChecked()){
                    if (bmi < 18.5){
                        message = "体重过低";
                    }else if (bmi>= 18.5 && bmi <23){
                        message = "正常范围";
                    }else if (bmi >= 23 && bmi < 25){
                        message = "超重";
                    }else if (bmi >= 25 && bmi < 30 ){
                        message = "Ⅰ度肥胖";
                    }else if (bmi >= 30 && bmi < 40 ){
                        message = "ⅠⅠ度肥胖";
                    }else if (bmi >= 40 ){
                        message = "ⅠⅠⅠ度肥胖";
                    }

                    System.out.println(df.format( weight/(height*height)));
                    YZText.setTextColor(Color.GREEN);
                    YZText.setText("亚洲 标准 \n"+"BMI:"+bmiStr+"\n"+message+"\n");
                }


                if (CNCheck.isChecked()){
                    if (bmi < 18.5){
                        message = "体重过低";
                    }else if (bmi>= 18.5 && bmi <24){
                        message = "正常范围";
                    }else if (bmi >= 24 && bmi < 28){
                        message = "超重";
                    }else if (bmi >= 28 && bmi < 30 ){
                        message = "Ⅰ度肥胖";
                    }else if (bmi >= 30 && bmi < 40 ){
                        message = "ⅠⅠ度肥胖";
                    }else if (bmi >= 40 ){
                        message = "ⅠⅠⅠ度肥胖";
                    }

                    System.out.println(df.format( weight/(height*height)));
                    CNText.setTextColor(Color.YELLOW);
                    CNText.setText("中国 标准 \n"+"BMI:"+bmiStr+"\n"+message+"\n");
                }



            }
        });
    }
}