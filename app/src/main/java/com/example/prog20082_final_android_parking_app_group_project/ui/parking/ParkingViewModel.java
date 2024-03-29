package com.example.prog20082_final_android_parking_app_group_project.ui.parking;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.prog20082_final_android_parking_app_group_project.db.ParkingRepository;
import com.example.prog20082_final_android_parking_app_group_project.parking_model.Parking;

import java.util.List;

public class ParkingViewModel extends AndroidViewModel {

    private MutableLiveData<String> mText;
    private LiveData<List<Parking>> allParking;
    private ParkingRepository parkingRepository;


    public ParkingViewModel(@NonNull Application application) {
        super(application);
        mText = new MutableLiveData<>();
        parkingRepository = new ParkingRepository(application);
        allParking = parkingRepository.getAllParking();
    }

    public void insert(Parking parking){
        parkingRepository.insert(parking);
    }

    public LiveData<List<Parking>> getAllParking(){
        return allParking;
    }

    public LiveData<String> getText() {
        return mText;
    }
}