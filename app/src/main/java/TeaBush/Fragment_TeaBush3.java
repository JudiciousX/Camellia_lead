package TeaBush;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.camellialead.R;

import Tools.QRCodeUtil;

public class Fragment_TeaBush3 extends Fragment implements View.OnClickListener{
    private TextView commit;
    private EditText etAmount;
    private Button btnDecrease;
    private Button btnIncrease;
    private EditText edit_name1;
    private EditText edit_name2;
    private EditText text_beizhu;
    private int count = 1;
    private String name;
    private String phone;
    private String beizhu;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.treebush_fragment3, container, false);
        commit = view.findViewById(R.id.commit);
        etAmount = view.findViewById(R.id.etAmount);
        btnDecrease = view.findViewById(R.id.btnDecrease);
        btnIncrease = view.findViewById(R.id.btnIncrease);
        edit_name1 = view.findViewById(R.id.edit_name1);
        edit_name2 = view.findViewById(R.id.edit_name2);
        text_beizhu = view.findViewById(R.id.text_beizhu);
        btnDecrease.setOnClickListener(this);
        btnIncrease.setOnClickListener(this);
        commit.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.commit:
                //生成二维码
                name = edit_name1.getText().toString();
                phone = edit_name2.getText().toString();
                beizhu = text_beizhu.getText().toString();
                Bitmap mBitmap = QRCodeUtil.createQRCodeBitmap("https://www.baidu.com", 300, 300);
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.treebush_frame, new Fragment_TreeBush4(mBitmap)).commit();
                break;
            case R.id.btnDecrease:
                //减少
                if(count != 0) {
                    count--;
                    etAmount.setText(count + "");
                }
                break;
            case R.id.btnIncrease:
                //增加
                if(count != 99) {
                    count++;
                    etAmount.setText(count + "");
                }
                break;
            default:
                break;
        }
    }
}
