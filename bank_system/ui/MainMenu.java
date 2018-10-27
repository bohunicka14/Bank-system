
package bank_system.ui;

/**
 *
 * @author Inka
 */

import bank_system.rdg.Account;
import bank_system.rdg.AccountFinder;
import bank_system.rdg.AccountType;
import bank_system.rdg.AccountTypeFinder;
import bank_system.rdg.Card;
import bank_system.rdg.CardFinder;
import bank_system.rdg.CardPaymentsStatisticsFinder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import bank_system.rdg.Customer;
import bank_system.rdg.CustomerFinder;
import bank_system.rdg.Insurance;
import bank_system.rdg.Operation;
import bank_system.rdg.OperationFinder;
import bank_system.rdg.SendingTaxStatisticsFinder;
import bank_system.rdg.SentAmountStatisticsFinder;
import bank_system.rdg.StandingOrder;
import java.math.BigDecimal;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
//import sk.shanki.db2.application.rdg.FreeCallStatisticFinder;
//import sk.shanki.db2.application.ts.CallException;
//import sk.shanki.db2.application.ts.CallService;
//import sk.shanki.db2.application.ts.CallSimulator;


public class MainMenu extends Menu {

    @Override
    public void print() {
        System.out.println("*********************************************");
        System.out.println("* 1. list all the customers' functions      *");
        System.out.println("* 2. list all the accounts' functions       *");
        System.out.println("* 3. list all the cards' functions          *");
        System.out.println("* 4. list all the operations' functions     *");
        System.out.println("* 5. list all domain functions              *");
        System.out.println("* 6. list all statistics functions          *");
        System.out.println("* 7. exit                                   *");
        System.out.println("*********************************************");
    }
    
    public void printSubMenuStatistics() {
        System.out.println("*********************************");
        System.out.println("* 1. card payments statistics   *");
        System.out.println("* 2. sending tax statistics     *");
        System.out.println("* 3. average received amount    *");
        System.out.println("* 4. exit                       *");
        System.out.println("*********************************");
       
    }
    
    public void printSubMenuCustomers() {
        System.out.println("*********************************");
        System.out.println("* 1. list all the customers     *");
        System.out.println("* 2. show a customer            *");
        System.out.println("* 3. add a customer             *");
        System.out.println("* 4. edit a customer            *");
        System.out.println("* 5. delete a customer          *");
        System.out.println("* 6. exit                       *");
        System.out.println("*********************************");
       
    }
    
    public void printSubMenuAccounts() {
        System.out.println("*********************************");
        System.out.println("* 1. list all the accounts      *");
        System.out.println("* 2. show an account            *");
        System.out.println("* 3. add an account             *");
        System.out.println("* 4. edit an account            *");
        System.out.println("* 5. delete an account          *");
        System.out.println("* 6. exit                       *");
        System.out.println("*********************************");
       
    }
    
    
    public void printSubMenuCards() {
        System.out.println("*********************************");
        System.out.println("* 1. list all the cards         *");
        System.out.println("* 2. show a card                *");
        System.out.println("* 3. add a card                 *");
        System.out.println("* 4. edit a card                *");
        System.out.println("* 5. delete a card              *");
        System.out.println("* 6. exit                       *");
        System.out.println("*********************************");
       
    }

    public void printSubMenuOperations() {
        System.out.println("*********************************");
        System.out.println("* 1. list all the operations    *");
        System.out.println("* 2. list account's operations  *");
        System.out.println("* 3. exit                       *");
        System.out.println("*********************************");
       
    }
    
     public void printSubMenuDomainFunctions() {
        System.out.println("*************************************");
        System.out.println("* 1. add insurance to account       *");
        System.out.println("* 2. add standing order to account  *");
        System.out.println("* 3. exit                           *");
        System.out.println("*************************************");
       
    }
    
    @Override
    public void handle(String option) {
        try {
            switch (option) {
                case "1":   printSubMenuCustomers(); listCustomersSubMenu(); break;
                case "2":   printSubMenuAccounts(); listAccountsSubMenu(); break;
                case "3":   printSubMenuCards(); listCardsSubMenu(); break;
                case "4":   printSubMenuOperations(); listOperationsSubMenu(); break;
                case "5":   printSubMenuDomainFunctions(); listDomainFunctionsSubMenu(); break;
                case "6":   printSubMenuStatistics(); listStatisticsFunctionsSubMenu(); break;
                case "7":   exit(); break;
                default:    System.out.println("Unknown option"); break;
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }

    }

//  ---------------------------------------statistics functions------------------------------------------

    private void listStatisticsFunctionsSubMenu() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String option = br.readLine();
        System.out.println();
        
        try {
            switch (option) {
                case "1":   showCardPaymentsStatistics(); break;
                case "2":   showSendingTaxStatistics(); break;
                case "3":   showSentAmountStatistics(); break;
                case "4":   exit(); break;
                default:    System.out.println("Unknown option"); break;
            }
        } catch(SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    
    }
    
    
    private void showCardPaymentsStatistics() throws SQLException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.print("Enter an account's number: ");
        int accountNumber = Integer.parseInt(br.readLine());
        CardPaymentsStatisticsPrinter.getInstance().print(CardPaymentsStatisticsFinder.getInstance().findAll(accountNumber));
    }
    
