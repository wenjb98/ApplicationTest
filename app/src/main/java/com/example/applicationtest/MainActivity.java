package com.example.applicationtest;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private  double dmi;
    private Button cbutton ;
    private EditText bmiheight;
    private EditText bmiweight;
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
        cbutton =  findViewById(R.id.CButton);
        bmiheight = findViewById(R.id.BMIHeght);
        bmiweight = findViewById(R.id.BMIWeight);

        //为按钮对象添加监听器
        cbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this, "hello activity", Toast.LENGTH_LONG).show();

                //显示添加意图Intent

                //获取输入框中的内容
                double height = Double.parseDouble(bmiheight.getText().toString());
                double weight = Double.parseDouble(bmiweight.getText().toString());

                System.out.println(df.format( weight/(height*height)));
            }
        });
    }
}