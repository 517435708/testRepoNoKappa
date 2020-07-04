package com.rentingapp.rentcar.modules.renting;

import com.rentingapp.rentcar.modules.car.entity.Car;
import com.rentingapp.rentcar.modules.car.CarRepository;
import com.rentingapp.rentcar.modules.client.entity.Client;
import com.rentingapp.rentcar.modules.client.ClientRepository;
import com.rentingapp.rentcar.modules.renting.entity.Renting;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class RentingService {

    private final RentingRepository rentingRepository;
    private final ClientRepository clientRepository;
    private final CarRepository carRepository;

    public Renting addRenting(Map<String,String> rent)
    {
        int idCar = Integer.parseInt(rent.get("car"));
        Car car = carRepository.findById(idCar).orElseThrow();
        int idClient = Integer.parseInt(rent.get("client"));
        Client client = clientRepository.findById(idClient).orElseThrow();
        return rentingRepository.save(new Renting(car,client));
    }
    public Renting getRenting(int id)
    {
        return rentingRepository.findById(id).get();
    }
}
