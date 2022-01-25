package com.yes.notdefteri.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.yes.notdefteri.LoginActivity;
import com.yes.notdefteri.MainActivity;
import com.yes.notdefteri.R;

public class RegisterFragment extends Fragment {
    EditText email,pass,cpass;
    Button register;
    private FirebaseAuth firebaseAuth;

    public static RegisterFragment newInstance() {
        return new RegisterFragment();
    }

    public RegisterFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        firebaseAuth=FirebaseAuth.getInstance();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.fragment_register, container, false);

        email=view.findViewById(R.id.email);
        pass=view.findViewById(R.id.pass);
        cpass=view.findViewById(R.id.cpass);
        register=view.findViewById(R.id.register);

        email.setTranslationX(800);
        pass.setTranslationX(800);
        cpass.setTranslationX(800);
        register.setTranslationX(800);

        email.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(1700).start();
        pass.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(1700).start();
        cpass.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(1700).start();
        register.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(1700).start();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String adress=email.getText().toString();
                String password=pass.getText().toString();
                String cp=cpass.getText().toString();



               if(adress.isEmpty()){
                    email.setError("Boş bırakmayın");
                    return;
                }if(password.isEmpty()){
                    pass.setError("Boş bırakmayın");
                    return;
                }if(cp.isEmpty()){
                    cpass.setError("Girdiğiniz şifreler aynı değil");
                    return;
                }
                else{
                register(password,adress);
                }

            }
        });

       return view;
    }
    private void register(String pass , String email){

        firebaseAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){

                    FirebaseUser user=FirebaseAuth.getInstance().getCurrentUser();
                    if(user.isEmailVerified()){
                        Intent intent = new Intent(getContext(), MainActivity.class);
                        intent.addFlags(intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(intent);
                    }else{
                        user.sendEmailVerification();
                        Toast.makeText(getContext(),"Mail kutunuzu kontrol edin",Toast.LENGTH_LONG).show();
                        startActivity(new Intent(getContext(), LoginActivity.class));
                    }

                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getContext(),e.getLocalizedMessage(),Toast.LENGTH_LONG).show();

            }
        });





    }
}