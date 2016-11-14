package carillegalquery.carillegalquery.fragment;


import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.BounceInterpolator;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import carillegalquery.carillegalquery.R;
import carillegalquery.carillegalquery.adapter.shenQuAdapter.MySheQuAdapter;

import static android.animation.ObjectAnimator.ofFloat;

/**
 * A simple {@link Fragment} subclass.
 */
public class SheQuFragment extends Fragment {


    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private MySheQuAdapter mSheQuAdapter;
    private int heightPixels;
    private Animation animation;
    private View askQuestions;
    private View customTopic;
    private View modelsToVote;
    private View help;

    public SheQuFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSheQuAdapter = new MySheQuAdapter(getChildFragmentManager());
        heightPixels = getActivity().getResources().getDisplayMetrics().heightPixels;
        setHasOptionsMenu(true);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_she_qu_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();


    }

    private void initView() {
        mTabLayout = (TabLayout) getView().findViewById(R.id.tablayout);
        mViewPager = (ViewPager) getView().findViewById(R.id.vp_show);
        mViewPager.setAdapter(mSheQuAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        getView().findViewById(R.id.shen_qu_more).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupMenu(v);
            }
        });
        FloatingActionButton fab = (FloatingActionButton) getView().findViewById(R.id.shen_qu_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPostAMessage(v);
            }
        });
    }

    /**
     * 属性动画PropertyAni
     * <p>
     * 常用的属性动画的属性值有：
     * - translationX、translationY----控制view对象相对其左上角坐标在X、Y轴上偏移的距离
     * - rotation、rotationX、rotationY----控制view对象绕支点进行2D和3D旋转
     * - scaleX、scaleY----控制view对象绕支点进行2D缩放
     * - pivotX、pivotY----控制view对象的支点位置，这个位置一般就是view对象的中心点。围绕这个支点可以进行旋转和缩放处理
     * - x、y----描述view对象在容器中的最终位置，是最初的左上角坐标和translationX、translationY值的累计和
     * - alpha----表示view对象的透明度。默认值是1(完全透明)、0(不透明)
     * <p>
     * Created by wondertwo on 2016/3/11.
     */
    private void showPostAMessage(View v) {
        final PopupWindow pw = new PopupWindow();
        pw.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        final View layout = LayoutInflater.from(getActivity()).inflate(R.layout.view_post_a_message_menu, new LinearLayout(getActivity()), false);
        pw.setContentView(layout);
        pw.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        pw.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
        pw.setFocusable(true);
        layout.setAlpha(0.9f);
              askQuestions = layout.findViewById(R.id.rb_shenqu_ask_questions);
        customTopic = layout.findViewById(R.id.rb_shenqu_custom_topic);
        modelsToVote = layout.findViewById(R.id.rb_shenqu_models_to_vote);
        help = layout.findViewById(R.id.rb_shenqu_help);

        pw.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                layout.setAlpha(1);
            }
        });
        pw.showAtLocation(v, Gravity.BOTTOM, 0, 0);
        layout.findViewById(R.id.iv_shenqu_close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pw.dismiss();
            }
        });
//        ObjectAnimator obj = ObjectAnimator.ofFloat(customTopic, "translationY", 1000, 1).setDuration(500);
//        obj.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                float value = (float) animation.getAnimatedValue();
//                if (value > 0.1) {
//                    askQuestions.setVisibility(View.VISIBLE);
//                    ObjectAnimator objectAnimator = ofFloat(askQuestions, "translationY", 1000, 1).setDuration(500);
//                    objectAnimator.setInterpolator(new BounceInterpolator());
//                    objectAnimator.start();
//                }
//                if (value > 0.2) {
//                    modelsToVote.setVisibility(View.VISIBLE);
//                    ObjectAnimator objectAnimator = ofFloat(modelsToVote, "translationY", 1000, 1).setDuration(500);
//                    objectAnimator.setInterpolator(new BounceInterpolator());
//                    objectAnimator.start();
//                }
//                if (value > 0.3) {
//                    help.setVisibility(View.VISIBLE);
//
//                    ObjectAnimator objectAnimator = ofFloat(help, "translationY", 1000, 1).setDuration(500);
//                    objectAnimator.setInterpolator(new BounceInterpolator());
//                    objectAnimator.start();
//                }
//            }
//
//        });
//        customTopic.setVisibility(View.VISIBLE);
//        obj.setInterpolator(new BounceInterpolator());
//        obj.start();
//        animation = AnimationUtils.loadAnimation(getActivity(), R.anim.translate_post_message_anim);
        h.sendEmptyMessageDelayed(0,200);
        h.sendEmptyMessageDelayed(1,400);
        h.sendEmptyMessageDelayed(2,600);
        h.sendEmptyMessageDelayed(3,800);
    }

            Handler h = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                switch (msg.what){
                    case 0:
                        customTopic.setVisibility(View.VISIBLE);
                        ObjectAnimator objectAnimator = ofFloat(customTopic, "translationY", 1000, 1).setDuration(500);
                        objectAnimator.setInterpolator(new BounceInterpolator());
                        objectAnimator.start();
                        break;
                    case 1:
                        askQuestions.setVisibility(View.VISIBLE);
                        ObjectAnimator objectAnimator1 = ofFloat(askQuestions, "translationY", 1000, 1).setDuration(500);
                        objectAnimator1.setInterpolator(new BounceInterpolator());
                        objectAnimator1.start();
                        break;
                    case 2:
                        modelsToVote.setVisibility(View.VISIBLE);
                        ObjectAnimator objectAnimator2 = ofFloat(modelsToVote, "translationY", 1000, 1).setDuration(500);
                        objectAnimator2.setInterpolator(new BounceInterpolator());
                        objectAnimator2.start();
                        break;
                    case 3:
                        help.setVisibility(View.VISIBLE);
                        ObjectAnimator objectAnimator3 = ofFloat(help, "translationY", 1000, 1).setDuration(500);
                        objectAnimator3.setInterpolator(new BounceInterpolator());
                        objectAnimator3.start();
                        break;
                }
                return false;
            }
        });
    private void showPopupMenu(View v) {
        PopupWindow pw = new PopupWindow(getActivity());
        View layout = LayoutInflater.from(getActivity()).inflate(R.layout.view_shenqu_menu, new LinearLayout(getActivity()), false);
        pw.setContentView(layout);
        pw.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        pw.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        pw.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        pw.setFocusable(true);
        pw.setOutsideTouchable(true);

        final WindowManager.LayoutParams attributes = getActivity().getWindow().getAttributes();
        attributes.alpha = 0.8f;
        getActivity().getWindow().setAttributes(attributes);

        pw.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                attributes.alpha = 1f;
                getActivity().getWindow().setAttributes(attributes);
            }
        });
        int width = layout.getLayoutParams().width;

        pw.showAsDropDown(v, -width - 100, 0);
    }


}
