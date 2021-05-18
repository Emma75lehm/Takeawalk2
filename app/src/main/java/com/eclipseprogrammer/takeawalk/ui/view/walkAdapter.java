package com.eclipseprogrammer.takeawalk.ui.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.eclipseprogrammer.takeawalk.R;
import java.util.List;


public class walkAdapter extends RecyclerView.Adapter<walkAdapter.ViewHolder> {
    private List<walk> mWalks;
    final private OnListItemClickListener mOnListItemClickListener;


    public walkAdapter(OnListItemClickListener listener) {
    this.mOnListItemClickListener = listener;

    }

    @NonNull
    @Override
    public walkAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.walk_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull walkAdapter.ViewHolder holder, int position) {
        holder.w_name.setText(mWalks.get(position).getName());
        holder.w_icon.setImageResource(mWalks.get(position).getImgId());
    }

    @Override
    public int getItemCount() {
        return mWalks.size();
    }

    public void updateData(List<walk> walks){
        this.mWalks = walks;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        OnListItemClickListener onListItemClickListener;
        TextView w_name;
        ImageView w_icon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            w_name = itemView.findViewById(R.id.w_name);
            w_icon = itemView.findViewById(R.id.w_icon);
            this.onListItemClickListener = onListItemClickListener;
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {

            onListItemClickListener.onClick(getAdapterPosition());
        }
    }
        public interface OnListItemClickListener{
        void onClick(int position);
        }
}
