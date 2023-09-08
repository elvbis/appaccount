package com.polyglot.appaccount.respository;

import com.polyglot.appaccount.model.AccountModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAccountRepository extends CrudRepository<AccountModel,Integer> {

}
