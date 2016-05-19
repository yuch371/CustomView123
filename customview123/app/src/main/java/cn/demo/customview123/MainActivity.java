package cn.demo.customview123;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	public void userView1(View v){
		//跳转到自定义组件1的演示
		Intent intent=new Intent(MainActivity.this,DemoUserView1Activity.class);
		startActivity(intent);
	}
	
	public void userView2(View v){
		//跳转到自定义组件2的演示
		Intent intent=new Intent(MainActivity.this,DemoUserView2Activity.class);
		startActivity(intent);
	
	}
	
	public void userView3(View v){
		//跳转到自定义组件3的演示
		Intent intent=new Intent(MainActivity.this,DemoUserView3Activity.class);
		startActivity(intent);
	
	}
}
