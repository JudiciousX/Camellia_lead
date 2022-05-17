package TeaBush;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;

import com.example.camellialead.MainActivity;
import com.example.camellialead.R;
import com.example.camellialead.TreeBush_Shopping;

import java.util.List;

public class Fragment_TeaBush extends Fragment {
    private TextView text_introduce;
    private SearchView mSearchView;
    private List<MediaController> list;

    public Fragment_TeaBush(List<MediaController> list) {
        this.list = list;
    }


    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.treebush_fragment, container, false);
        LinearLayout layout = view.findViewById(R.id.linear1);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TreeBush_Shopping.class);
                startActivity(intent);
            }
        });
        mSearchView = view.findViewById(R.id.search);

        text_introduce = view.findViewById(R.id.text_introduce);
        //搜索图标是否显示在搜索框内
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

        text_introduce.setText("“茶树认养计划”是茶农将所种植的山茶可按照亩或颗进行划分供市民进行“云认养”，认养者需预先支付土地租金和农资费用。认养者与农户签订协议后，拥有认养土地的冠名权、可视权以及茶树收益福利等。认养者既可以在农场技术人员的指导下参与种植茶树的过程，也可以选择让山茶管家代为全程打理。");

        VideoView videoView = view.findViewById(R.id.videoView);

        //加载指定的视频文件
        String uri = new String();
        uri = "android.resource://" + getContext().getPackageName() + "/" + R.raw.tea;
        videoView.setVideoPath(uri);

        //创建MediaController对象
        MediaController mediaController = list.get(0);

        //VideoView与MediaController建立关联
        videoView.setMediaController(mediaController);

        mediaController.setPadding(15,0,15,0);

        VideoView videoView1 = view.findViewById(R.id.videoView1);
        videoView1.setVideoPath(uri);
        MediaController mediaController1 = list.get(1);
        videoView1.setMediaController(mediaController1);
        mediaController1.setPadding(15, 0, 15, 0);

        VideoView videoView2 = view.findViewById(R.id.videoView2);
        videoView2.setVideoPath(uri);
        MediaController mediaController2 = list.get(2);
        videoView2.setMediaController(mediaController2);
        mediaController2.setPadding(15, 0, 15, 0);
        return view;
    }



}
