package cn.demo.customview123.userview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import cn.demo.customview123.R;
/***
 * 在组件DrawCircle01的基础上，添加了XML方式下，自定义空间的颜色属性资源和字符串资源，
 * @author yuch
 *
 */
public class DrawCircle03 extends View {
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
	public DrawCircle03(Context context) {
		//参照Android的官方例子，1个参数的构造调用2个参数的构造
		super(context, null);
		//读XML属性
		init(context,null, 0);	
	}

	//通过菜单或快捷键添加构造函数，XML方式动态生成时需要调用
	public DrawCircle03(Context context, AttributeSet attrs) {
		//参照Android的官方例子，2个参数的构造调用3个参数的构造
		super(context, attrs, 0);
		//读XML属性
		init(context,attrs, 0);
	}

	//通过菜单或快捷键添加构造函数，UI设计工具中可视化时需要调用
	public DrawCircle03(Context context, AttributeSet attrs, int defStyleAttr) {
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
    	int resId=-1;
    	//获取指定命名空间中属性集中所定义的属性
        TypedArray typedArray = context.obtainStyledAttributes(attrs,
              R.styleable.MyCircle);
          //通过循环，依次读出
          int  n = typedArray.getIndexCount();
          for (int i = 0; i < n; i++) {
              int attr = typedArray.getIndex(i);
              //如果是某个指定的自定义属性
              switch (attr) {
              	case R.styleable.MyCircle_demoColor:
              	  //先以ID的方式读取，如果是ID编号库中的ID，则按照ID方式读取，否则以文本方式读取
              	  resId = typedArray.getResourceId(R.styleable.MyCircle_demoColor, 0);
              	  if(resId > 0){
              		mColor=(int) typedArray.getResources().getColor(resId);
              	  }else{
              		mColor=typedArray.getColor(R.styleable.MyCircle_demoColor,android.graphics.Color.RED);
              	  }
                  break;
              case R.styleable.MyCircle_demoText:
            	  //先以ID的方式读取，如果是ID编号库中的ID，则按照ID方式读取，否则以文本方式读取
            	  resId = typedArray.getResourceId(R.styleable.MyCircle_demoText, 0);
            	  if(resId > 0){
            		  mText=(String) typedArray.getResources().getText(resId);
            	  }else{
            		  mText=typedArray.getString(R.styleable.MyCircle_demoText);
            	  }
                  break;
              case R.styleable.MyCircle_demoCircleR:
            	  //先以ID的方式读取，如果是ID编号库中的ID，则按照ID方式读取，否则以文本方式读取
            	  //resId = typedArray.getResourceId(R.styleable.MyCircle_demoCircleR, 0);
            	  resId=0;
            	  if(resId > 0){
            		  mCircleR=(float) typedArray.getResources().getDimension(resId);
            	  }else{
            		  mCircleR=typedArray.getDimension(R.styleable.MyCircle_demoCircleR,15);
            	  }
                  break;   
              }
          }
          //一定别忘了释放属性集，否则造成内存因不能及时释放而过度消耗
          typedArray.recycle();        
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
        canvas.drawText(mText, mCircleX-20-mCircleR, mCircleY-20-mCircleR, paint);
	}

}
