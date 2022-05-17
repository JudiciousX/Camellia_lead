package TeaBush;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.camellialead.R;

public class Fragment_TreeBush4 extends Fragment {
    private ImageView QR_code;
    private Bitmap bitmap;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.treebush_fragment4, container, false);
        QR_code = view.findViewById(R.id.QR_code);
        QR_code.setImageBitmap(bitmap);
        //bitmap.recycle();
        return view;
    }

    public Fragment_TreeBush4(Bitmap bitmap) {
        this.bitmap = bitmap;

    }
}