    private void showSentAmountStatistics() throws SQLException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.print("Enter an account's number: ");
        int accountNumber = Integer.parseInt(br.readLine());
        SentAmountStatisticsPrinter.getInstance().print(SentAmountStatisticsFinder.getInstance().findAll(accountNumber));
    }
    
    private void showSendingTaxStatistics() throws SQLException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter an account's number: ");
        int accountNumber = Integer.parseInt(br.readLine());
        SendingTaxStatisticsPrinter.getInstance().print(SendingTaxStatisticsFinder.getInstance().findAll(accountNumber));
    }

//  ---------------------------------------domain functions------------------------------------------
    

    private void listDomainFunctionsSubMenu() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String option = br.readLine();
        System.out.println();
        
        try {
            switch (option) {
                case "1":   addInsurance(); break;
                case "2":   addStandingOrder(); break;
                case "3":   break;
                case "4":   break;
                case "5":   break;
                case "6":   exit(); break;
                default:    System.out.println("Unknown option"); break;
            }
        } catch(SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    
    }
    
    private void addInsurance() throws IOException, SQLException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.print("Enter an account's number: ");
        int accountNumber = Integer.parseInt(br.readLine());

        Account account = AccountFinder.getInstance().findByNumber(accountNumber);
        
        if (account == null) {
            System.out.println("No such account exists");
        } else {
            AccountPrinter.getInstance().print(account);
            
            System.out.print("Enter duration of insurance in days: ");
            int duration = Integer.parseInt(br.readLine());
            
            System.out.print("Enter description of insurance: ");
            String description = br.readLine();
            
            System.out.print("Enter price of insurance: ");
            int price = Integer.parseInt(br.readLine());
            
            Insurance insurance = new Insurance();
            insurance.setStart_date(new java.sql.Date(Calendar.getInstance().getTime().getTime()));
            insurance.setDuration(duration);
            insurance.setDescription(description);
            insurance.setPrice(price);
            
            insurance.insert();
            account.setId_insurance(insurance.getId());
            account.update();
            
            System.out.println("The insurance has been sucessfully added to the account.");
        }

    }
    
    private void addStandingOrder() throws IOException, SQLException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.print("Enter a sender account's number: ");
        int senderNumber = Integer.parseInt(br.readLine());

        Account sender = AccountFinder.getInstance().findByNumber(senderNumber);
        
        if (sender == null) {
            System.out.println("No such account exists");
        } else {
            AccountPrinter.getInstance().print(sender);
            
            System.out.print("Enter a recipient account's number: ");
            int recipientNumber = Integer.parseInt(br.readLine());
            Account recipient = AccountFinder.getInstance().findByNumber(recipientNumber);
            
            if (recipient == null) {
                System.out.print("No such account exists");
            } else {
                
                System.out.print("Enter amount: ");
                BigDecimal amount = new BigDecimal(br.readLine());

                System.out.print("Enter issue date: ");
                int issueDate = Integer.parseInt(br.readLine());

                StandingOrder so = new StandingOrder();
                so.setAmount(amount);
                so.setIssue_date(issueDate);
                so.setId_recipient(recipient.getId());
                so.setId_sender(sender.getId());

                so.insert();
                
                System.out.println("The standing order has been sucessfully added to the account.");
            }
            
        }

    }

