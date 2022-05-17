package TeaBush;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.camellialead.R;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import Tools.MyImageLoader;

public class Fragment_TeaBush2 extends Fragment implements View.OnClickListener{
    private TextView text_name;
    private TextView text_content;
    private TextView text_content1;
    private ImageView collect;
    private List<Integer> ImageList = new ArrayList<>();
    private TextView buy;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.treebush_fragment2, container, false);
        Banner banner = view.findViewById(R.id.mybanner_treebush);
        initlist();
        //设置图片加载器
        banner.setImageLoader(new MyImageLoader());
        //设置轮播的动画效果
        banner.setBannerAnimation(Transformer.Default);
        //设置是否为自动轮播，默认是true
        banner.isAutoPlay(false);
        //设置指示器的位置，小点点
        banner.setIndicatorGravity(BannerConfig.CENTER);

        //设置图片加载地址
        banner.setImages(ImageList)
                //开始调用的方法，启动轮播图。
                .start();
        text_name = view.findViewById(R.id.commodity_name);
        text_content = view.findViewById(R.id.treebush_text2);
        buy = view.findViewById(R.id.buy);
        text_content1 = view.findViewById(R.id.treebush_text3);
        collect = view.findViewById(R.id.pic1);

        String name = "\n陕西省商洛南麓茶树认养 精选茶园茶亩茶树茶苗\n";
        String text = "认养茶树的人，客服会发放专属二维码，通过扫描二维码可进行实时监控，可进行货源可追、溯源可查、责任可究，用户扫码也可以了解商洛茶叶的类型以及其他有关茶叶信息。";
        String text1 = "\n" +
                "认养人可获得：\n" +
                "\n" +
                "①冠名权：可进行挂牌登记，包括姓名以及寄语心愿。\n" +
                "\n" +
                "②可视权：查看茶树生长、种植过程。\n" +
                "\n" +
                "③参与权：可现场实地进行茶叶种植、采摘，与茶农近距离交流。\n" +
                "\n" +
                "④福利：给予认养证书、成品茶寄送。\n" +
                "\n" +
                "⑤会员：成为本店会员，可享受一对一专属服务。\n";
        text_name.setText(name);
        text_content.setText(text);
        text_content1.setText(text1);
        collect.setOnClickListener(this);
        buy.setOnClickListener(this);
        return view;
    }

    private void initlist() {
        ImageList.add(R.drawable.tree_image);
        ImageList.add(R.drawable.pic6);
        ImageList.add(R.drawable.pic0);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buy:
                //跳转确认认养页面
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.treebush_frame, new Fragment_TeaBush3()).commit();
                break;
            case R.id.pic1:
                if(collect.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.collect3).getConstantState())) {
                    collect.setBackgroundResource(R.drawable.collect2);
                }else {
                    collect.setBackgroundResource(R.drawable.collect3);
                }
                break;
            default:
                break;
        }

    }
}
