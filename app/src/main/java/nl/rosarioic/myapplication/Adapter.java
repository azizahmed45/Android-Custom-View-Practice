package nl.rosarioic.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.HashMap;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    HashMap<Integer, Integer> data = new HashMap<>();

    OnClickListener onClickListener;
    boolean playerSwap = true;

    Context context;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_button, parent, false);
        this.context = parent.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (data.get(position) == null && !winCheck()) {
                    if (playerSwap) {
                        holder.imageButton.setImageDrawable(context.getDrawable(R.drawable.shape_circle));
                        data.put(position, 0);
                    } else {
                        holder.imageButton.setImageDrawable(context.getDrawable(R.drawable.shape_cros));
                        data.put(position, 1);
                    }
                    playerSwap = !playerSwap;
                }
                if (winCheck()) Toast.makeText(context, "Win", Toast.LENGTH_SHORT).show();

//                onClickListener.onClick();
            }
        });
    }

    private boolean winCheck() {
        int[][] winData = new int[][]{
                new int[]{0, 1, 2},
                new int[]{3, 4, 5},
                new int[]{6, 7, 8},

                new int[]{0, 3, 6},
                new int[]{1, 5, 1},
                new int[]{2, 5, 8},

                new int[]{0, 4, 8},
                new int[]{2, 4, 6}
        };
        for (int[] i : winData) {
            int count1 = 0;
            int count2 = 0;
            for (int j : i) {
                if (data.get(j) != null && data.get(j) == 0)
                    count1++;
                if (data.get(j) != null && data.get(j) == 1)
                    count2++;
            }
            if (count1 >= 3 || count2 >= 3) return true;
        }

        return false;
    }

    @Override
    public int getItemCount() {
        return 9;
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageButton imageButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageButton = itemView.findViewById(R.id.imageButton);

        }
    }

    interface OnClickListener {
        void onClick();
    }
}
