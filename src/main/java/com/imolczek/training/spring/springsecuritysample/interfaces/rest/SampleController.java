package com.imolczek.training.spring.springsecuritysample.interfaces.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imolczek.training.spring.springsecuritysample.interfaces.rest.resources.AccountResource;
import com.imolczek.training.spring.springsecuritysample.services.AccountsService;

@RestController
@RequestMapping("/sample/api/v1")
public class SampleController {

	private static Logger logger = LoggerFactory.getLogger(SampleController.class);

	private AccountsService accountsService;
	
	public SampleController(AccountsService accountsService) {
		this.accountsService = accountsService;
	}
	
	/**
	 * This method has no authorization requirement
	 * An anonymous user may call this method
	 * @return pong
	 */
	@GetMapping("/ping")
	public String ping() {
		return "pong";
	}
	
	/**
	 * List accounts
	 * @return List of accounts
	 */
	@GetMapping("/accounts")
	public List<AccountResource> accounts(String subject) {
		List<AccountResource> accounts = accountsService.list(subject);
		return accounts;
	}

	/**
	 * Account details
	 * @param accountNumber The account number
	 * @return List of accounts
	 */
	@GetMapping("/accounts/{accountNumber}")
	public AccountResource accountDetails(@PathVariable String accountNumber) {
		return accountsService.details(accountNumber);
	}
	
}
