package com.suggestion.daointerface;

import java.util.ArrayList;

import com.suggestion.model.Suggestion;

public interface SuggestionInterface {
	 boolean addCookies(Suggestion cookies);
	 boolean updateCookies(Suggestion cookies);
	 Suggestion getCookies(int fileid);
	 ArrayList<Suggestion> getsCookies(Suggestion cookies);

}
