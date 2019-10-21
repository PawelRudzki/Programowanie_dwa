package job_interview_task;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Account implements Comparable<Account> {
    private String iban;
    private String name;
    private String currency;
    private String balance;
    private String closingDate;

    @Override
    public int compareTo(Account anotherAccount) {
        return this.name.compareTo(anotherAccount.name);
    }

    @Override
    public String toString() {
        return iban + " " + name + " " + currency
                + " " + balance + " " + closingDate;
    }

    public boolean validatePolishIban() {
        //check if iban starts with "PL"
        //and if the length of iban is 28
        if ((this.getIban().charAt(0) == 80) &&
                (this.getIban().charAt(1) == 76) &&
                (this.getIban().length()) == 28) {
            //check the rest of characters if they are digits
            for (int i = 2; i < 26; i++) {
                if (!Character.isDigit(this.getIban().charAt(i))) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }

    }
}
