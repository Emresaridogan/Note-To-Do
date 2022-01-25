package com.yes.notdefteri.fragment;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.yes.notdefteri.MainActivity;
import com.yes.notdefteri.R;

import java.util.Objects;


public class LoginFragment extends Fragment {
    EditText email,pass;
    TextView forgetPass;
    Button login;
    private FirebaseAuth firebaseAuth;

    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        firebaseAuth=FirebaseAuth.getInstance();
        FirebaseUser firebaseUser=firebaseAuth.getCurrentUser();
        if (firebaseUser !=null && firebaseUser.isEmailVerified()){
            Intent intent = new Intent(getContext(), MainActivity.class);
            intent.addFlags(intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =inflater.inflate(R.layout.fragment_login, container, false);

        email=view.findViewById(R.id.email);
        pass=view.findViewById(R.id.pass);
        forgetPass=view.findViewById(R.id.forget_pass);
        login=view.findViewById(R.id.login);

        email.setTranslationX(800);
        pass.setTranslationX(800);
        forgetPass.setTranslationX(800);
        login.setTranslationX(800);

        email.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        pass.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        forgetPass.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        login.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(700).start();

        forgetPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText resetMail=new EditText(v.getContext());
                resetMail.setHint("Mail adresinizi girin");
                //Resources res = getResources();
                //Drawable bg = res.getDrawable(R.drawable.edit_text_bg);
                //resetMail.setBackground(bg);
                resetMail.setPadding(80,50,50,50);
                AlertDialog.Builder passwordResetDialog=new AlertDialog.Builder(v.getContext());
                passwordResetDialog.setTitle("Şifremi Unuttum");
                passwordResetDialog.setMessage("Şifrenizi sıfırlamak istiyor musunuz?");
                passwordResetDialog.setView(resetMail);

                passwordResetDialog.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String mail=resetMail.getText().toString();
                        firebaseAuth.sendPasswordResetEmail(mail).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                            Toast.makeText(getContext(),"Sıfırlama isteği gönderildi",Toast.LENGTH_LONG).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(getContext(),e.getMessage(),Toast.LENGTH_LONG).show();

                            }
                        });
                    }
                });

                passwordResetDialog.setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                passwordResetDialog.create().show();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String adress=email.getText().toString();
                String password=pass.getText().toString();

                if(adress.isEmpty()){
                    email.setError("Boş bırakmayın");
                    return;
                }if(password.isEmpty()){
                    pass.setError("Boş bırakmayın");
                    return;
                }else{
                    firebaseAuth.signInWithEmailAndPassword(adress,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()) {

                                Intent intent = new Intent(getContext(), MainActivity.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(getContext(), Objects.requireNonNull(task.getException()).getLocalizedMessage(),Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }
            }
        });
        return view;
    }
}