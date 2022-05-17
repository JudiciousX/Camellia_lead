package Home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.camellialead.R;

import java.util.List;

public class Adapter_Home extends RecyclerView.Adapter<Adapter_Home.ViewHolder> {
    private List<String> text;
    private List<Integer> image;

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_recycler);
            textView = itemView.findViewById(R.id.text_recycler);
        }
    }

    public Adapter_Home(List<String> text, List<Integer> image) {
        this.image = image;
        this.text = text;
    }


    @NonNull
    @Override
    public Adapter_Home.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_recycler, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_Home.ViewHolder holder, int position) {
        //holder.imageView.setImageResource(image.get(position));
        holder.textView.setText(text.get(position));
    }

    @Override
    public int getItemCount() {
        return text.size();
    }
}
