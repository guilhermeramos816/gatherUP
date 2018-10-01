package com.example.guilhermeoramos.gatherup;

import android.util.Log;
import android.view.Gravity;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Login {
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference refUsuarios = database.getReference("usuarios");


    private interface MyCallback {
        void onCallback(int user);
    }

    private void login(final MyCallback myCallback, String email, String senha) {
        refUsuarios
                .orderByChild("email")
                .startAt(email)
                .endAt(email)
                .orderByChild("senha")
                .startAt(senha)
                .endAt(senha)
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        int count = (int) dataSnapshot.getChildrenCount();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }
                });
    }
}
