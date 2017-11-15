package com.example.client1.progressdemotwo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by client1 on 11/10/2017.
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    CustomProgressDia mProgressDialog;
    Button b;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b=(Button)findViewById(R.id.button);
        b.setOnClickListener(this);

        mProgressDialog = new CustomProgressDia(this);

    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.button:
                mProgressDialog.show();
        }
    }
}
