package net.santosh.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.santosh.springboot.exception.ModelAddException;
import net.santosh.springboot.exception.ModelEmptyListException;
import net.santosh.springboot.exception.ModelUpdateException;
import net.santosh.springboot.exception.ResourceNotFoundException;
import net.santosh.springboot.model.Address;
import net.santosh.springboot.model.Card;
import net.santosh.springboot.repository.ICardRepository;

@Service
@Transactional
public class ICardServiceImpl implements ICardService {

	@Autowired
	private ICardRepository iCardRepository;
	
	@Override
	public Card addCard(Card card) {
		try {
			return iCardRepository.save(card);
		} catch (Exception e) {
			throw new ModelAddException("Can't add Card, please add the proper details");
		}
	}

	@Override
	public void removeCard(long cardId) {
		Optional<Card> cardList = this.iCardRepository.findById(cardId);

		if (cardList.isPresent()) {
			this.iCardRepository.delete(cardList.get());
		} else {
			throw new ResourceNotFoundException("cannot find the card");
		}
	}

	@Override
	public List<Card> getAllCard(String userId) {
		try {
			return (List<Card>) iCardRepository.findByUserId(userId);
		} catch (Exception e) {
			throw new ModelEmptyListException("Error retriving Card...please try again");
		}
	}

	@Override
	public Card updateCard(Card card, long cardId) {
		try {
			Optional<Card> cardlist = this.iCardRepository.findById(cardId);
			if (cardlist.isPresent()) {
				Card cardUpdate = cardlist.get();
				cardUpdate.setCardName(card.getCardName());
				cardUpdate.setCardNumber(card.getCardNumber());
				cardUpdate.setCardExpiry(card.getCardExpiry());
				cardUpdate.setCvv(card.getCvv());
				return cardUpdate;
			} else {
				throw new ResourceNotFoundException("Card not found");
			}
		} catch (Exception e) {
			throw new ModelUpdateException("Couldn't update the card, please try again ");
		}
	}

	@Override
	public Card getCard(long cardId) {
		try {
			Optional<Card> cardlist = this.iCardRepository.findById(cardId);
			if (cardlist.isPresent()) {
				Card card = cardlist.get();
				return card;
			} else {
				throw new ResourceNotFoundException("Card not found");
			}
		} catch (Exception e) {
			throw new ModelUpdateException("Couldn't update the card, please try again ");
		}
	}

}
