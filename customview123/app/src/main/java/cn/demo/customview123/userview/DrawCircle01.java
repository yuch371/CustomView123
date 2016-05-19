package cn.demo.customview123.userview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
/***
 * 本自定义组件在指定的位置处画一个固定大小的红色圆球
 *   外部使用时，组件的高低和宽度需要大于100，否则效果不明显，
 * @author yuch
 *
 */
public class DrawCircle01 extends View {
	//成员变量，圆中心点坐标X坐标Y，半径，颜色
    private float mCircleX = 40;
    private float mCircleY = 50;
    private float mCircleR = 15;    
	private int mColor=android.graphics.Color.RED;
	
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
	public DrawCircle01(Context context) {
		//参照Android的官方例子，1个参数的构造调用2个参数的构造
		super(context, null);
		// TODO Auto-generated constructor stub
	}

	//通过菜单或快捷键添加构造函数，XML方式动态生成时需要调用
	public DrawCircle01(Context context, AttributeSet attrs) {
		//参照Android的官方例子，2个参数的构造调用3个参数的构造
		super(context, attrs, 0);
		// TODO Auto-generated constructor stub
	}

	//通过菜单或快捷键添加构造函数，UI设计工具中可视化时需要调用
	public DrawCircle01(Context context, AttributeSet attrs, int defStyleAttr) {
		//参照Android的官方例子，3个参数的构造调用父类构造
		super(context, attrs, defStyleAttr);
		// TODO Auto-generated constructor stub
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
	}

}
