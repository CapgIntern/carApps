package net.santosh.springboot.service;

import java.util.List;

import net.santosh.springboot.model.ForSale;

public interface IForSaleService {

	public ForSale addSale(ForSale forSale);

	public void removeSale(long saleId);

	public ForSale updateSale(double cost, long saleId);

	public ForSale getSale(long saleId);

	public List<ForSale> getAllSales();
}