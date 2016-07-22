package com.example.home.myapplication.service;

import com.example.home.myapplication.vo.ProdcutHistory;

import java.util.List;

public interface IECManager {
	 void addProductToHistory(ProdcutHistory history);
	 void clearProductHistory();
	 List<ProdcutHistory> getAllProductHistory();
}



