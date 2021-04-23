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
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import net.santosh.springboot.model.Card;
import net.santosh.springboot.service.ICardServiceImpl;

@Api(value = "Swagger2DemoRestController")
@RestController
public class CardController {
	@Autowired
	ICardServiceImpl iCardService;

	@GetMapping("/cardbyuserid/{userId}")
	public ResponseEntity<List<Card>> getAddressByUserId(@PathVariable("userId") String userId) {
		return ResponseEntity.ok().body(iCardService.getAllCard(userId));
	}
	
	@GetMapping("/cardbyid/{cardid}")
	public ResponseEntity<Card> getCard(@PathVariable("cardid") long cardId) {
		return ResponseEntity.ok().body(iCardService.getCard(cardId));
	}
	
	@PostMapping("/addcard")
	public ResponseEntity<Card> addAddress(@RequestBody Card card) {
		return ResponseEntity.ok().body(this.iCardService.addCard(card));
	}
	
	@PutMapping("/updatecard/{cardid}")
	public ResponseEntity<Card> updateAddress(@RequestBody Card card, @PathVariable("cardid") long cardId) {
		return ResponseEntity.ok().body(this.iCardService.updateCard(card, cardId));
	}
	
	@DeleteMapping("/card/{cardid}")
	public HttpStatus removeAddress(@PathVariable("cardid") long cardId) {
		this.iCardService.removeCard(cardId);
		return HttpStatus.OK;
	}
}
