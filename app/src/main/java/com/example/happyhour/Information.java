package com.example.happyhour;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.happyhour.Estructura.Game;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Information extends AppCompatActivity {

    private DatabaseReference mRef;
    String uid;
    GameRecyclerAdapter gameAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        mRef = FirebaseDatabase.getInstance().getReference();
        uid = FirebaseAuth.getInstance().getUid();

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));

        FirebaseRecyclerOptions firebaseOptions = new FirebaseRecyclerOptions.Builder<Game>()
                .setQuery(mRef.child(uid),Game.class)
                .setLifecycleOwner(this)
                .build();

        gameAdapter = new GameRecyclerAdapter(firebaseOptions);
        recyclerView.setAdapter(gameAdapter);
    }
}

class GameRecyclerAdapter extends FirebaseRecyclerAdapter<Game,GameRecyclerAdapter.GameViewHolder>{

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public GameRecyclerAdapter(@NonNull FirebaseRecyclerOptions<Game> options) {
        super(options);
    }


    @Override
    protected void onBindViewHolder(@NonNull GameViewHolder holder, int position, @NonNull Game model) {
        holder.game_id.setText(model.id_game);
        holder.inital_date.setText(model.data_inici.toString());
        holder.fi_date.setText(model.data_fi.toString());
    }

    @NonNull
    @Override
    public GameViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.game_item,viewGroup,false);
        return new GameViewHolder(view);
    }

    public class GameViewHolder extends RecyclerView.ViewHolder{
        TextView game_id,inital_date,fi_date;

        public GameViewHolder(@NonNull View itemView) {
            super(itemView);
            game_id = itemView.findViewById(R.id.game_id);
            inital_date = itemView.findViewById(R.id.game_initial_date);
            fi_date = itemView.findViewById(R.id.game_final_date);
        }
    }
}

