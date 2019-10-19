package com.alyndroid.architecturepatternstutorialshomework.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alyndroid.architecturepatternstutorialshomework.Data.DataBase;
import com.alyndroid.architecturepatternstutorialshomework.Data.NumberModel;
import com.alyndroid.architecturepatternstutorialshomework.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements NumbersView {

    @BindView(R.id.div_result_textView)
    TextView div_result;
    @BindView(R.id.plus_button)
    Button plus;
    @BindView(R.id.plus_result_textView)
    TextView plus_result;
    @BindView(R.id.div_button)
    Button div;
    @BindView(R.id.mul_result_textView)
    TextView mul_result;
    @BindView(R.id.mul_button)
    Button mul;

    DataBase dataBase = new DataBase();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //mvc
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                plus_result.setText(String.valueOf(getData()));
            }
        });


        //mvp
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NumbersPresenter presenter = new NumbersPresenter(MainActivity.this);
                presenter.getData(dataBase.getNumbers().getFirstNum(), dataBase.getNumbers().getSecondNum());
            }
        });

        //mvvm
        final NumbersViewModel model = ViewModelProviders.of(this).get(NumbersViewModel.class);
        model.getLiveData().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                mul_result.setText(String.valueOf(integer));
            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model.getNumbers(dataBase.getNumbers().getFirstNum(), dataBase.getNumbers().getSecondNum());
            }
        });
    }

    private int getData() {
        NumberModel numbers = dataBase.getNumbers();
        int num1 = numbers.getFirstNum();
        int num2 = numbers.getSecondNum();
        return num1 + num2;
    }


    @Override
    public void onDataFound(int number) {
        div_result.setText(String.valueOf(number));
    }
}