//    -------------------------------------customers----------------------------------------------
    
    private void listCustomersSubMenu() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String option = br.readLine();
        System.out.println();
        
        try {
            switch (option) {
                case "1":   listAllCustomers(); break;
                case "2":   showACustomer(); break;
                case "3":   addACustomer(); break;
                case "4":   editACustomer(); break;
                case "5":   deleteACustomer(); break;
                case "6":   exit(); break;
                default:    System.out.println("Unknown option"); break;
            }
        } catch(SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    
    }
    
    private void listAllCustomers() throws SQLException {
        for (Customer customer : CustomerFinder.getInstance().findAll()) {
            CustomerPrinter.getInstance().print(customer);
        }
    }

    private void showACustomer() throws IOException, SQLException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.print("Enter a customer's id: ");
        int customerId = Integer.parseInt(br.readLine());

        Customer customer = CustomerFinder.getInstance().findById(customerId);
        
        if (customer == null) {
            System.out.println("No such customer exists");
        } else {
            CustomerPrinter.getInstance().print(customer);
        }

    }


    private void addACustomer() throws IOException, SQLException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        Customer customer = new Customer();
        
        System.out.print("Enter first name: ");
        customer.setFirstName(br.readLine());
        System.out.print("Enter last name: ");
        customer.setLastName(br.readLine());
        System.out.print("Enter birth number: ");
        customer.setBirthNumber(br.readLine());
        System.out.print("Enter status: ");
        customer.setStatus(br.readLine());
        
        customer.insert();
        
        System.out.println("The customer has been sucessfully added");
        System.out.print("The customer's id is: ");
        System.out.println(customer.getId());
    }

    private void editACustomer() throws IOException, SQLException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.print("Enter a customer's id: ");
        int customerId = Integer.parseInt(br.readLine());

        Customer customer = CustomerFinder.getInstance().findById(customerId);
        
        if (customer == null) {
            System.out.println("No such customer exists");
        } else {
            CustomerPrinter.getInstance().print(customer);

            System.out.print("Enter first name: ");
            customer.setFirstName(br.readLine());
            System.out.print("Enter last name: ");
            customer.setLastName(br.readLine());
            System.out.print("Enter birth number: ");
            customer.setBirthNumber(br.readLine());
            System.out.print("Enter status: ");
            customer.setStatus(br.readLine());

            customer.update();

            System.out.println("The customer has been successfully updated");
        }
    }

    private void deleteACustomer() throws SQLException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.print("Enter a customer's birth number: ");
        String customerBirthNumber = br.readLine();

        Customer customer = CustomerFinder.getInstance().findByBirthNumber(customerBirthNumber);
        
        if (customer == null) {
            System.out.println("No such customer exists");
        } else {
            customer.delete();
            System.out.println("The customer has been successfully deleted");
        }
    }

