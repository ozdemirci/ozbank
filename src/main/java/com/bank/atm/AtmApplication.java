package com.bank.atm;

import com.bank.atm.model.Account;
import com.bank.atm.model.City;
import com.bank.atm.model.Currency;
import com.bank.atm.model.Customer;
import com.bank.atm.repository.AccountRepository;
import com.bank.atm.repository.CustomerRepository;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Date;


@SpringBootApplication
public class AtmApplication implements CommandLineRunner {
	private final AccountRepository accountRepository;
	private final CustomerRepository customerRepository;
	Faker faker=new Faker();

	public AtmApplication(AccountRepository accountRepository, CustomerRepository customerRepository) {
		this.accountRepository = accountRepository;
		this.customerRepository = customerRepository;
	}


	public static void main(String[] args) {
		SpringApplication.run(AtmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {





			Customer c1 = Customer.builder()
					.id("id1")
					.city(City.ANKARA)
					.name(faker.name().fullName())
					.adress(faker.address().fullAddress())
					.dateOfBirth(faker.date().between(new Date(1950,1,1),new Date(2023,1,1)).getYear())
					.build();
			Customer c2 = Customer.builder()
					.id("id2")
					.city(City.ANKARA)
					.name(faker.name().fullName())
					.adress(faker.address().fullAddress())
					.dateOfBirth(faker.date().between(new Date(1950,1,1),new Date(2023,1,1)).getYear())
					.build();

			Customer c3 = Customer.builder()
					.id("id3")
					.city(City.ANKARA)
					.name(faker.name().fullName())
					.adress(faker.address().fullAddress())
					.dateOfBirth(faker.date().between(new Date(1950,1,1),new Date(2023,1,1)).getYear())
					.build();
			Customer c4 = Customer.builder()
					.id("id4")
					.city(City.ANKARA)
					.name(faker.name().fullName())
					.adress(faker.address().fullAddress())
					.dateOfBirth(faker.date().between(new Date(1950,1,1),new Date(2023,1,1)).getYear())
					.build();
			Customer c5 = Customer.builder()
					.id("id5")
					.city(City.ANKARA)
					.name(faker.name().fullName())
					.adress(faker.address().fullAddress())
					.dateOfBirth(faker.date().between(new Date(1950,1,1),new Date(2023,1,1)).getYear())
					.build();
			Customer c6 = Customer.builder()
					.id("id6")
					.city(City.ANKARA)
					.name(faker.name().fullName())
					.adress(faker.address().fullAddress())
					.dateOfBirth(faker.date().between(new Date(1950,1,1),new Date(2023,1,1)).getYear())
					.build();
			Customer c7 = Customer.builder()
					.id("id7")
					.city(City.ANKARA)
					.name(faker.name().fullName())
					.adress(faker.address().fullAddress())
					.dateOfBirth(faker.date().between(new Date(1950,1,1),new Date(2023,1,1)).getYear())
					.build();
			Customer c8 = Customer.builder()
					.id("id8")
					.city(City.ANKARA)
					.name(faker.name().fullName())
					.adress(faker.address().fullAddress())
					.dateOfBirth(faker.date().between(new Date(1950,1,1),new Date(2023,1,1)).getYear())
					.build();
			Customer c9 = Customer.builder()
					.id("id9")
					.city(City.ANKARA)
					.name(faker.name().fullName())
					.adress(faker.address().fullAddress())
					.dateOfBirth(faker.date().between(new Date(1950,1,1),new Date(2023,1,1)).getYear())
					.build();
			Customer c10 = Customer.builder()
					.id("id10")
					.city(City.ANKARA)
					.name(faker.name().fullName())
					.adress(faker.address().fullAddress())
					.dateOfBirth(faker.date().between(new Date(1950,1,1),new Date(2023,1,1)).getYear())
					.build();
			customerRepository.saveAll( Arrays.asList(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10) );






			Account a1 = Account.builder()
					.customerId("id1")
					.id(faker.idNumber().valid())
					.city(City.ANKARA)
					.balance(faker.number().randomDouble(2,0,10_000))
					.currency(Currency.USD)
					.build();
			Account a2 = Account.builder()
					.customerId("id2")
					.id(faker.idNumber().valid())
					.city(City.ANKARA)
					.balance(faker.number().randomDouble(2,0,10_000))
					.currency(Currency.TRY)
					.build();
			Account a3 = Account.builder()
					.customerId("id3")
					.id(faker.idNumber().valid())
					.city(City.ANKARA)
					.balance(faker.number().randomDouble(2,0,10_000))
					.currency(Currency.USD)
					.build();
			Account a4 = Account.builder()
					.customerId("id4")
					.id(faker.idNumber().valid())
					.city(City.ANKARA)
					.balance(faker.number().randomDouble(2,0,10_000))
					.currency(Currency.USD)
					.build();
			Account a5 = Account.builder()
					.customerId("id5")
					.id(faker.idNumber().valid())
					.city(City.ANKARA)
					.balance(faker.number().randomDouble(2,0,10_000))
					.currency(Currency.USD)
					.build();
			Account a6 = Account.builder()
					.customerId("id6")
					.id(faker.idNumber().valid())
					.city(City.ANKARA)
					.balance(faker.number().randomDouble(2,0,10_000))
					.currency(Currency.USD)
					.build();
			Account a7 = Account.builder()
					.customerId("id7")
					.id(faker.idNumber().valid())
					.city(City.ANKARA)
					.balance(faker.number().randomDouble(2,0,10_000))
					.currency(Currency.USD)
					.build();
			Account a8 = Account.builder()
					.customerId("id8")
					.id(faker.idNumber().valid())
					.city(City.ANKARA)
					.balance(faker.number().randomDouble(2,0,10_000))
					.currency(Currency.USD)
					.build();
			Account a9 = Account.builder()
					.customerId("id9")
					.id(faker.idNumber().valid())
					.city(City.ANKARA)
					.balance(faker.number().randomDouble(2,0,10_000))
					.currency(Currency.TRY)
					.build();
			Account a10 = Account.builder()
					.customerId("id10")
					.id(faker.idNumber().valid())
					.city(City.ANKARA)
					.balance(faker.number().randomDouble(2,0,10_000))
					.currency(Currency.TRY)
					.build();

			accountRepository.saveAll( Arrays.asList(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10) );




	}
}
