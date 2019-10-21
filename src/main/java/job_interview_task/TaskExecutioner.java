package job_interview_task;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class TaskExecutioner {

    public List<Account> doTheTask(List<Account> accountList) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-mm-dd");
        Date date = new Date();

        return accountList
                .stream()
                .filter(a -> a.getCurrency().equals("PLN"))
                .filter(b -> Double.valueOf(b.getBalance()) >= 0.0)
                .filter(c -> {
                    try {
                        return simpleDateFormat.parse(c.getClosingDate()).compareTo(date) > -1;
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    return c != null;
                })
                .filter(d -> d.validatePolishIban())
                .sorted()
                .collect(Collectors.toList());
    }
}
