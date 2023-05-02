package TaskTwo;

class BankAccountWithdrawLimit implements BankAccount {
    private BankAccount account;
    private double withdrawLimit;

    public BankAccountWithdrawLimit(BankAccount account, double withdrawLimit) {
        this.account = account;
        this.withdrawLimit = withdrawLimit;
    }

    public void deposit(double amount) {
        account.deposit(amount);
    }

    public void withdraw(double amount) {
        if (amount > withdrawLimit && amount <= account.getBalance()) {
            System.out.println("Сумма снятия "+amount);
            account.withdraw(amount);
            System.out.println(account.getBalance());
        } else {
            if(amount > account.getBalance())
            {
                System.out.println("Сумма превышает баланс карты ");
            }
            else {
                account.withdraw(amount);
            }

        }
    }

    public double getBalance() {
        return account.getBalance();
    }
}