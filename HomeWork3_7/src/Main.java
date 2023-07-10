import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Phone> phones = new ArrayList<>();
        phones.add(new Phone("Samsung", "Galaxy S21", 46395));
        phones.add(new Phone("Xiaomi", "Redmi 12", 43990));
        phones.add(new Phone("Apple", "iPhone SE", 39999));
        phones.add(new Phone("HUAWEI", "Galaxy A51", 16995));
        phones.add(new Phone("Xiaomi", "Poco F5 Pro", 41450));

        String company = "Xiaomi";
        List<Phone> applePhones = phones.stream()
                .filter(phone -> phone.getCompany().equals(company))
                .collect(Collectors.toCollection(ArrayList::new));

        System.out.println("Модели телефонов производителя " + company + ":");
        for (Phone phone : applePhones) {
            System.out.println(phone.getModel());
        }
        System.out.println();

        List<Phone> sortedPhones = phones.stream()
                .sorted(Comparator.comparingDouble(Phone::getPrice))
                .collect(Collectors.toList());

        System.out.println("Отсортированный список телефонов:");
        for (Phone phone : sortedPhones) {
            System.out.println("Модель: " + phone.getModel() + ", Стоимость: " + phone.getPrice() + "₽");
        }

    }
}