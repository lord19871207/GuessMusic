package com.zhi.app.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends Activity {

	private ImageView mViewPan;
	private ImageView mViewPanBar;
	private ImageButton mStartPlay;

	// add by zhidf 2015.6.6 ��Ƭ��ض���
	private Animation mPanAnim;
	private LinearInterpolator mPanInterpolator;

	private Animation mBarInAnim;
	private LinearInterpolator mBarInInterpolator;

	private Animation mBarOutAnim;
	private LinearInterpolator mBarOutInterpolator;
	// end

	private boolean isRunning = false; // �����Ƿ�����ִ��

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// �����ʼ��
		this.initView();
	}

	/**
	 * ��ʼ������
	 */
	private void initView() {
		// start �ؼ���ʼ��
		this.mViewPan = (ImageView) this.findViewById(R.id.iv_pan);
		this.mViewPanBar = (ImageView) findViewById(R.id.iv_pan_bar);
		this.mStartPlay = (ImageButton) findViewById(R.id.btn_start_play);

		this.mStartPlay.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// 1����������Ű�ťʱ�����ӿ�ʼ���볪Ƭ��ִ�й��ӽ��붯��
				// 2�����ӽ��볪�̺󣬳��̿�ʼִ�й�������
				// 3�����̶���ִ����ɺ󣬹��ӻص�һ��ʼ��λ�ã���ִ�й��ӷ��ض���
				// �����Ҫ�������ֶ������ö�Ӧ�Ķ������������ڶ����Ĳ�ͬ״ִ̬�ж�Ӧ�Ķ���
				
				// ����δִ�У���ʼִ�ж�������������趨Ϊ��ִ�С�״̬
				if (!isRunning) {
					mViewPanBar.startAnimation(mBarInAnim);
					isRunning = true;
					mStartPlay.setVisibility(View.INVISIBLE);
				}
			}
		});
		// end

		// start ������ʼ��
		// ��Ƭ������ʼ��
		this.mPanAnim = AnimationUtils.loadAnimation(this, R.anim.rotate);
		this.mPanInterpolator = new LinearInterpolator();
		mPanAnim.setInterpolator(mPanInterpolator);
		mPanAnim.setAnimationListener(new Animation.AnimationListener() {

			@Override
			public void onAnimationStart(Animation animation) {

			}

			@Override
			public void onAnimationRepeat(Animation animation) {

			}

			@Override
			public void onAnimationEnd(Animation animation) {
				// ���̹�������ִ�����ִ�й��ӷ��ض�������ʱ���ӷ������λ��
				mViewPanBar.startAnimation(mBarOutAnim);
				// ����ִ����ɺ��趨����״̬Ϊֹͣ���������Ű�ť��ʾ����
				isRunning = false;
				mStartPlay.setVisibility(View.VISIBLE);
			}
		});

		// ���ӽ��붯��
		this.mBarInAnim = AnimationUtils.loadAnimation(this, R.anim.rotate_45);
		this.mBarInInterpolator = new LinearInterpolator();
		mBarInAnim.setInterpolator(mBarInInterpolator);
		mBarInAnim.setFillAfter(true); // ������������ͣ���ڵ�ǰλ�ã������ǻص���ʼλ��
		mBarInAnim.setAnimationListener(new Animation.AnimationListener() {

			@Override
			public void onAnimationStart(Animation animation) {

			}

			@Override
			public void onAnimationRepeat(Animation animation) {

			}

			@Override
			public void onAnimationEnd(Animation animation) {
				// ���ӽ��붯��ִ����ɺ󣬿�ʼִ�г��̹������������̿�ʼ����
				mViewPan.startAnimation(mPanAnim);
			}
		});

		// ���ӷ��ض���
		this.mBarOutAnim = AnimationUtils.loadAnimation(this, R.anim.rotate_d_45);
		this.mBarOutInterpolator = new LinearInterpolator();
		mBarOutAnim.setInterpolator(mBarOutInterpolator);
		mBarOutAnim.setFillAfter(true); // ������������ͣ���ڵ�ǰλ�ã������ǻص���ʼλ��
		mBarOutAnim.setAnimationListener(new Animation.AnimationListener() {

			@Override
			public void onAnimationStart(Animation animation) {

			}

			@Override
			public void onAnimationRepeat(Animation animation) {

			}

			@Override
			public void onAnimationEnd(Animation animation) {

			}
		});
		// end
	}
}
