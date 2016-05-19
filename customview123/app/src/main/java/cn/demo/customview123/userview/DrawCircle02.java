package cn.demo.customview123.userview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
/***
 * 在组件DrawCircle01的基础上，添加了XML方式下，默认空间的颜色属性资源和字符串资源，
 * @author yuch
 *
 */
public class DrawCircle02 extends View {
	//成员变量，圆中心点坐标X坐标Y，半径，颜色
    private float mCircleX = 40;
    private float mCircleY = 50;
    private float mCircleR = 15;   
    //从XML中读取
	private int mColor=android.graphics.Color.RED;
	private  String mText="默认值";
	
	public float getmCircleX() {
		return mCircleX;
	}

	public void setmCircleX(float mCircleX) {
		this.mCircleX = mCircleX;
	}

	public float getmCircleY() {
		return mCircleY;
	}

	public void setmCircleY(float mCircleY) {
		this.mCircleY = mCircleY;
	}

	public float getmCircleR() {
		return mCircleR;
	}

	public void setmCircleR(float mCircleR) {
		this.mCircleR = mCircleR;
	}

	//通过菜单或快捷键添加构造函数，Java方式动态生成时需要调用
	public DrawCircle02(Context context) {
		//参照Android的官方例子，1个参数的构造调用2个参数的构造
		super(context, null);
		//读XML属性
		init(context,null, 0);	
	}

	//通过菜单或快捷键添加构造函数，XML方式动态生成时需要调用
	public DrawCircle02(Context context, AttributeSet attrs) {
		//参照Android的官方例子，2个参数的构造调用3个参数的构造
		super(context, attrs, 0);
		//读XML属性
		init(context,attrs, 0);
	}

	//通过菜单或快捷键添加构造函数，UI设计工具中可视化时需要调用
	public DrawCircle02(Context context, AttributeSet attrs, int defStyleAttr) {
		//参照Android的官方例子，3个参数的构造调用父类构造
		super(context, attrs, defStyleAttr);
		//读XML属性
		init(context,attrs, defStyleAttr);
	}
	
	 //自定义初始方法 
    private void init(Context context,AttributeSet attrs, int defStyle) {
    	//如果参数属性集attrs为空，没法读取
    	if(attrs == null){
    		return ;
    	}   
    	int resId; 
        //先从XML配置中获取，默认命名空间中的属性demoColor的资源ID
    	resId= attrs.getAttributeResourceValue(null, "demoColor",0);
    	//如果资源ID有效，则从当前的资源中读取对应的颜色资源ID的颜色值
    	if(resId != 0){
    		mColor=context.getResources().getColor(resId);
    	}
    	//先从XML配置中获取，默认命名空间中的属性demoText的资源ID
    	resId = attrs.getAttributeResourceValue(null, "demoText",0);
    	//如果资源ID有效，则从当前的资源中读取对应的字符串资源ID的字符值
    	if(resId != 0){
        	mText=context.getResources().getString(resId);
        }   
        
    } 

	
	//手工添加重写方法
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		//创建画笔
        Paint paint = new Paint();
        //设置画笔颜色
        paint.setColor(mColor);
        //在指定坐标位置处 画出小球
        canvas.drawCircle(mCircleX, mCircleY, mCircleR, paint);
         //canvas.drawCircle(40, 90, 15, paint);
        canvas.drawText(mText, mCircleX-20, mCircleY-20, paint);
	}

}
