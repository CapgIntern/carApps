package net.santosh.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import net.santosh.springboot.model.Car;
import net.santosh.springboot.model.ForSale;
import net.santosh.springboot.service.IForSaleServiceImpl;

@Api(value = "Swagger2DemoRestController")
@RestController
@RequestMapping("/sale")
public class ForSaleController {

	@Autowired
	private IForSaleServiceImpl iForSaleService;
	
	@GetMapping("/onsale")
	public ResponseEntity<List<Car>> getAllSales() {
		return ResponseEntity.ok().body(iForSaleService.getAllSales());
	}
	
	@GetMapping("/salebyid/{saleId}")
	public ResponseEntity<ForSale> getSaleById(@PathVariable("saleId") long saleId) {
		return ResponseEntity.ok().body(iForSaleService.getSale(saleId));
	}
	
	@GetMapping("/salebycarid/{carId}")
	public ResponseEntity<ForSale> getSaleByCarId(@PathVariable("carId") long carId) {
		return ResponseEntity.ok().body(iForSaleService.getSaleByCarId(carId));
	}
	
	@PostMapping("/addsale")
	public ResponseEntity<ForSale> addCar(@RequestBody ForSale forSale) {
		return ResponseEntity.ok().body(this.iForSaleService.addSale(forSale));
	}
	
	@PutMapping("/updatesale/{saleId}/{cost}")
	public ResponseEntity<ForSale> updateCar(@PathVariable("saleId") long saleId, @PathVariable("cost") long cost) {
		return ResponseEntity.ok().body(this.iForSaleService.updateSale(cost, saleId));
	}
	
	@DeleteMapping("/sale/{salId}")
	public HttpStatus removeCar(@PathVariable("saleId") long saleId) {
		this.iForSaleService.removeSale(saleId);
		return HttpStatus.OK;
	}
}
