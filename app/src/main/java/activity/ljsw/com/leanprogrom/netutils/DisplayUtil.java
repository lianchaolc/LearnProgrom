package activity.ljsw.com.leanprogrom.netutils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ListAdapter;
import android.widget.ListView;

/**
 * dp、sp转换为px的工具类
 */
public class DisplayUtil {
	/**
	 * 将px值转换为dip或dp值，保证尺寸大小不变
	 * @param context
	 * @param pxValue
	 * @return
	 */
	public static int px2dip(Context context, float pxValue){
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (pxValue / scale + 0.5f);
	}

	/**
	 * 将dip或dp值转换为px值，保证尺寸大小不变
	 * @param context
	 * @param dipValue
	 * @return
	 */
	public static int dip2px(Context context, float dipValue){
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dipValue * scale + 0.5f);
	}

	/**
	 * 将px值转换为sp值，保证文字大小不变
	 * @param pxValue
	 * @return
	 */
	public static int px2sp(Context context, float pxValue) {
		final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
		return (int) (pxValue / fontScale + 0.5f);
	}

	/**
	 * 将sp值转换为px值，保证文字大小不变
	 * @param spValue
	 * @return
	 * fontScale（DisplayMetrics类中属性scaledDensity）
	 */
	public static int sp2px(Context context, float spValue) {
		final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
		return (int) (spValue * fontScale + 0.5f);
	}


	public static Screen getScreenPix(Context context) {
		DisplayMetrics dm = new DisplayMetrics();
		WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
		windowManager.getDefaultDisplay().getMetrics(dm);
		return new Screen(dm.widthPixels, dm.heightPixels);
	}

	/**
	 * 获取屏幕的宽
	 *
	 * @param context
	 *            当前上下文
	 * @return 屏幕宽
	 */
	public static int getScreenWidthPix(Context context) {
		DisplayMetrics dm = new DisplayMetrics();
		WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
		windowManager.getDefaultDisplay().getMetrics(dm);
		return dm.widthPixels;
	}

	/**
	 * 获取屏幕的高
	 *
	 * @param context
	 *            当前上下文
	 * @return 屏幕高
	 */
	public static int getScreenHeightPix(Context context) {
		DisplayMetrics dm = new DisplayMetrics();
		WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
		windowManager.getDefaultDisplay().getMetrics(dm);
		return dm.heightPixels;
	}

	/**
	 * 屏幕信息
	 *
	 * @author wangyang
	 *
	 */
	public static class Screen {
		// 屏幕宽
		public int widthPixels;
		// 屏幕高
		public int heightPixels;

		public Screen() {
		}

		public Screen(int widthPixels, int heightPixels) {
			this.widthPixels = widthPixels;
			this.heightPixels = heightPixels;
		}
	}

	/**
	 * 获取屏幕密度
	 *
	 * @return float
	 * @throws
	 */
	public static float getDensity(Context context) {
		DisplayMetrics dm = new DisplayMetrics();
		dm = context.getResources().getDisplayMetrics();
		return dm.density;
	}

	/**
	 * dp转px
	 *
	 *
	 * @param context
	 * @param dpValue
	 *            dp
	 * @return int px
	 * @throws
	 */
	public static int dp2px(int context, Context dpValue) {
//		return (int) (dpValue * getDensity(context) + 0.5f);
		return 1;
	}

	/**
	 * px 转 dp
	 *
	 * @param pxValue
	 *            px
	 * @return int dp
	 * @throws
	 */
	public static int px2dp(Context context, float pxValue) {
		return (int) (pxValue / getDensity(context) + 0.5f);
	}

	/**
	 * 获取状态栏高度
	 *
	 * @return
	 * @return int
	 * @throws
	 */
	public static int getStatusBarHeight() {
		return Resources.getSystem().getDimensionPixelSize(Resources.getSystem().getIdentifier("status_bar_height", "dimen", "android"));
	}

	/**
	 * 动态设置ListView的高度
	 * @param listView
	 */
	public static void setListViewHeightBasedOnChildren(ListView listView) {
		if(listView == null) return;

		ListAdapter listAdapter = listView.getAdapter();
		if (listAdapter == null) {
			// pre-condition
			return;
		}

		int totalHeight = 0;
		for (int i = 0; i < listAdapter.getCount(); i++) {
			View listItem = listAdapter.getView(i, null, listView);
			listItem.measure(0, 0);
			totalHeight += listItem.getMeasuredHeight();
		}

		ViewGroup.LayoutParams params = listView.getLayoutParams();
		params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+params.height);
		listView.setLayoutParams(params);
	}
}