// --------------------------------accounts-------------------------------------------------
    private void listAccountsSubMenu() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String option = br.readLine();
        System.out.println();
        
        try {
            switch (option) {
                case "1":   listAllAccounts(); break;
                case "2":   showAnAccount(); break;
                case "3":   addAnAccount(); break;
                case "4":   editAnAccount(); break;
                case "5":   deleteAnAccount(); break;
                case "6":   exit(); break;
                default:    System.out.println("Unknown option"); break;
            }
        } catch(SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    
    }
    
    private void listAllAccounts() throws SQLException {
        for (Account account : AccountFinder.getInstance().findAll()) {
            AccountPrinter.getInstance().print(account);
        }
    }

    private void showAnAccount() throws IOException, SQLException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.print("Enter an account's number: ");
        int accountNumber = Integer.parseInt(br.readLine());

        Account account = AccountFinder.getInstance().findByNumber(accountNumber);
        
        if (account == null) {
            System.out.println("No such account exists");
        } else {
            AccountPrinter.getInstance().print(account);
        
        }
        
    }


    private void addAnAccount() throws IOException, SQLException {
       
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        Account account = new Account();
        
        System.out.print("Enter number: ");
        account.setNumber(Integer.parseInt(br.readLine()));
        
        account.setDeposit(new BigDecimal(0.0));
        
        account.setValid_from(new java.sql.Date(Calendar.getInstance().getTime().getTime()));
        
        System.out.print("Enter interest rate: ");
        account.setInterest_rate(new BigDecimal(br.readLine()));
        
        System.out.print("Enter account type: ");
        
        String accountType = br.readLine();
        try{
            AccountType at = AccountTypeFinder.getInstance().findByName(accountType);
            account.setId_charges(at.getId());
        }
        catch(Exception e){
            System.out.println("Such account type does not exist!");
            return;
        }
        
        System.out.print("Enter customer's birth number: ");
        String number = br.readLine();
        try{
            Customer customer = CustomerFinder.getInstance().findByBirthNumber(number);
            account.setId_customer(customer.getId());
        }
        catch(Exception e){
            System.out.println("Such customer does not exist!");
            return;
        }
        
        account.setId_insurance(null);      
        account.insert();
        
        System.out.println("The account has been sucessfully added");
        System.out.print("The account's id is: ");
        System.out.println(account.getId());
    }

    private void editAnAccount() throws IOException, SQLException {
        //        private Integer id;
//    private Integer number;
//    private BigDecimal deposit;
//    private Date valid_from;
//    private BigDecimal interest_rate;
//    private Integer id_charges;
//    private Integer id_customer;
//    private Integer id_insurance;
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.print("Enter an account's number: ");
        int accountNumber = Integer.parseInt(br.readLine());

        Account account = AccountFinder.getInstance().findByNumber(accountNumber);
        
        if (account == null) {
            System.out.println("No such account exists");
        } else {
            AccountPrinter.getInstance().print(account);

            System.out.print("Enter account type: ");
        
            String accountType = br.readLine();
            try{
                AccountType at = AccountTypeFinder.getInstance().findByName(accountType);
                account.setId_charges(at.getId());
                account.update();
            }
            catch(Exception e){
                System.out.println("Such account type does not exist!");
                return;
            }

            System.out.println("The account has been successfully updated");
        }
    }

    private void deleteAnAccount() throws SQLException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.print("Enter an account's id: ");
        String accountId = br.readLine();

        Account account = AccountFinder.getInstance().findById(Integer.parseInt(accountId));
        
        if (account == null) {
            System.out.println("No such account exists");
        } else {
            account.delete();
            System.out.println("The account has been successfully deleted");
        }
    }
    
    
    // -------------------------------------------cards-----------------------------------------------------------
    
     private void listCardsSubMenu() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String option = br.readLine();
        System.out.println();
        
        try {
            switch (option) {
                case "1":   listAllCards(); break;
                case "2":   showACard(); break;
                case "3":   addACard(); break;//add 
                case "4":   editACard(); break;//edit
                case "5":   deleteACard(); break;
                case "6":   exit(); break;
                default:    System.out.println("Unknown option"); break;
            }
        } catch(SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    
    }
    
    private void listAllCards() throws SQLException {
        for (Card card : CardFinder.getInstance().findAll()) {
            CardPrinter.getInstance().print(card);
        }
    }

    private void showACard() throws IOException, SQLException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.print("Enter account number: ");
        int accountId = Integer.parseInt(br.readLine());

        List<Card> cards = CardFinder.getInstance().findByAccount(accountId);
        
        if (cards != null) {
            for (Card card : cards){
                CardPrinter.getInstance().print(card);
            }
        }

    }


    private void addACard() throws IOException, SQLException {
               
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        Card card = new Card();
        
        System.out.print("Enter number: ");
        card.setNumber(Integer.parseInt(br.readLine()));
        card.setValid_from(new java.sql.Date(Calendar.getInstance().getTime().getTime()));
        
        Calendar c = Calendar.getInstance();
        c.add(Calendar.YEAR, 5);
        card.setValid_till(new java.sql.Date(c.getTime().getTime()));
       
        System.out.print("Enter account number: ");
        Account account = AccountFinder.getInstance().findByNumber(Integer.parseInt(br.readLine()));
        if (account ==  null){
            System.out.println("Account with given number does not exist!");
            return;
        }
        card.setId_account(account.getId());
        
        card.insert();
        
        System.out.println("The card has been sucessfully added");
        System.out.print("The card's id is: ");
        System.out.println(card.getId());
    }

    private void editACard() throws IOException, SQLException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.print("Enter a card's number: ");
        int cardNumber = Integer.parseInt(br.readLine());

        Card card = CardFinder.getInstance().findByNumber(cardNumber);
        
        if (card == null) {
            System.out.println("No such card exists");
        } else {
            CardPrinter.getInstance().print(card);

            System.out.print("Enter till date (format must be yyyy-MM-dd): ");
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            try{
                Date parsed = format.parse(br.readLine());
                java.sql.Date sql = new java.sql.Date(parsed.getTime());
                card.setValid_till(sql);
                card.update();
            }
            catch(ParseException e){
                System.out.println("Given wrong date format");
                return;
            }

            System.out.println("The card has been successfully updated");
        }
    }

    private void deleteACard() throws SQLException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.print("Enter a card's id: ");
        String cardId = br.readLine();

        Card card = CardFinder.getInstance().findById(Integer.parseInt(cardId));
        
        if (card == null) {
            System.out.println("No cards for enterred account.");
        } else {
            card.delete();
            System.out.println("The card has been successfully deleted");
        }
    }
    
    
    //  ------------------------------------------operations------------------------------------------------------

    private void listOperationsSubMenu() throws IOException{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String option = br.readLine();
            System.out.println();

            try {
                switch (option) {
                    case "1":   listAllOperations(); break;
                    case "2":   listAnOperation(); break;
                    case "3":   exit(); break;
                    default:    System.out.println("Unknown option"); break;
                }
            } catch(SQLException e) {
                throw new RuntimeException(e);
            }

    }
    
    private void listAnOperation() throws SQLException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.print("Enter an account's number: ");
        int accountNumber = Integer.parseInt(br.readLine());

        Account account = AccountFinder.getInstance().findByNumber(accountNumber);
        
        if (account == null) {
            System.out.println("No such account exists");
        } else {
            for (Operation operation : OperationFinder.getInstance().findByAccount(account.getId())) {
                OperationPrinter.getInstance().print(operation);
            }
        
        }
            
            
    }
    
    private void listAllOperations() throws SQLException {
        for (Operation operation : OperationFinder.getInstance().findAll()) {
            OperationPrinter.getInstance().print(operation);
        }
    }

    
}



