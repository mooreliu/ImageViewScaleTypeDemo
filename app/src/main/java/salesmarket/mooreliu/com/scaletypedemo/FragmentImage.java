package salesmarket.mooreliu.com.scaletypedemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by liuyi on 15/9/22.
 */
public class FragmentImage extends Fragment {

    private static final String TAG = "FragmentImage";
    private View rootView;
    private ImageView iv;
    private int scaleType;
    private int imageType;

    public static FragmentImage newInstance(int scaleType, int imageType) {
        FragmentImage fragmentImage = new FragmentImage();
        Bundle args =  new Bundle();
        args.putInt("scaleType", scaleType);
        args.putInt("imageType", imageType);
        fragmentImage.setArguments(args);
        return  fragmentImage;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_image_display, container, false);
        findView();
        initView();
        setOnClick();
        return rootView;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        scaleType = getArguments() != null ? getArguments().getInt("scaleType"): 1;
        imageType = getArguments() != null ? getArguments().getInt("imageType"): 1;
        Log.e(TAG, "scaleType = " + scaleType + "imageType = " + imageType);
    }

    private void findView() {
        iv = (ImageView) rootView.findViewById(R.id.image);
    }

    private void initView() {
        switch (imageType) {
            case 1:
                iv.setImageResource(R.drawable.image_small);
                break;
            case 2:
                iv.setImageResource(R.drawable.image_big);
                break;
            default:
                throw new IllegalArgumentException("illegel imageType");
        }

        switch (scaleType) {
            case Common.CENTER:
                iv.setScaleType(ImageView.ScaleType.CENTER);
                break;
            case Common.CENTER_CROP:
                iv.setScaleType(ImageView.ScaleType.CENTER_CROP);

                break;
            case Common.FIT_END:
                iv.setScaleType(ImageView.ScaleType.FIT_END);

                break;
            case Common.CENTER_INSIDE:
                iv.setScaleType(ImageView.ScaleType.CENTER_INSIDE);

                break;
            case Common.FIT_START:
                iv.setScaleType(ImageView.ScaleType.FIT_START);

                break;
            case Common.FIT_CENTER:
                iv.setScaleType(ImageView.ScaleType.FIT_CENTER);

                break;
            case Common.FIT_XY:
                iv.setScaleType(ImageView.ScaleType.FIT_XY);

                break;

            default:
                break;
        }
    }

    private void setOnClick() {

    }

}
