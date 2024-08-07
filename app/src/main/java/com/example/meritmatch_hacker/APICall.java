package com.example.meritmatch_hacker;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APICall {

    public interface loginCallback {
        void onResponse(CallStatus status);
    }

    public interface UserInfoCallback {
        void onResponse(ClassUserInfo userInfo);
    }

    public interface getTasksCallback {
        void onResponse(List<ClassTaskDetails> tasks);
    }

    Retrofit retrofit = new Retrofit.Builder().baseUrl("http://10.0.2.2:8000/")
            .addConverterFactory(GsonConverterFactory.create()).build();
    APIService service = retrofit.create(APIService.class);

    public void login(String User_name, String Password, Context context, loginCallback callback) {
        ClassUserOperation user = new ClassUserOperation(User_name, Password);
        Call<CallStatus> call = service.login(user);
        call.enqueue(new Callback<CallStatus>() {
            @Override
            public void onResponse(Call<CallStatus> call, Response<CallStatus> response) {
                if (response.isSuccessful() && response != null) {
                    callback.onResponse(response.body());
                }
            }

            @Override
            public void onFailure(Call<CallStatus> call, Throwable t) {
                makeToast(context, "Failed to retreive from database");
            }
        });
    }

    public void makeToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public void signup(String User_name, String Password, Context context, UserInfoCallback callback) {
        ClassUserOperation user = new ClassUserOperation(User_name, Password);
        Call<ClassUserInfo> call = service.signup(user);
        call.enqueue(new Callback<ClassUserInfo>() {
            @Override
            public void onResponse(Call<ClassUserInfo> call, Response<ClassUserInfo> response) {
                if (response.isSuccessful() && response != null) {
                    ClassUserInfo user = response.body();
                    callback.onResponse(user);
                }
            }

            @Override
            public void onFailure(Call<ClassUserInfo> call, Throwable t) {
                makeToast(context, "Failed to retreive from database");
            }
        });
    }


    //task api calls
    public void getPostedTasks(String PostedBy, Context context, getTasksCallback callback) {
        Call<List<ClassTaskDetails>> call = service.getPostedTasks(PostedBy);
        call.enqueue(new Callback<List<ClassTaskDetails>>() {
            @Override
            public void onResponse(Call<List<ClassTaskDetails>> call, Response<List<ClassTaskDetails>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<ClassTaskDetails> tasks = response.body();
                    makeToast(context,"Retreived Posted Tasks" + tasks.size());
                    callback.onResponse(tasks);
                }
            }
            @Override
            public void onFailure(Call<List<ClassTaskDetails>> call, Throwable t) {
                makeToast(context, "Failed to retreive from database");
            }
        });
    }
    public void getPendingTasks(String Resolver, Context context, getTasksCallback callback) {
        Call<List<ClassTaskDetails>> call = service.getPendingTasks(Resolver);
        call.enqueue(new Callback<List<ClassTaskDetails>>() {
            @Override
            public void onResponse(Call<List<ClassTaskDetails>> call, Response<List<ClassTaskDetails>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<ClassTaskDetails> tasks = response.body();
                    makeToast(context,"Retreived Pending Tasks" + tasks.size());
                    callback.onResponse(tasks);
                }
            }
            @Override
            public void onFailure(Call<List<ClassTaskDetails>> call, Throwable t) {
                makeToast(context, "Failed to retreive from database");
            }
        });
    }
}

