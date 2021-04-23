package net.santosh.springboot.service;

import java.util.List;

import net.santosh.springboot.model.Card;

public interface ICardService {
	public Card addCard(Card card);

	public void removeCard(long cardId);
	
	public List<Card> getAllCard(String userId);
	
	public Card updateCard(Card card, long cardId);
	
	public Card getCard(long cardId);
}
