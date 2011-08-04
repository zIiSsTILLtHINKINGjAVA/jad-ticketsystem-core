package be.intecbrussel.jad.services;

import be.intecbrussel.jad.model.data.AccountDAO;
import be.intecbrussel.jad.model.entities.Account;


/**
 *
 * @author ZI
 */
public class AccountService  extends GenericService<Account> {
    private AccountDAO accountDAO;

    public AccountDAO getUserDAO() {
        return accountDAO;
    }

    public void setUserDAO(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    public AccountService() {
        super();
        this.accountDAO = (AccountDAO) new AccountDAO();
    }
}
