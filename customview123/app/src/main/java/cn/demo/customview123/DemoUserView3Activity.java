package cn.demo.customview123;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import cn.demo.customview123.userview.DrawCircle03;

public class DemoUserView3Activity extends Activity {
	DrawCircle03  mDrawCircle;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_demo_userview3);
		
		mDrawCircle=(DrawCircle03) findViewById(R.id.drawCircle1);
		mDrawCircle.setOnTouchListener(new View.OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
			    // 获取触摸点在组件内的坐标，并改变小球的坐标
				mDrawCircle.setmCircleX(event.getX());
				mDrawCircle.setmCircleY(event.getY());
                // 通知draw组件重绘
				mDrawCircle.invalidate();
                //返回true表明被触摸事件被本组件消费了
                return true;				
			}
		});
	}


}
