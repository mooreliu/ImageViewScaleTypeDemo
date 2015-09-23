package salesmarket.mooreliu.com.scaletypedemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * Created by liuyi on 15/9/23.
 */
public class FragmentChooseScaleType extends Fragment implements View.OnClickListener{

    private Button btnCenter;
    private Button btnCenterCrop;
    private Button btnCenterInside;
    private Button btnFitCenter;
    private Button btnCenterStart;
    private Button btnCenterEnd;
    private Button btnFitXY;

    private View rootView;
    private RadioGroup radioGroup;

    private int image_type;
    private int scaleType;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_choose_type, container, false);
        findViews();
        initViews();
        setOnClick();
        return rootView;
    }
    private void findViews() {
        btnCenter = (Button) rootView.findViewById(R.id.center);
        btnCenterCrop = (Button) rootView.findViewById(R.id.center_crop);
        btnCenterInside = (Button) rootView.findViewById(R.id.center_inside);
        btnFitCenter = (Button) rootView.findViewById(R.id.fit_center);
        btnCenterStart = (Button) rootView.findViewById(R.id.center_start);
        btnCenterEnd = (Button) rootView.findViewById(R.id.center_end);
        btnFitXY = (Button) rootView.findViewById(R.id.fit_xy);
        radioGroup = (RadioGroup) rootView.findViewById(R.id.radio_group);

    }

    private void initViews() {

    }

    private void setOnClick() {
        btnCenter.setOnClickListener(this);
        btnCenterCrop.setOnClickListener(this);
        btnCenterEnd.setOnClickListener(this);

        btnCenterInside.setOnClickListener(this);
        btnCenterStart.setOnClickListener(this);
        btnFitCenter.setOnClickListener(this);
        btnFitXY.setOnClickListener(this);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.image_type_1:
                        image_type = 1;
                        break;
                    case R.id.image_type_2:
                        image_type = 2;
                        break;
                    default:
                        Toast.makeText((getActivity()), "请选择图片类型", Toast.LENGTH_SHORT).show();
                        break;

                }
            }
        });
    }
    private void replaceFragment() {
        if(image_type != 1 && image_type != 2) {
            Toast.makeText(getActivity(), "请选择图片类型" ,Toast.LENGTH_SHORT).show();
            return;
        }
        //FragmentManager fm = getChildFragmentManager();//  getFragmentManager();
        FragmentManager fm = getFragmentManager();//  getFragmentManager();

        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.root,  FragmentImage.newInstance(scaleType, image_type));
        ft.addToBackStack(null);
        ft.commit();
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.center:
                scaleType = Common.CENTER;
                break;
            case R.id.center_crop:
                scaleType = Common.CENTER_CROP;
                break;
            case R.id.center_end:
                scaleType = Common.FIT_END;
                break;
            case R.id.center_inside:
                scaleType = Common.CENTER_INSIDE;
                break;
            case R.id.fit_center:
                scaleType = Common.FIT_CENTER;
                break;
            case R.id.fit_xy:
                scaleType = Common.FIT_XY;
                break;
            case R.id.center_start:
                scaleType = Common.FIT_START;
                break;
            default:
                break;
        }
        replaceFragment();
    }
}
