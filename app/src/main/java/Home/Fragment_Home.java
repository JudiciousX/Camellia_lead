package Home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.camellialead.R;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import com.youth.banner.loader.ImageLoaderInterface;

import java.util.ArrayList;
import java.util.List;

import Tools.MyImageLoader;

public class Fragment_Home extends Fragment {
    private List<Integer> ImageList = new ArrayList<>();
    private SearchView mSearchView;
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, container, false);
        mSearchView = view.findViewById(R.id.search_home);
        recyclerView = view.findViewById(R.id.recycler_home);
        mSearchView.setIconifiedByDefault(false);
        //设置搜索框展开时是否显示提交按钮，可不显示
        mSearchView.setSubmitButtonEnabled(false);
        //让键盘的回车键设置成搜索
        mSearchView.setImeOptions(EditorInfo.IME_ACTION_SEARCH);
        //搜索框是否展开，false表示展开
        mSearchView.setIconified(false);
        //获取焦点
        mSearchView.setFocusable(true);
        mSearchView.requestFocusFromTouch();
        //设置提示词
        mSearchView.setQueryHint("请输入关键字");
        init();
        Banner banner = view.findViewById(R.id.mybanner_home);
        initlist();
        //设置图片加载器
        banner.setImageLoader(new MyImageLoader());
        //设置轮播的动画效果
        banner.setBannerAnimation(Transformer.Default);
        //设置轮播间隔时间
        banner.setDelayTime(3000);
        //设置是否为自动轮播，默认是true
        banner.isAutoPlay(true);
        //设置指示器的位置，小点点
        banner.setIndicatorGravity(BannerConfig.CENTER);

        //设置图片加载地址
        banner.setImages(ImageList)
                //开始调用的方法，启动轮播图。
                .start();
        return view;
    }

    private void initlist() {
        ImageList.add(R.drawable.tree_image);
        ImageList.add(R.drawable.tree_image);
        ImageList.add(R.drawable.tree_image);
    }

    private void init() {
        List<String> text = new ArrayList<>();
        text.add("全部商品");
        text.add("茶艺茶道");
        text.add("我的收藏");
        text.add("拼团专区");
        text.add("积分签到");
        text.add("优惠券");
        text.add("茶树认养");
        text.add("砍价专区");
        Adapter_Home adapter_home = new Adapter_Home(text, new ArrayList<>());
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter_home);
    }


}
