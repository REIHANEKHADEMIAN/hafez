package com.example.falhafezz.Adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.falhafezz.R;
import com.example.falhafezz.model.Sher;

import java.util.List;

public class SherAdapter extends RecyclerView.Adapter<SherAdapter.PoetViewHolder> {

    private List<Sher> shers;
    private Context bContext;

    public SherAdapter(Context context, List<Sher> shers) {
        this.bContext = context;
        this.shers = shers;
    }

    @Override
    public SherAdapter.PoetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_view, parent, false);
        return new PoetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SherAdapter.PoetViewHolder holder, int position) {
        holder.bindPoets(shers.get(position));
    }

    @Override
    public int getItemCount() {
        return shers.size();
    }

    public class PoetViewHolder extends RecyclerView.ViewHolder {
        private Context bContext;
        public TextView name, place, birth, death;

        public PoetViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.pname);
            place = itemView.findViewById(R.id.pplace);
            birth = itemView.findViewById(R.id.pbirth);
            death = itemView.findViewById(R.id.pdeath);
            bContext = itemView.getContext();
        }

        public void bindPoets(Sher sher) {
            name.setText(" نام شاعر : " + sher.getName());
            place.setText(" محل تولد: " + sher.getBirthPlace());
            birth.setText(" ولادت: " + sher.getBirthYear());
            death.setText("  وفات: " + sher.getDeathYear());
        }
    }
}

