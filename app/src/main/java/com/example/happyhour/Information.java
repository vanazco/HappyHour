package com.example.happyhour;

import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.happyhour.Estructura.Game;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Information extends AppCompatActivity {

    private DatabaseReference mRef;
    String uid;
    GameRecyclerAdapter gameAdapter;
    FirebaseRecyclerOptions firebaseOptions;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        mRef = FirebaseDatabase.getInstance().getReference();
        uid = FirebaseAuth.getInstance().getUid();

        recyclerView = findViewById(R.id.recycler_game);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);


        firebaseOptions = new FirebaseRecyclerOptions.Builder<Game>()
                .setQuery(mRef.child("Games").child(uid), Game.class)
                .setLifecycleOwner(this)
                .build();

        gameAdapter = new GameRecyclerAdapter(firebaseOptions);
        recyclerView.setAdapter(gameAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        gameAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        gameAdapter.stopListening();
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
        switch (model.id_game){
            case 1:
                holder.game_id.setText("Figuras");
                break;
            case 2:
                holder.game_id.setText("Numeros");
                break;
            case 3:
                holder.game_id.setText("Pintar");
                break;
            case 4:
                holder.game_id.setText("Puzzle");
                break;
            case 5:
                holder.game_id.setText("Cartas");
                break;
            case 6:
                holder.game_id.setText("Letras");
                break;
            default:
                holder.game_id.setText("Juego?");
                break;
        }
        holder.inital_date.setText(model.data_inici);
        holder.fi_date.setText(model.data_fi);
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

