package TaskTwo;

public class TaskTwo {
    public static void main(String[] args) {
        BankAccount account = new BasicBankAccount();
        BankAccount decoratedAccount = new BankAccountWithdrawLimit(account, 1000);

        decoratedAccount.deposit(2000);
        System.out.println("Баланс: " + decoratedAccount.getBalance());

        decoratedAccount.withdraw(500);
        System.out.println("Баланс: " + decoratedAccount.getBalance());

        decoratedAccount.withdraw(1500);
        System.out.println("Баланс: " + decoratedAccount.getBalance());
    }
}

