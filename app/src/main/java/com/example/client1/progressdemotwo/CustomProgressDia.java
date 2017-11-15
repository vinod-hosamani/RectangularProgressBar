package com.example.client1.progressdemotwo;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;

public class CustomProgressDia extends ProgressDialog
{
    ImageView outerRingClock;
    ImageView innerRingAntiClock;

    Context context;

    Animation clockAnimation;
    Animation aniClockAnimation;
    ImageView rays;

    public CustomProgressDia(Context context)
    {
        super(context, android.R.style.Theme_Dialog);
        this.context = context;

    }
    public void initView()
    {
        outerRingClock=(ImageView)findViewById(R.id.outerRingClock);
        innerRingAntiClock=(ImageView)findViewById(R.id.innerRingAntiClock);
        rays=(ImageView)findViewById(R.id.raysId);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_dialog_layout);
        //  ButterKnife.bind(this);
        clockAnimation = AnimationUtils.loadAnimation(context, R.anim.fadein);
        aniClockAnimation = AnimationUtils.loadAnimation(context, R.anim.fadein);
        clockAnimation.setRepeatMode(Animation.INFINITE);
        aniClockAnimation.setRepeatMode(Animation.INFINITE);
        getWindow().setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        initView();
    }
    @Override
    public void show()
    {
        super.show();
        rays.setAnimation(clockAnimation);
        innerRingAntiClock.setAnimation(aniClockAnimation);
    }
    @Override
    public void dismiss()
    {
        super.dismiss();
//        outerRingClock.clearAnimation();
//        innerRingAntiClock.clearAnimation();
    }
    private Animation fadInAnimation()
    {
        Animation fadeIn = new AlphaAnimation(0, 1);
        fadeIn.setInterpolator(new DecelerateInterpolator()); //add this
        fadeIn.setDuration(500);
        return fadeIn;
    }
}
