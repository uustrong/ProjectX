package am.project.x.activities;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.BaseTabStrip;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import am.project.x.R;
import am.project.x.widgets.tabstrips.GradientTabStrip;

@SuppressWarnings("all")
public class WechatActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.old_activity_wechat);
		super.onCreate(savedInstanceState);
		final ViewPager mViewPager = (ViewPager) findViewById(R.id.vp);
        final GradientTabStrip tab = (GradientTabStrip) findViewById(R.id.tab_wechat);

		List<View> viewList = new ArrayList<View>();
		View v1 = LayoutInflater.from(this).inflate(R.layout.old_item_pager, null);
		((TextView) v1.findViewById(R.id.text)).setText("微信");
		viewList.add(v1);
		View v2 = LayoutInflater.from(this).inflate(R.layout.old_item_pager, null);
		((TextView) v2.findViewById(R.id.text)).setText("通讯录");
		viewList.add(v2);
		View v3 = LayoutInflater.from(this).inflate(R.layout.old_item_pager, null);
		((TextView) v3.findViewById(R.id.text)).setText("发现");
		viewList.add(v3);
		View v4 = LayoutInflater.from(this).inflate(R.layout.old_item_pager, null);
		((TextView) v4.findViewById(R.id.text)).setText("我");
        v4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                tab.performClick(0);
            }
        });

		viewList.add(v4);
		List<String> listStrings = new ArrayList<>();
		listStrings.add("微信");
		listStrings.add("通讯录");
		listStrings.add("发现");
		listStrings.add("我");
		mViewPager.setAdapter(new TitleViewPagerAdapter(viewList, listStrings));
		tab.bindViewPager(mViewPager);
        tab.performClick(1);

        tab.setItemBackground(R.drawable.old_bg_tab);
        GradientTabStrip.SimpleGradientTabAdapter adapter = new GradientTabStrip.SimpleGradientTabAdapter() {

			@Override
			public Drawable getSelectedDrawable(int position, Context context) {
				switch (position) {
				default:
				case 0:
					return ContextCompat.getDrawable(context, R.drawable.old_ain);
				case 1:
					return ContextCompat.getDrawable(context, R.drawable.old_ail);
				case 2:
					return ContextCompat.getDrawable(context, R.drawable.old_aip);
				case 3:
					return ContextCompat.getDrawable(context, R.drawable.old_air);
				}
			}

			@Override
			public Drawable getNormalDrawable(int position, Context context) {
				switch (position) {
				default:
				case 0:
					return ContextCompat.getDrawable(context, R.drawable.old_aio);
				case 1:
					return ContextCompat.getDrawable(context, R.drawable.old_aim);
				case 2:
					return ContextCompat.getDrawable(context, R.drawable.old_aiq);
				case 3:
					return ContextCompat.getDrawable(context, R.drawable.old_ais);
				}
			}
			
			@Override
			public boolean isTagEnable(int position) {
				if (position != 3) {
					return true;
				}
				return false;
			}
			
			@Override
			public String getTag(int position) {
				if (position == 0) {
					return "999";
				} else if (position == 1) {
					return "2";
				} else {
					return null;
				}
			}
		};
		tab.setAdapter(adapter);
		// 不要使用 ViewPager 的 setCurrentItem 来跳转，其不会通知到Tab进行修改
		tab.setOnItemClickListener(new BaseTabStrip.OnItemClickListener() {
			@Override
			public void onItemClick(int position) {

			}

			@Override
			public void onSelectedClick(int position) {
                Toast.makeText(getApplication(), "第" + position + "页已经选中", Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onDoubleClick(int position) {
                Toast.makeText(getApplication(), "双击第" + position + "页", Toast.LENGTH_SHORT).show();
			}
		});
		
	}
}