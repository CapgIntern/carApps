//package net.santosh.springboot.service;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import net.santosh.springboot.exception.ResourceNotFoundException;
//import net.santosh.springboot.model.Car;
//import net.santosh.springboot.model.MyCars;
//import net.santosh.springboot.repository.ICarRepository;
//import net.santosh.springboot.repository.IMyCarsRepository;
//
//@Service
//@Transactional
//public class IMyCarsServiceImpl implements IMyCarsService {
//
//	@Autowired
//	private ICarRepository iCarRepository;
//
//	@Autowired
//	private IMyCarsRepository iMyCarsRepository;
//
//	@Override
//	public MyCars addCar(MyCars myCars) {
//		return iMyCarsRepository.save(myCars);
//	}
//
//	@Override
//	public void deleteCars(long id) {
//		Optional<MyCars> carList = this.iMyCarsRepository.findById(id);
//
//		if (carList.isPresent()) {
//			this.iMyCarsRepository.delete(carList.get());
//		} else {
//			throw new ResourceNotFoundException("Car not found with ID :" + id);
//		}
//	}
//
//	@Override
//	public List<Car> getMyCars(String user) {
//		List<MyCars> carList = this.iMyCarsRepository.findByUserId(user);
//		List<Car> myCarsList = new ArrayList<Car>();
//		if (carList.isEmpty()) {
//			throw new ResourceNotFoundException("Car not found with ID :" + user);
//			}
////		if (carList.isPresent()) {
////			carList.stream().forEach(values -> {
////				myCarsList.add(this.iCarRepository.findById(values.getCarId()).get());
////			});
//		else {
//			carList.stream().forEach(values -> {
//				myCarsList.add(this.iCarRepository.findById(values.getCarId()).get());});
//			return myCarsList;
//		}
//	}
//
//}
